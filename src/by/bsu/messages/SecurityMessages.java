package by.bsu.messages;

import by.bsu.entity.human.Student;

public class SecurityMessages {

    public static void getStopMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was stopped by security. He has no pass");
        System.out.println(sb.toString());
    }

    public static void getRemoveMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was removed by security from ").append(student.getRoomNumber())
                .append(" room because: ").append(student.getReasonOfEvict());
        System.out.println(sb.toString());
    }
}
