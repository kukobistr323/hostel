package by.bsu.entity.human.administration;

import by.bsu.entity.building.Hostel;
import by.bsu.entity.building.Room;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.Finder;
import by.bsu.logic.StudentGenerator;
import by.bsu.messages.AdministrationMessages;
import by.bsu.entity.human.Student;

import java.util.*;

import static java.lang.Math.*;

public class Administration implements StudentRemoval {
    public static final int CHANCE_FOR_COMMENT = 4;
    private Hostel hostel;
    private List<Chief> chiefs;
    private Commandant commandant;
    private Security security;

    public Administration() {
        chiefs = new ArrayList<>(6);
    }


    public Administration(Hostel hostel, Commandant commandant, Security security) {
        this();
        this.hostel = hostel;
        this.commandant = commandant;
        this.security = security;
    }

    public void appointChief(int floorNumber) {
        Student student = Finder.findFutureChiefBy(floorNumber, hostel);
        chiefs.add(floorNumber - 1, commandant.createChief(student));
    }

    public void removeChief(int floorNumber) {
        try {
            AdministrationMessages.getRemoveMessage(chiefs.get(floorNumber - 1));
            Thread.sleep(1000);
            chiefs.remove(floorNumber - 1);
        } catch (InterruptedException ex) {
        }
    }

    public void hostelRounds() {
        for (int i = 1; i <= Hostel.FLOORS; i++) {
            hostelRounds(i);
        }
    }

    public void hostelRounds(int floorNumber) {
        try {
            int chance;
            for (Room room : hostel.getFloors()[floorNumber - 1].getRooms()) {
                for (Student student : room.getStudents()) {
                    chance = (int) (random() * CHANCE_FOR_COMMENT);
                    if (chance == 1) {
                        chiefs.get(floorNumber - 1).makeComment(student);
                        Thread.sleep(1000);
                    }
                }
            }
        } catch (InterruptedException ex) {
        }
    }

    public void settleStudents(int count) throws FullHostelException, FullRoomException {
        try {
            for (int i = 0; i < count; i++) {
                commandant.settle(StudentGenerator.generateNormalStudent());
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }

    public void removeAllDebtors() {
        List<Student> debtors = Finder.findAllDebtors(hostel);
        if (!debtors.isEmpty()) {
            debtors.forEach(student -> evict(student));
        }
    }

    @Override
    public void evict(Student student) {
        try {
            StudentRemoval administrator = whoRemove();
            administrator.evict(student);
            Thread.sleep(1000);
            if (isChief(student)) {
                int floorNumber = student.getRoomNumber() / 100;
                removeChief(floorNumber);
                Thread.sleep(1000);
                appointChief(floorNumber);
            }
        } catch (InterruptedException ex) {
        }
    }

    private StudentRemoval whoRemove() {
        int chance = (int) (random() * 2);
        return chance == 0 ? commandant : security;
    }

    private boolean isChief(Student student) {
        return chiefs.contains(new Chief(student));
    }

    public List<Chief> getChiefs() {
        return chiefs;
    }

    public void setChiefs(List<Chief> chiefs) {
        this.chiefs = chiefs;
    }

    public Commandant getCommandant() {
        return commandant;
    }

    public void setCommandant(Commandant commandant) {
        this.commandant = commandant;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administration that = (Administration) o;
        return Objects.equals(hostel, that.hostel) &&
                Objects.equals(chiefs, that.chiefs) &&
                Objects.equals(commandant, that.commandant) &&
                Objects.equals(security, that.security);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostel, chiefs, commandant, security);
    }
}
