package com.bloodbank.ui;

import javax.swing.JOptionPane;

import com.bloodbank.Main;
import com.bloodbank.recipient.Hospital;

public class HospitalUI {
    /**
     * Menu to manage hospital
     * @author Shah
     */
    public static void menu() {
        Object[] options = { "Add Hospital", "Remove Hospital", "Edit Hospital", "Search Hospital" };

        boolean exit = false;
        while (!exit) {
            int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Manage Hospital List", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chosenOption) {
                case 0: addHospital(); break;
                case 1: removeHospital(); break;
                case 2: editHospital(); break;
                case 3: searchHospital(); break;
                default: exit = true;
            }
        }

        Main.hospitalFileHandler.saveRecords(Main.hospitalList);
    }

    /**
     * Menu to add hospital
     * @author Isya
     * @author Shah
     */
    public static void addHospital() {
        String name = JOptionPane.showInputDialog("Enter Hospital Name");
        String address = JOptionPane.showInputDialog("Enter Hospital Address");
        String distanceStr = JOptionPane.showInputDialog("Enter Hospital's Distance from Blood Bank (KM)");
        double distance = Double.parseDouble(distanceStr);
        String contact = JOptionPane.showInputDialog("Enter Hospital's Contact Number");

        Main.hospitalList.insertAtBack(new Hospital(Main.hospitalList.getSize() + 1, name, address, distance, contact));
        JOptionPane.showMessageDialog(null, "Hospital successfully added");
    }

    /**
     * Menu to remove hospital
     * @author Shah
     * @author Iqbal
     */
    public static void removeHospital() {
        Object[] obj = new Object[Main.hospitalList.getSize()];

        Hospital hospital = (Hospital) Main.hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            obj[i++] = hospital.getName();
            hospital = (Hospital) Main.hospitalList.getNext();
        }

        String chosenHospital = (String) JOptionPane.showInputDialog(null, "Which hospital would you like to remove?", "Remove Item", JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);
        if (chosenHospital == null) {
            return;
        }

        hospital = (Hospital) Main.hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            if (chosenHospital.equals(hospital.getName())){
                Main.hospitalList.removeCurrent();
                System.out.println("[SUCCESS] Hospital '" + hospital.getName() + "' successfully removed.");
                break;
            }
            hospital = (Hospital) Main.hospitalList.getNext();
        }
    }

    /**
     * Menu to edit hospital from hospital list
     * @author Shah
     * @author Maya
     */
    public static void editHospital() {
        String hospitalIdStr = JOptionPane.showInputDialog("Enter Hospital ID to Update: ");
        if (hospitalIdStr == null) {
            return;
        }

        int hospitalId = Integer.parseInt(hospitalIdStr);

        boolean found = false;
        Hospital hospital = (Hospital) Main.hospitalList.getFirst();
        while (hospital != null && !found) {
            if (hospital.getHospitalId() == hospitalId) {
                found = true;
            } else {
                hospital = (Hospital) Main.hospitalList.getNext();
            }
        }

        if (!found && hospital == null) {
            JOptionPane.showMessageDialog(null, "Error: No Mathcing Hospital ID Found");
            return;
        }

        boolean exit = false;
        while (!exit) {
            Object[] options = { "Edit Hospital Name" , "Edit Hospital's Address", "Update Hospital's Distance", "Update Hospital's Contact Number" };
            int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Update Hospital Details", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chosenOption) {
                case 0: hospital.setName(JOptionPane.showInputDialog("Enter Hospital's New Name")); break;
                case 1: hospital.setAddress(JOptionPane.showInputDialog("Enter Hospital's New Address")); break;
                case 2: hospital.setDistance(Double.parseDouble(JOptionPane.showInputDialog("Enter Hospital's New Distance"))); break;
                case 3: hospital.setContact(JOptionPane.showInputDialog("Enter Hospital's New Name")); break;
                default: exit = true;
            }

            if (!exit) {
                JOptionPane.showMessageDialog(null, "Hospital details updated successfully!");
            }
        }
    }

    /**
     * Menu to search for a hospital
     * @author Marzell
     */
    public static void searchHospital() {
        if (Main.donorQueue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Donor Queue is Empty");
            return;
        }

        Object[] searchOption = { "Search by hospital ID", "Search by address" };
        int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your search method", "Search hospital", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, searchOption, searchOption[0]);

        if (chosenOption == -1){
            return;
        }

        String keywordHospital;

        if (chosenOption == 0){
            keywordHospital = JOptionPane.showInputDialog(null, "Enter hospital ID");
        } else {
            keywordHospital = JOptionPane.showInputDialog(null, "Enter hospital address");
        }

        if (keyword == null || keyword.isEmpty()){
            return;
        }

        Hospital foundHospital = null;
        Hospital currentHospital = (Hospital) Main.hospitalQueue.getFirst();

        while (currentHospital != null) {
            boolean matches;
            if (chosenOption == 0) {
                matches = current.getNRIC().equalsIgnoreCase(keyword);
            } else {
                matches = current.getName().equalsIgnoreCase(keyword);
            }

            if (matches) {
                foundHospital = currentHospital;
                break;
            }

            currentHospital = (Hospital) Main.hospitalQueue.getNext();
        }

        if (foundHospital != null) {
            JOptionPane.showMessageDialog(null, "Hospital Found:\n\n" + foundHospital);
        } else {
            JOptionPane.showMessageDialog(null, "\nNo hospital matching " + keyword + "was found in the queue");
        }
    }
}