package by.bsu.people.administration;

import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.logic.Finder;
import by.bsu.people.Human;
import by.bsu.people.Student;

import java.util.Objects;

public class Security extends Human implements Removal {

    private Hostel hostel;

    public Security() {
        super();
        hostel = new Hostel();
    }

    public Security(String name, String surname, String birthDate, Hostel hostel) {
        super(name, surname, birthDate);
        this.hostel = hostel;
    }

    @Override
    public void remove(Student student) {
        Room room = Finder.findRoomBy(student, this.hostel);
        room.removeStudent(student);
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
        if (!super.equals(o)) return false;
        Security that = (Security) o;
        return Objects.equals(hostel, that.hostel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hostel);
    }
}
