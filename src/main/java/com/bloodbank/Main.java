// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import javax.swing.JOptionPane;

import com.bloodbank.io.HospitalFileHandler;
import com.bloodbank.person.Staff;
import com.bloodbank.ui.*;
import com.bloodbank.util.LinkedList;
import com.bloodbank.util.Queue;

public class Main {
    public static HospitalFileHandler hospitalFileHandler = new HospitalFileHandler("data/hospitals.txt");
    public static LinkedList hospitalList = hospitalFileHandler.parseRecords();
    public static Queue donorQueue = new Queue();

    public static void main(String[] args) {
        if (login() == null) {
            return;
        }

        boolean logout = false;
        while (!logout) {
            Object[] options = { "Manage Blood Bag" , "Manage Donors", "Manage Hospital List" };
            int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chosenOption) {
                case 0: BloodBagUI.menu(); break;
                case 1: DonorUI.menu(); break;
                case 2: HospitalUI.menu(); break;
                default: logout = true;
            }
        }
    }
}
