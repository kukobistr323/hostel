package by.bsu.people.administration;

import by.bsu.building.Floor;
import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.logic.Finder;
import by.bsu.people.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Administration {
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
        this.chiefs = chiefs;
        this.commandant = commandant;
        this.security = security;
    }

    public void appointChief(int floorNumber) {
        Student student = Finder.findFutureChiefBy(floorNumber, hostel);
        chiefs.add(floorNumber, commandant.createChief(student));
    }

    public void removeChief(int floorNumber) {
        chiefs.remove(floorNumber);
    }

    public void hostelRounds(int floorNumber) {
        int chance;
        for (Room room : hostel.getFloors()[floorNumber].getRooms()) {
            for (Student student : room.getStudents()) {
                chance = (int) (Math.random() * CHANCE_FOR_COMMENT);
                if (chance == 1) {
                    chiefs.get(floorNumber).makeComment(student);
                }
            }
        }
    }

    public void removeAllDebtors() {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    if (student.isDeptor()) {
                        remove(student);
                    }
                }
            }
        }
    }

    private void remove(Student student) {
        int chance = (int) (Math.random() * 2);
        if (chance == 0) {
            commandant.remove(student);
        } else {
            security.remove(student);
        }
        if (isChief(student)) {
            int floorNumber = student.getRoomNumber() / 100;
            removeChief(floorNumber);
            appointChief(floorNumber);
        }
    }

    private boolean isChief(Student student) {
        return chiefs.contains(student);
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
