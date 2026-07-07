package com.bloodbank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bloodbank.io.FileHandler;
import com.bloodbank.util.LinkedList;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void FileHandlerTest() {
        FileHandler h = new FileHandler("data/hospitals.txt");
        LinkedList hospitalList = h.parseRecords();
        assertTrue(hospitalList != null);
    }
}
