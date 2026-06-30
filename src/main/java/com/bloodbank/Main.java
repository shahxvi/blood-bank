// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import com.bloodbank.ui.*;

public class Main {
    static boolean logout = false;
    public static void main(String[] args) {
        if (UI.login() != null) {
            while (!logout) {
                String chosenOption = UI.mainMenu();

                if (chosenOption.equals("Manage Donor Queue"))
                    DonorUI.menu();
                else if (chosenOption.equals("Manage Blood Bag"))
                    BloodBagUI.menu();
                else if (chosenOption.equals("Manage Hospital List"))
                    HospitalUI.menu();
                else
                    logout = true;
            }
        }
    }
}