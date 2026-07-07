// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.transfusion;

public class Blood {
    private String group;

    public Blood(String group) {
        this.group = group.toUpperCase();
    }

    /* Getters */
    public String getGroup() {
        return group;
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
    /* Getters */

    /* Printers */
    public String toString() {
        return "Blood Group: " + group +
               "\nPlasma Antibody: " + getPlasmaAntibody();
    }

    public String toRecord() {
        return group;
    }
    /* Printers */
}
