package by.bsu.messages;

import by.bsu.entity.human.Student;

public class CommandantMessages {

    public static void getSettleMessage(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was settled by commandant in ").append(student.getRoomNumber()).append(" room");
        System.out.println(sb.toString());
    }

    public static void getRemoveMessage(Student student){
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was removed by commandant from ").append(student.getRoomNumber())
                .append(" room because: ").append(student.getReasonOfEvict());
        System.out.println(sb.toString());
    }

    public static void getCreateChiefMessage(Student student){
        StringBuilder sb = new StringBuilder();
        sb.append(student.getName()).append(" ").append(student.getSurname())
                .append(" was appointed by commandant to chief of the floor ");
        System.out.println(sb.toString());
    }
}
