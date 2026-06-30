// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import com.bloodbank.ui.*;
import com.bloodbank.util.LinkedList;
import com.bloodbank.io.HospitalFileHandler;
import com.bloodbank.io.StaffFileHandler;

public class Main {
    static StaffFileHandler staffFileHandler = new StaffFileHandler("data/staffs.txt");
    static LinkedList staffList = staffFileHandler.parseRecords();

    static HospitalFileHandler hospitalFileHandler = new HospitalFileHandler("data/hospitals.txt");
    static LinkedList hospitalList = hospitalFileHandler.parseRecords();

    static boolean logout = false;

    public static void main(String[] args) {
        if (UI.login(staffList) != null) {
            while (!logout) {
                String chosenOption = UI.mainMenu();

                if (chosenOption.equals("Manage Donor Queue"))
                    DonorUI.menu();
                else if (chosenOption.equals("Manage Blood Bag"))
                    BloodBagUI.menu();
                else if (chosenOption.equals("Manage Hospital List"))
                    HospitalUI.menu(hospitalList);
                else
                    logout = true;
            }
        }

        hospitalFileHandler.saveRecords(hospitalList);
        staffFileHandler.saveRecords(staffList);
    }
}