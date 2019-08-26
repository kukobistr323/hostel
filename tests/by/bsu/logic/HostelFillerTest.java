package by.bsu.logic;

import by.bsu.building.Hostel;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.fillers.HostelFiller;
import by.bsu.people.administration.Commandant;
import org.junit.Test;

public class HostelFillerTest {

    @Test
    public void checkHostelFill() throws FullRoomException, FullHostelException {
        Hostel hostel = HostelFactory.createHostel();
        Commandant commandant = new Commandant();
        HostelFiller.fillHostel(hostel, commandant);
        System.out.println(hostel);
    }

}