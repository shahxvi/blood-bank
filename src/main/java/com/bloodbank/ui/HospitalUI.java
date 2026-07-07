package com.bloodbank.ui;

import javax.swing.JOptionPane;

import com.bloodbank.io.HospitalFileHandler;
import com.bloodbank.recipient.Hospital;
import com.bloodbank.util.LinkedList;

public class HospitalUI extends UI {
    static HospitalFileHandler hospitalFileHandler = new HospitalFileHandler("data/hospitals.txt");
    static LinkedList hospitalList = hospitalFileHandler.parseRecords();

    /**
     * Menu to manage hospital
     * @author Shah
     */
    public static void menu() {
        Object[] options = { "Add Hospital", "Remove Hospital" };
        int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Manage Hospital List", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (chosenOption) {
            case 0: addHospital(); break;
            case 1: removeHospital(); break;
        }

        hospitalFileHandler.saveRecords(hospitalList);
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

        hospitalList.insertAtBack(new Hospital(name, address, distance, contact));
        JOptionPane.showMessageDialog(null, "Hospital successfully added");
    }

    /**
     * Menu to remove hospital
     * @author Shah
     * @author Iqbal
     */
    public static void removeHospital() {
        Object[] obj = new Object[hospitalList.getSize()];

        Hospital hospital = (Hospital) hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            obj[i++] = hospital.toRecord();
            hospital = (Hospital) hospitalList.getNext();
        }

        String chosenHospital = (String) JOptionPane.showInputDialog(null, "Which hospital would you like to remove?",
                "Remove Item", JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);

        hospital = (Hospital) hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            if (chosenHospital.equals(hospital.toRecord())){
                hospitalList.removeCurrent();
                System.out.println("[SUCCESS] Hospital '" + hospital.getName() + "' successfully removed.");
                break;
            }
            hospital = (Hospital) hospitalList.getNext();
        }
        
    }

    /**
     * Menu to edit hospital from hospital list
     * @author Maya
     */
    public static void editHospital() {
    }
}