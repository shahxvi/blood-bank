package com.bloodbank.ui;

import javax.swing.JOptionPane;

import com.bloodbank.util.LinkedList;

public class HospitalUI extends UI {
    /**
     * Menu to manage hospital
     * @author Shah
     */
    public static void menu(LinkedList hospitalList) {

        Object[] options = { "Add Hospital", "Remove Hospital" };
        String str = "Please choose your option";

        int chosenOption = JOptionPane.showOptionDialog(null, str, "Manage Hospital List", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (chosenOption) {
            case 1:
                addHospital();
                break;
            case 2:
                removeHospital();
                break;
        }
    }

    /**
     * Menu to add hospital
     * @author Isya
     */
    public static void addHospital() {
    }

    /**
     * Menu to remove hospital
     * @author Iqbal
     */
    public static void removeHospital() {
    }
}