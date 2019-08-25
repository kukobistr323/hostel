package by.bsu.logic.fillers;

import by.bsu.building.Floor;
import by.bsu.building.Hostel;
import by.bsu.building.Room;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.StudentGenerator;
import by.bsu.people.administration.Commandant;

public class HostelFiller {

    public static void fillHostel(Hostel hostel, Commandant commandant) throws FullRoomException, FullHostelException {
        int roomNumber = 101;
        int tempRoomNumber;
        for (Floor floor : hostel.getFloors()) {
            tempRoomNumber = roomNumber;
            for (Room room : floor.getRooms()) {
                for (int i = 0; i < Room.NUMBER_OF_STUDENTS; i++) {
                    commandant.settle(StudentGenerator.generateStudentWithRoomNumber(roomNumber));
                }
                roomNumber++;
            }
            roomNumber = tempRoomNumber + 100;
        }
    }
}
