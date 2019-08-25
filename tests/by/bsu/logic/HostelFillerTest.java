package by.bsu.logic;

import by.bsu.building.Hostel;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.fillers.HostelFiller;
import org.junit.Test;

public class HostelFillerTest {

    @Test
    public void checkHostelFill() throws FullRoomException {
        Hostel hostel = HostelFactory.createHostel();
        HostelFiller.fillHostel(hostel);
        System.out.println(hostel);
    }

}