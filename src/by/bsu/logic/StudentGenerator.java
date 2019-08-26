package by.bsu.logic;

import by.bsu.people.Student;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.random;

public class StudentGenerator {

    private static List<String> names;
    private static List<String> surnames;
    private static List<String> birthDates;

    static {
        names = Arrays.asList("Artem", "Aleksandr", "Maksim", "Ivan", "Mikhail",
                "Vlad", "Igor", "Aleksey", "Andrey", "Sergey");
        surnames = Arrays.asList("Smirnov", "Ivanov", "Kuznetsov", "Sokolov",
                "Popov", "Lebedev", "Kozlov", "Novikov", "Morozov", "Petrov");
        birthDates = Arrays.asList("19.08.1999", "21.12.1998", "30.07.1999", "14.01.1997",
                "01.02.1998", "05.09.1996", "17.11.1999", "25.09.1996", "29.10.1999", "13.06.1998");
    }

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
