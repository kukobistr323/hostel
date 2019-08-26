package by.bsu.people.administration;

import by.bsu.building.Hostel;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.HostelFactory;
import by.bsu.logic.fillers.ChiefsFiller;
import by.bsu.logic.fillers.HostelFiller;
import by.bsu.people.Student;
import by.bsu.people.observer.Observer;
import org.junit.*;

public class AdministrationTest {

    private Hostel hostel;
    private Commandant commandant;
    private Security security;
    private Observer observer;
    private Administration administration;

    @Before
    public void beforeTest() throws FullRoomException, FullHostelException {
        hostel = HostelFactory.createHostel();
        observer = new Observer();
        commandant = new Commandant("Aleksey", "Petrovich", "19.12.1960",
                hostel, observer);
        security = new Security("Eduard", "Kuzmin", "15.02.1990",
                hostel, observer);
        administration = new Administration(hostel, commandant, security);
        HostelFiller.fillHostel(hostel, commandant);
        ChiefsFiller.appointChiefs(administration);
    }

    @Test
    public void checkRemoveChiefs() {
        Student student = administration.getChiefs().get(0).getStudent();
        administration.remove(student);
    }

    @Test
    public void checkRemoveAll() {
        observer.setNewYear();
        administration.removeAllDebtors();
    }

}