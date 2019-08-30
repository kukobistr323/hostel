package by.bsu.logic;

import org.junit.*;

import java.time.LocalDate;

public class ParserTest {

    @Test
    public void checkParser() {
        LocalDate date = Parser.parseDate("19.08.2000");
        System.out.println(date);
    }
}