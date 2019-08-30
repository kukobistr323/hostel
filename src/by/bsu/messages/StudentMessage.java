package by.bsu.messages;

import by.bsu.entity.human.Student;

public class StudentMessage {
    public static void getNoPaymentMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" didn't pay his tution ");
        System.out.println(sb.toString());
    }
}
