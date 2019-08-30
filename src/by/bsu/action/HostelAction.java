package by.bsu.action;

import by.bsu.entity.building.Hostel;
import by.bsu.entity.building.Hostels;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.HostelFactory;
import by.bsu.logic.StudentGenerator;
import by.bsu.logic.creator.ChiefsCreator;
import by.bsu.entity.human.administration.Administration;
import by.bsu.entity.human.administration.Commandant;
import by.bsu.entity.human.administration.Security;
import by.bsu.logic.observer.Observer;

import static by.bsu.constants.Constants.*;

public class HostelAction {

    private Hostel hostel;
    private Observer observer;
    private Commandant commandant;
    private Security security;
    private Administration administration;

    public HostelAction() {
        hostel = HostelFactory.createHostel();
        observer = new Observer();
        commandant = new Commandant(COMMANDANT_NAME, COMMANDANT_SURNAME, COMMANDANT_BIRTH_DATE,
                hostel, observer);
        security = new Security(SECURITY_NAME, SECURITY_SURNAME, SECURITY_BIRTH_DATE,
                hostel, observer);
        administration = new Administration(hostel, commandant, security);
    }

    public void start() {
        try {
            Hostels.fillHostel(hostel, commandant);
            ChiefsCreator.appointChiefs(administration);
            while (true) {
                administration.settleStudents(hostel.getFreePlaceCount() * 4 / 5);
                administration.hostelRounds();
                security.stop(StudentGenerator.generateStudentWithoutPass());
                Hostels.setNonPayingStudents(hostel);
                security.stop(StudentGenerator.generateStudentWithoutPass());
                observer.setNewYear();
                administration.removeAllDebtors();
            }
        } catch (FullRoomException | FullHostelException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
