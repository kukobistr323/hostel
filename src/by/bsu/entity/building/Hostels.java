package by.bsu.entity.building;

import by.bsu.entity.human.administration.Commandant;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;

public class Hostels {

    public static void fillHostel(Hostel hostel, Commandant commandant) throws FullRoomException, FullHostelException {
        for (Floor floor : hostel.getFloors()) {
            Floors.fillFloor(floor, commandant);
        }
    }

    public static void setNonPayingStudents(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            Floors.setNonPayingStudents(floor);
        }
    }


}
