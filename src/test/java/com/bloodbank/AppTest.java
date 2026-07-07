package com.bloodbank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bloodbank.io.HospitalFileHandler;
import com.bloodbank.util.LinkedList;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void HospitalFileHandlerTest() {
        HospitalFileHandler h = new HospitalFileHandler("data/hospitals.txt");
        LinkedList hospitalList = h.parseRecords();
        assertTrue(hospitalList.getFirst() != null);
    }
}
