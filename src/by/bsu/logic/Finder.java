package by.bsu.logic;

import by.bsu.building.Floor;
import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.people.Student;
import by.bsu.people.administration.Chief;

public class Finder {

    public static Room findRoomBy(Student student, Hostel hostel) {
        return hostel.getFloors()[student.getRoomNumber() / 100 - 1].getRooms()[student.getRoomNumber() % 10 - 1];
    }

    public static Room findEmptyRoom(Hostel hostel) {
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
}
