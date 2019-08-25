package by.bsu.messages;

import by.bsu.people.Student;

public class SecurityMessages {

    public static void stopMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was stopped by security. He has no pass");
        System.out.println(sb.toString());
    }

    public static void removeMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was removed by security from ").append(student.getRoomNumber()).append(" room");
        System.out.println(sb.toString());
    }
}
