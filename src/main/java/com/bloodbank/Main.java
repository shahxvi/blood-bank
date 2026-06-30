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
        UI.login(staffList);

        while (!logout) {
            switch (UI.mainMenu()) {
                case "Manage Donor Queue":
                    DonorUI.menu();
                    break;
                case "Manage Blood Bag":
                    BloodBagUI.menu();
                    break;
                case "Manage Hospital List":
                    HospitalUI.menu(hospitalList);
                    break;
                case "":
                    logout = true;
            }
        }

        hospitalFileHandler.saveRecords(hospitalList);
        staffFileHandler.saveRecords(staffList);
    }
}