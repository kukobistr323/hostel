package by.bsu.logic;

import by.bsu.building.Hostel;
import org.junit.Test;

import static org.junit.Assert.*;

public class HostelFactoryTest {

    @Test
    public void checkHostelCreation() {
        Hostel hostel = HostelFactory.createHostel();
    }
}