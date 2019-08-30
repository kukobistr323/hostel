package by.bsu.logic;

import by.bsu.entity.building.Floor;
import by.bsu.entity.building.Hostel;
import by.bsu.entity.building.Room;
import by.bsu.entity.human.Student;
import by.bsu.entity.human.administration.Chief;

import java.util.ArrayList;
import java.util.List;

public class Finder {

    public static Room findRoomBy(Student student, Hostel hostel) {
        return hostel.getFloors()[student.getRoomNumber() / 100 - 1].getRooms()[student.getRoomNumber() % 10 - 1];
    }

    public static Room findEmptyRoomIn(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                if (room.havePlace()) {
                    return room;
                }
            }
        }
        return null;
    }

    public static Student findFutureChiefBy(int floorNumber, Hostel hostel) {
        for (Room room : hostel.getFloors()[floorNumber - 1].getRooms()) {
            for (Student student : room.getStudents()) {
                if (student.getCourse() > Chief.REQUIRED_COURSE && !student.isDeptor()) {
                    return student;
                }
            }
        }
        return null;
    }

    public static List<Student> findAllDebtors(Hostel hostel) {
        List<Student> debtors = new ArrayList<>();
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    if (student.isDeptor()) {
                        debtors.add(student);
                    }
                }
            }
        }
        return debtors;
    }
}
