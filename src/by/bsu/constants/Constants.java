package by.bsu.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final int SLEEP = 1000;
    public static final List<String> names;
    public static final List<String> surnames;
    public static final List<String> birthDates;
    public static final String COMMANDANT_NAME = "Aleksey";
    public static final String COMMANDANT_SURNAME = "Petrovich";
    public static final String COMMANDANT_BIRTH_DATE = "19.12.1960";
    public static final String SECURITY_NAME = "Eduard";
    public static final String SECURITY_SURNAME = "Kuzmin";
    public static final String SECURITY_BIRTH_DATE = "15.02.1990";

    static {
        names = Arrays.asList("Artem", "Aleksandr", "Maksim", "Ivan", "Mikhail",
                "Vlad", "Igor", "Aleksey", "Andrey", "Sergey");
        surnames = Arrays.asList("Smirnov", "Ivanov", "Kuznetsov", "Sokolov",
                "Popov", "Lebedev", "Kozlov", "Novikov", "Morozov", "Petrov");
        birthDates = Arrays.asList("19.08.1999", "21.12.1998", "30.07.1999", "14.01.1997",
                "01.02.1998", "05.09.1996", "17.11.1999", "25.09.1996", "29.10.1999", "13.06.1998");
    }
}
