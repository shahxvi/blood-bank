package com.bloodbank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bloodbank.transfusion.Blood;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void bloodTest() {
        Blood blood = new Blood("A", 1);
        assertEquals("A", blood.getGroup());
        assertEquals("A", blood.getBloodAntibody());

        assertEquals("B", blood.getPlasmaAntibody());

        assertEquals(0.445, blood.getRedCellVolume());
        assertEquals(0.545, blood.getPlasmaVolume());
        assertEquals(0.01, blood.getPlateletVolume());
    }
}
