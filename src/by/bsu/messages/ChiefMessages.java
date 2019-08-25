package by.bsu.messages;

import by.bsu.people.Student;

public class ChiefMessages {

    public static void commentMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append("In the ").append(student.getRoomNumber()).append(" chief made a comment to ")
                .append(student.getName()).append(" ").append(student.getSurname());
        System.out.println(sb.toString());
    }
}
