// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

public class Blood {
    private String bloodGroup;
    private double volume;
    private String bloodAntibody;
    private String plasmaAntibody;
    private double redCellVolume;
    private double plasmaVolume;
    private double plateletVolume;

    public Blood(String bloodGroup, double volume) {
        this.bloodGroup = bloodGroup;
        this.bloodAntibody = bloodGroup;
        this.volume = volume;

        if (bloodGroup.equalsIgnoreCase("A")) {
            this.plasmaAntibody = "B";
        } else if (bloodGroup.equalsIgnoreCase("B")) {
            this.plasmaAntibody = "A";
        } else if (bloodGroup.equalsIgnoreCase("AB")) {
            this.plasmaAntibody = "";
        } else if (bloodGroup.equalsIgnoreCase("O")) {
            this.plasmaAntibody = "AB";
        }

        final double redCellPercentage = 0.445;
        final double plasmaPercentage = 0.545
        final double plateletPercentage = 0.01;

        this.redCellVolume = volume * redCellPercentage;
        this.plasmaVolume = volume * plasmaPercentage;
        this.plateletVolume = volume * plateletPercentage;
    }

    /* Getters */
    public String getBloodGroup () {
        return bloodGroup;
    }

    public double getVolume () {
        return volume;
    }

    public String getBloodAntibody () {
        return bloodAntibody;
    }

    public String getPlasmaAntibody () {
        return plasmaAntibody;
    }

    public double getRedCellVolume () {
        return redCellVolume;
    }

    public double getPlasmaVolume () {
        return plasmaVolume;
    }

    public double getPlateletVolume () {
        return plateletVolume;
    }
    /* Getters */
}
