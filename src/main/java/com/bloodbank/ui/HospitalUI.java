package com.bloodbank.ui;

import javax.swing.JOptionPane;

import com.bloodbank.recipient.Hospital;
import com.bloodbank.util.LinkedList;

public class HospitalUI extends UI {
    /**
     * Menu to manage hospital
     * @author Shah
     */
    public static void menu(LinkedList hospitalList) {

        Object[] options = { "Add Hospital", "Remove Hospital" };
        String str = "Please choose your option";

        int chosenOption = JOptionPane.showOptionDialog(null, str, "Manage Hospital List", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        System.out.println(chosenOption);

        switch (chosenOption) {
            case 0:
                addHospital(hospitalList);
                break;
            case 1:
                removeHospital();
                break;
        }
    }

    /**
     * Menu to add hospital
     * @author Isya
     * @author Shah
     */
    public static void addHospital(LinkedList hospitalList) {
        String name = JOptionPane.showInputDialog("Enter Hospital Name");
        String address = JOptionPane.showInputDialog("Enter Hospital Address");
        String distanceStr = JOptionPane.showInputDialog("Enter Hospital's Distance from Blood Bank (KM)");
        double distance = Double.parseDouble(distanceStr);
        String contact = JOptionPane.showInputDialog("Enter Hospital's Contact Number");

        hospitalList.insertAtBack(new Hospital(name, address, distance, contact));
        JOptionPane.showMessageDialog(null, "Hospital successfully added");
    }

    /**
     * Menu to remove hospital
     * @author Iqbal
     */
    public static void removeHospital() {
    }

    /**
     * Menu to edit hospital from hospital list
     * @author Maya
     */
    public static void editHospital() {
    }
}