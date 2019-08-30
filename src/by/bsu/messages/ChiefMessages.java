package by.bsu.messages;

import by.bsu.entity.human.Student;

public class ChiefMessages {

    public static void getCommentMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append("In the ").append(student.getRoomNumber()).append(" chief made a comment to ")
                .append(student.getName()).append(" ").append(student.getSurname());
        System.out.println(sb.toString());
    }
}
