package com.bloodbank.ui;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.bloodbank.person.Staff;
import com.bloodbank.util.LinkedList;

public class UI {
    static Scanner keyboard = new Scanner(System.in);

    /**
     * Menu for staffs
     * @author Shah
     */
    public static String mainMenu() {

        String[] options = { "Manage Donor Queue", "Manage Blood Bag" , "Manage Hospital List" };
        String chosenOption = (String) JOptionPane.showInputDialog(null, "Please choose an inventory",
                "Choose Inventory", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (chosenOption == null) {
            return "";
        }

        return chosenOption;
    }

    /**
     * Login menu for staffs
     * @return Logged in Staff
     * @author Shah
     */
    public static Staff login(LinkedList staffList) {
        String id = null;
        String password = null;
        boolean loggedIn = false;

        Staff loggedInStaff = null;

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

        return loggedInStaff;
    }
}