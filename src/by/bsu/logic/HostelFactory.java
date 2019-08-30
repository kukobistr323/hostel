package by.bsu.logic;

import by.bsu.entity.building.Floor;
import by.bsu.entity.building.Hostel;
import by.bsu.entity.building.Room;

public class HostelFactory {

    public static Hostel createHostel() {
        Hostel hostel = new Hostel();
        for (int i = 0; i < Hostel.FLOORS; i++) {
            Floor floor = new Floor();
            hostel.getFloors()[i] = floor;
            for (int j = 0; j < floor.getNumberOfRooms(); j++) {
                Room room = new Room((i + 1) * 100 + j + 1);
                floor.getRooms()[j] = room;
            }
        }
        return hostel;
    }
}
