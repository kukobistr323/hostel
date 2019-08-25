package by.bsu.logic;

import by.bsu.building.Floor;
import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.excepions.FullRoomException;

public class HostelFiller {

    public static void fillHostel(Hostel hostel) throws FullRoomException {
        int roomNumber = 101;
        int tempRoomNumber;
        for (Floor floor : hostel.getFloors()) {
            tempRoomNumber = roomNumber;
            for (Room room : floor.getRooms()) {
                for (int i = 0; i < Room.NUMBER_OF_STUDENTS; i++) {
                    room.settleStudent(StudentGenerator.generateStudentWithRoomNumber(roomNumber));
                }
                roomNumber++;
            }
            roomNumber = tempRoomNumber + 100;
        }
    }
}
