package by.bsu.action;

import by.bsu.building.Hostel;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.HostelFactory;
import by.bsu.logic.fillers.HostelFiller;
import by.bsu.people.administration.Administration;
import by.bsu.people.administration.Commandant;
import by.bsu.people.administration.Security;
import by.bsu.people.observer.Observer;

public class Life {

    private Hostel hostel;
    private Observer observer;
    private Commandant commandant;
    private Security security;
    private Administration administration;

    public Life() {
        hostel = HostelFactory.createHostel();
        observer = new Observer();
        commandant = new Commandant("Aleksey", "Petrovich", "19.12.1960",
                hostel, observer);
        security = new Security("Eduard", "Kuzmin", "15.02.1990",
                hostel, observer);
        Administration administration = new Administration(hostel, commandant, security);

    }

    public void start() {
        try {
            HostelFiller.fillHostel(hostel, commandant);
            while (true) {

            }
        } catch (FullRoomException | FullHostelException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
