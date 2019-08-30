package by.bsu.logic;

import by.bsu.entity.building.Hostel;
import org.junit.Test;

public class HostelFactoryTest {

    @Test
    public void checkHostelCreation() {
        Hostel hostel = HostelFactory.createHostel();
    }
}