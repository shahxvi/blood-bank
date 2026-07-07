package com.bloodbank.ui;

import javax.swing.*;
import com.bloodbank.Main;
import javax.swing.JOptionPane;

public class BloodBagUI {
    /**
     * Menu for blood bag operations
     * @author Shah
     * @author Marzell
     */
    public static void menu() {
        Object[] options = { "Add Blood Bag", "Remove Blood Bag", "Edit Blood Bag", "Search Blood Bag" };

        boolean exit = false;
        while (!exit) {
            int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Manage Blood Bag List", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chosenOption) {
                case 0: addBloodBag(); break;
                case 1: removeBloodBag(); break;
                case 2: editBloodBag(); break;
                case 3: searchBloodBag(); break;
                default: exit = true;
            }
        }

        Main.bloodBagFileHandler.saveRecords(Main.bloodBagList);
    }

    public static void queueDonor() {
        Main.donorQueue;
        String nric = JOptionPane.showInputDialog("Enter NRIC:");
        String name = JOptionPane.showInputDialog("Enter name:");
        String contact = JOptionPane.showInputDialog("Enter contact:");
        Blood blood = JOptionPane.showInputDialog("Enter blood type:");


    }

    public static void bloodBagSender() {

    }

    public static void bloodBagChecker() {
        Main.hospitalList
        Main.bloodBagList
        Object[] obj = new Object[Main.hospitalList.getSize()];

        Hospital hospital = (Hospital) Main.hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            obj[i++] = hospital.getName();
            hospital = (Hospital) Main.hospitalList.getNext();
        }

        String chosenHospital = (String) JOptionPane.showInputDialog(null, "Which hospital would you like to check?", "Check blood bag", JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);
        if (chosenHospital == null) {
            return;
        }

        hospital = (Hospital) Main.hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            if (chosenHospital.equals(hospital.getName())){
                break;
            }
            hospital = (Hospital) Main.hospitalList.getNext();
        }

    }
}