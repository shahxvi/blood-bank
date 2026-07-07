// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import javax.swing.JOptionPane;

import com.bloodbank.io.HospitalFileHandler;
import com.bloodbank.recipient.Hospital;
import com.bloodbank.ui.*;
import com.bloodbank.util.LinkedList;
import com.bloodbank.util.Queue;

public class Main {
    static HospitalFileHandler h = new HospitalFileHandler("data/hospitals.txt");
    static LinkedList hospitalList = h.parseRecords();

    public static void main(String[] args) {
        System.out.println(hospitalList.getSize());
        boolean logout = false;
        while (!logout) {
            Object[] options = {"List blood bags", "", ""};
            int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chosenOption) {
                case 0:
                    listBloodBags();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    logout = true;
            }
        }
    }

    public static void listBloodBags() {
        Object[] obj = new Object[hospitalList.getSize()];

        if (obj.length == 0) {
            return;
        }

        Hospital hospital = (Hospital) hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            obj[i++] = hospital.getName();
            hospital = (Hospital) hospitalList.getNext();
        }

        System.out.println(obj[0].toString());

        String chosenHospital = (String) JOptionPane.showInputDialog(null, "Which hospital would you like to check", "Check Blood Bag", JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);
        if (chosenHospital == null) {
            return;
        }

        hospital = (Hospital) hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            if (chosenHospital.equals(hospital.getName())) {
                break;
            }
            hospital = (Hospital) hospitalList.getNext();
        }

        for(int j = 0; j < hospital.getBloodBags().size(); j++) {
            JOptionPane.showMessageDialog(null, hospital.getBloodBags().toString());
        }
    }
}
