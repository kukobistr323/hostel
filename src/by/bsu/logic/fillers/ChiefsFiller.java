package by.bsu.logic.fillers;

import by.bsu.building.Hostel;
import by.bsu.people.administration.Administration;

public class ChiefsFiller {

    public static void appointChiefs(Administration administration) {
        for (int i = 0; i < Hostel.FLOORS; i++) {
            administration.appointChief(i);
        }
    }
}
