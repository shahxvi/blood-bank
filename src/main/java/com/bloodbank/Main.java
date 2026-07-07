// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import javax.swing.JOptionPane;

import com.bloodbank.io.HospitalFileHandler;
import com.bloodbank.io.StaffFileHandler;
import com.bloodbank.person.Staff;
import com.bloodbank.ui.*;
import com.bloodbank.util.LinkedList;
import com.bloodbank.util.Queue;

public class Main {
    public static StaffFileHandler staffFileHandler = new StaffFileHandler("data/staffs.txt");
    public static LinkedList staffList = staffFileHandler.parseRecords();
    public static HospitalFileHandler hospitalFileHandler = new HospitalFileHandler("data/hospitals.txt");
    public static LinkedList hospitalList = hospitalFileHandler.parseRecords();
    public static Queue donorQueue = new Queue();
    public static Queue hospitalQueue = new Queue();

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

    /**
     * Login menu for staffs
     * @return Logged in Staff
     * @author Shah
     */
    public static Staff login() {
        boolean bypass = false; // FOR DEVELOPERS
        if (bypass) {
            return (Staff) staffList.getFirst();
        }

        String id = null;
        String password = null;
        boolean loggedIn = false;

        Staff loggedInStaff = null;

        do {
            id = JOptionPane.showInputDialog("Blood Bank Management System\n\nPlease enter your ID");
            if (id == null) {
                return null;
            }

            password = JOptionPane.showInputDialog("Please enter your password");
            if (password == null || id.isEmpty()) {
                continue;
            }

            loggedInStaff = (Staff) staffList.getFirst();
            while (loggedInStaff != null) {
                if (loggedInStaff.verifyCredentials(id, password)) {
                    JOptionPane.showMessageDialog(null, "Welcome " + loggedInStaff.getName() + "!");
                    loggedIn = true;
                    break;
                }
                loggedInStaff = (Staff) staffList.getNext();
            }
            if (!loggedIn) {
                JOptionPane.showMessageDialog(null, "Incorrect ID or Password");
            }
        } while (!loggedIn);

        return loggedInStaff;
    }
}