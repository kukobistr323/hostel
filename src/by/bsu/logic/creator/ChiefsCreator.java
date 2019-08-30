package by.bsu.logic.creator;

import by.bsu.entity.building.Hostel;
import by.bsu.entity.human.administration.Administration;

public class ChiefsCreator {

    public static void appointChiefs(Administration administration) {
        for (int i = 1; i <= Hostel.FLOORS; i++) {
            administration.appointChief(i);
        }
    }
}
