package by.bsu.entity.building;

import by.bsu.excepions.FullRoomException;
import by.bsu.excepions.SettleStudentException;
import by.bsu.entity.human.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {
    public static final int NUMBER_OF_STUDENTS = 3;
    private int roomNumber;
    private List<Student> students;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        students = new ArrayList<>();
    }

    public Room(ArrayList<Student> students) throws SettleStudentException {
        if (students.size() > NUMBER_OF_STUDENTS) {
            this.students = new ArrayList<>();
            throw new SettleStudentException("Lot of students for this room");
        } else {
            this.students = students;
        }
    }

    public void settleStudent(Student student) throws FullRoomException {
        if (students.size() > NUMBER_OF_STUDENTS) {
            throw new FullRoomException("The room is full");
        }
        students.add(student);
        student.setRoomNumber(roomNumber);
    }

    public int getFreePlaceCount() {
        return NUMBER_OF_STUDENTS - students.size();
    }

    public int getNumberStudentsInRoom() {
        return students.size();
    }

    public boolean havePlace() {
        return students.size() < NUMBER_OF_STUDENTS;
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room ").append(roomNumber).append(". Students:\n");
        students.forEach(student -> sb.append(student.getName())
                .append(" ").append(student.getSurname()).append("\n"));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber &&
                Objects.equals(students, room.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, students);
    }
}
