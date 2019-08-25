package by.bsu.logic;

import by.bsu.building.Floor;
import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.people.Student;

public class Finder {

    public static Room findRoomBy(Student student, Hostel hostel) {
        return hostel.getFloors()[student.getRoomNumber() / 100].getRooms()[student.getRoomNumber() % 10];
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
}
