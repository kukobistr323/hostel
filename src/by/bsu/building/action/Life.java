package by.bsu.building.action;

import by.bsu.building.Hostel;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.HostelFactory;
import by.bsu.logic.HostelFiller;

public class Life {

    private Hostel hostel;

    public Life() {
        hostel = HostelFactory.createHostel();
    }

    public void start() {
        try {
            HostelFiller.fillHostel(hostel);
            System.out.println(hostel);
        } catch (FullRoomException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
