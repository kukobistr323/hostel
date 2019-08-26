package by.bsu.messages;

import by.bsu.people.Student;
import by.bsu.people.administration.Chief;

public class AdministrationMessages {

    public static void removeMessage(Chief chief) {
        Student student = chief.getStudent();
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was removed from chief position ");
        System.out.println(sb.toString());
    }
}
