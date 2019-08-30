package by.bsu.logic;

import by.bsu.entity.human.Student;

import static by.bsu.constants.Constants.*;
import static java.lang.Math.random;

public class StudentGenerator {

    public static Student generateStudentWithRoomNumber(int roomNumber) {
        return new Student(generateName(), generateSurname(), generateBirthDate(),
                generateCourse(), 0, roomNumber, true, true);
    }

    public static Student generateNormalStudent() {
        return new Student(generateName(), generateSurname(), generateBirthDate(),
                generateCourse(), 0, 0, true, true);
    }

    public static Student generateStudentWithoutPass(){
        return new Student(generateName(), generateSurname(), generateBirthDate(),
                generateCourse(), 0, 0, true, false);
    }

    private static String generateName() {
        int index = (int) (random() * names.size());
        return names.get(index);
    }

    private static String generateSurname() {
        int index = (int) (random() * surnames.size());
        return surnames.get(index);
    }

    private static String generateBirthDate() {
        int index = (int) (random() * birthDates.size());
        return birthDates.get(index);
    }

    private static int generateCourse() {
        return (int) (random() * 4 + 1);
    }
}
