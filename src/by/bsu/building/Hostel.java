package by.bsu.building;

import java.util.Arrays;

public class Hostel {
    public static final int FLOORS = 6;
    private Floor floors[];

    public Hostel() {
        floors = new Floor[FLOORS];
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hostel on ").append(FLOORS).append(" floors\n");
        for (int i = 0; i < FLOORS; i++) {
            sb.append(floors[i]).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hostel hostel = (Hostel) o;
        return Arrays.equals(floors, hostel.floors);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(floors);
    }
}
