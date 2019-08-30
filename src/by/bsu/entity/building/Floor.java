package by.bsu.entity.building;

import java.util.Arrays;
import java.util.Objects;

public class Floor {
    private int numberOfRooms;
    private Room rooms[];

    public Floor() {
        this(5);
    }

    public Floor(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        rooms = new Room[numberOfRooms];
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberStudentsOnFloor() {
        int counter = 0;
        for (Room room : rooms) {
            counter += room.getNumberStudentsInRoom();
        }
        return counter;
    }

    public int getFreePlaceCount() {
        int counter = 0;
        for (Room room : rooms) {
            counter += room.getFreePlaceCount();
        }
        return counter;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Floor on ").append(numberOfRooms).append(" rooms\n");
        for (int i = 0; i < numberOfRooms; i++) {
            sb.append(rooms[i]).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return numberOfRooms == floor.numberOfRooms &&
                Arrays.equals(rooms, floor.rooms);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRooms);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }
}
