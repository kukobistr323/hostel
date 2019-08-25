package by.bsu.people.administration;

import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.Finder;
import by.bsu.people.Human;
import by.bsu.people.Student;

import java.util.Objects;

public class Commandant extends Human implements Removal {

    private Hostel hostel;

    public Commandant() {
        super();
        hostel = new Hostel();
    }

    public Commandant(String name, String surname, String birthDate, Hostel hostel) {
        super(name, surname, birthDate);
        this.hostel = hostel;
    }

    public void settle(Student student) throws FullHostelException, FullRoomException {
        Room room = Finder.findEmptyRoom(this.hostel);
        if (room == null) {
            throw new FullHostelException("The hostel is full");
        } else {
            room.settleStudent(student);
        }
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
        Commandant that = (Commandant) o;
        return Objects.equals(hostel, that.hostel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hostel);
    }
}
