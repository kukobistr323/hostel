package by.bsu.people;

import by.bsu.people.observer.Observable;

import java.util.Objects;

public class Student extends Human implements Observable {
    public static final int COMMENTS_FOR_REMOVE = 2;
    public static final int COURSE_FOR_REMOVE = 4;
    private int course;
    private int comments;
    private int roomNumber;
    private boolean payment;
    private boolean pass;

    public Student() {
        super();
    }

    public Student(String name, String surname, String birthDate, int course, int roomNumber) {
        super(name, surname, birthDate);
        this.course = course;
        this.course = 1;
        this.roomNumber = roomNumber;
        this.payment = true;
    }

    public Student(String name, String surname, String birthDate,
                   int course, int comments, int roomNumber, boolean payment, boolean pass) {
        super(name, surname, birthDate);
        this.course = course;
        this.comments = comments;
        this.roomNumber = roomNumber;
        this.payment = payment;
        this.pass = pass;
    }

    public boolean isDeptor() {
        return !payment || comments > COMMENTS_FOR_REMOVE || course > COURSE_FOR_REMOVE;
    }

    @Override
    public void newYear() {
        course++;
        comments = 0;
    }

    public void incrementComments() {
        comments++;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nCourse: ").append(course)
                .append("\nComments: ").append(comments)
                .append("\nRoom number: ").append(roomNumber)
                .append("\nPaid tution: ").append(payment ? "Yes" : "No")
                .append("\nPass: ").append(pass ? "Yes" : "No");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return course == student.course &&
                comments == student.comments &&
                roomNumber == student.roomNumber &&
                payment == student.payment &&
                pass == student.pass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), course, comments, roomNumber, payment, pass);
    }
}
