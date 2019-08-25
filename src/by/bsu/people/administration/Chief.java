package by.bsu.people.administration;

import by.bsu.messages.ChiefMessages;
import by.bsu.people.Student;

import java.util.Objects;

public class Chief {

    public static final int REQUIRED_COURSE = 1;
    private Student student;
    private int floor;

    public Chief() {
    }

    public Chief(Student student) {
        this.student = student;
        floor = student.getRoomNumber() / 100;
    }

    public void makeComment(Student student) {
        if (!this.student.equals(student)) {
            student.incrementComments();
            ChiefMessages.commentMessage(student);
        }
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return student.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chief chief = (Chief) o;
        return floor == chief.floor &&
                Objects.equals(student, chief.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, floor);
    }
}
