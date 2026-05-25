// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import com.bloodbank.io.Recordable;

public class Blood implements Recordable {
    private String group;
    private double volume;

    public Blood(String group, double volume) {
        this.group = group.toUpperCase();
        this.volume = volume;
    }

    /* Getters */
    public String getGroup() {
        return group;
    }

    public double getVolume() {
        return volume;
    }

    public String getBloodAntibody() {
        return group;
    }

    public String getPlasmaAntibody() {
        String plasmaAntibody = "";

        if (group.contains("AB")) {
            plasmaAntibody = "";
        } else if (group.contains("B")) {
            plasmaAntibody = "A";
        } else if (group.contains("A")) {
            plasmaAntibody = "B";
        } else if (group.contains("O")) {
            plasmaAntibody = "AB";
        }

        return plasmaAntibody;
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
    /* Getters */

    /* Printers */
    public String toString() {
        return "Blood Group: " + group +
               "\nPlasma Antibody: " + getPlasmaAntibody() + 
               "\nFull Volume : " + volume + "mL" +
               "\nRed Blood Cell Volume: " + getRedCellVolume() + "mL" +
               "\nPlasma Volume: " + getPlasmaVolume() + "mL" +
               "\nPlatelet Volume: " + getPlateletVolume() + "mL";
    }

    public String toRecord() {
        return String.format("%s;%f", group, volume);
    }
    /* Printers */
}