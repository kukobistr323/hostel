package by.bsu.entity.building;

import by.bsu.entity.human.administration.Commandant;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;

public class Floors {

    public static void fillFloor(Floor floor, Commandant commandant) throws FullRoomException, FullHostelException {
        for (Room room : floor.getRooms()) {
            Rooms.fillRoom(room, commandant);
        }
    }

    public static void setNonPayingStudents(Floor floor) {
        for (Room room : floor.getRooms()) {
            Rooms.setNonPayingStudents(room);
        }
    }
}
