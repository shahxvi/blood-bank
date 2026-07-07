// MIT LICENSE
// Copyright (c) 2026 Marzell
// Copyright (c) 2026 Shah

package com.bloodbank.transfusion;

import com.bloodbank.person.Donor;
import com.bloodbank.io.Recordable;

import java.time.LocalDateTime;

public class BloodBag implements Recordable {
    private Donor donor;
    private LocalDateTime transfusionDateTime;
    private static final int SHELF_LIFE_DAYS = 42;

    public BloodBag(Donor donor, LocalDateTime transfusionDateTime) {
        this.donor = donor;
        this.transfusionDateTime = transfusionDateTime;
    }

    public int getBloodBagId() {
        return bloodBagId;
    }

    public Donor getDonor() {
        return donor;
    }

    public LocalDateTime getTransfusionDateTime() {
        return transfusionDateTime;
    }

    public LocalDateTime getExpiryDate() {
        return transfusionDateTime.plusDays(SHELF_LIFE_DAYS);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(getExpiryDate());
    }

    @Override
    public String toString() {
        return  "Donor's NRIC: " +donor.getNRIC() +
                "\nTransfusion date: " + getTransfusionDateTime() +
                "\nExpiry date: " + getExpiryDate() +
                "\nIs Expired: " + isExpired();
    }

    @Override
    public String toRecord() {
        return donor.toRecord() + ";" + transfusionDateTime;
    }
}
