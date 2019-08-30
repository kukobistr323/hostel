package by.bsu.logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {

    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }
}
