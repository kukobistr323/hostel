package by.bsu.people.administration;

import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.logic.Finder;
import by.bsu.messages.SecurityMessages;
import by.bsu.people.Human;
import by.bsu.people.Student;
import by.bsu.people.observer.Observer;

import java.util.Objects;

public class Security extends Human implements Removal {

    private Hostel hostel;
    private Observer observer;

    public Security() {
        super();
        hostel = new Hostel();
        observer = new Observer();
    }

    public Security(String name, String surname, String birthDate,
                    Hostel hostel, Observer observer) {
        super(name, surname, birthDate);
        this.hostel = hostel;
        this.observer = observer;
    }

    public void stop(Student student) {
        SecurityMessages.stopMessage(student);
    }

    @Override
    public void remove(Student student) {
        Room room = Finder.findRoomBy(student, this.hostel);
        room.removeStudent(student);
        observer.removeObservable(student);
        SecurityMessages.removeMessage(student);
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
        Security security = (Security) o;
        return Objects.equals(hostel, security.hostel) &&
                Objects.equals(observer, security.observer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hostel, observer);
    }
}
