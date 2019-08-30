package by.bsu.entity.human.administration;

import by.bsu.entity.building.Hostel;
import by.bsu.entity.building.Room;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.Finder;
import by.bsu.messages.CommandantMessages;
import by.bsu.entity.human.Human;
import by.bsu.entity.human.Student;
import by.bsu.logic.observer.Observer;

import java.util.Objects;

public class Commandant extends Human implements StudentRemoval {

    private Hostel hostel;
    private Observer observer;

    public Commandant() {
        super();
        hostel = new Hostel();
        observer = new Observer();
    }

    public Commandant(String name, String surname, String birthDate,
                      Hostel hostel, Observer observer) {
        super(name, surname, birthDate);
        this.hostel = hostel;
        this.observer = observer;
    }

    public Chief createChief(Student student) {
        CommandantMessages.getCreateChiefMessage(student);
        return new Chief(student);
    }

    public void settle(Student student) throws FullHostelException, FullRoomException {
        Room room = Finder.findEmptyRoomIn(hostel);
        if (room == null) {
            throw new FullHostelException("The hostel is full");
        } else {
            room.settleStudent(student);
            observer.addObservable(student);
            CommandantMessages.getSettleMessage(student);
        }
    }

    @Override
    public void evict(Student student) {
        Room room = Finder.findRoomBy(student, this.hostel);
        room.removeStudent(student);
        observer.removeObservable(student);
        CommandantMessages.getRemoveMessage(student);
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commandant that = (Commandant) o;
        return Objects.equals(hostel, that.hostel) &&
                Objects.equals(observer, that.observer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hostel, observer);
    }
}
