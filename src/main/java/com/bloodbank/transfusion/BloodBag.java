// MIT LICENSE
// Copyright (c) 2026 Marzell
// Copyright (c) 2026 Shah

package com.bloodbank.transfusion;

import com.bloodbank.person.Donor;

import java.time.LocalDateTime;

public class BloodBag {
    private Donor donor;
    private LocalDateTime transfusionDateTime;
    private static final int SHELF_LIFE_DAYS = 42;
    private double volume;

    public BloodBag(Donor donor, LocalDateTime transfusionDateTime, double volume) {
        this.donor = donor;
        this.transfusionDateTime = transfusionDateTime;
        this.volume = volume;
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

    public double getRedCellVolume() {
        final double redCellPercentage = 0.445;
        return volume * redCellPercentage;
    }


    public double getPlasmaVolume() {
        final double plasmaPercentage = 0.545;
        return volume * plasmaPercentage;
    }

    public double getPlateletVolume() {
        final double plateletPercentage = 0.01;
        return volume * plateletPercentage;
    }

    @Override
    public String toString() {
        return  "Donor's NRIC: " +donor.getNRIC() +
                "\nTransfusion date: " + getTransfusionDateTime() +
                "\nExpiry date: " + getExpiryDate() +
                "\nIs Expired: " + isExpired();
    }

    public String toRecord() {
        return donor.toRecord() + ";" + transfusionDateTime + ";" + volume;
    }
}
