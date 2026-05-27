// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import javax.swing.JOptionPane;

import com.bloodbank.io.StaffFileHandler;
import com.bloodbank.person.Staff;
import com.bloodbank.util.LinkedList;

public class Main {
    static Staff loggedInStaff;
    static LinkedList staffList = new StaffFileHandler("data/staffs.txt").parseRecords();

    public static void main(String[] args) {
        login();
    }

    /**
     * Login menu for staffs
     * @author Shah
     */
    static void login() {
        String id = null;
        String password = null;
        boolean loggedIn = false;

        do {
            id = JOptionPane.showInputDialog("Blood Bank Management System\n\nPlease enter your ID");
            if (id == null) {
                break;
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
    }
}
