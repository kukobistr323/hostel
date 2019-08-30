package by.bsu.entity.building;

import by.bsu.entity.human.administration.Commandant;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.HostelFactory;
import by.bsu.logic.observer.Observer;
import org.junit.*;

public class HostelsTest {

    private Hostel hostel;
    private Commandant commandant;

    @Before
    public void beforeTest() {
        hostel = HostelFactory.createHostel();
        commandant = new Commandant("Aleksey", "Petrovich", "19.12.1960",
                hostel, new Observer());
    }

    @Test
    public void checkFillHostel() throws FullHostelException, FullRoomException {
        Hostels.fillHostel(hostel, commandant);
    }

    @Test
    public void checkSetNonPayingStudents() throws FullHostelException, FullRoomException {
        Hostels.fillHostel(hostel, commandant);
        Hostels.setNonPayingStudents(hostel);
    }
}