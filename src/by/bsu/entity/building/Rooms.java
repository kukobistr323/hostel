package by.bsu.entity.building;

import by.bsu.constants.Constants;
import by.bsu.entity.human.administration.Commandant;
import by.bsu.excepions.FullHostelException;
import by.bsu.excepions.FullRoomException;
import by.bsu.logic.StudentGenerator;
import by.bsu.messages.StudentMessage;

public class Rooms {

    private static final int CHANCE_FOR_NON_PAYING = 10;

    public static void fillRoom(Room room, Commandant commandant) throws FullRoomException, FullHostelException {
        while (room.havePlace()) {
            commandant.settle(StudentGenerator.generateStudentWithRoomNumber(room.getRoomNumber()));
        }
    }

    public static void setNonPayingStudents(Room room) {
        room.getStudents().forEach(student -> {
            if ((int) (Math.random() * CHANCE_FOR_NON_PAYING) == 1) {
                try {
                    student.setPayment(false);
                    StudentMessage.getNoPaymentMessage(student);
                    Thread.sleep(Constants.SLEEP);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
