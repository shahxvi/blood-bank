// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import javax.swing.JOptionPane;

import com.bloodbank.io.HospitalFileHandler;
import com.bloodbank.person.Donor;
import com.bloodbank.recipient.Hospital;
import com.bloodbank.transfusion.Blood;
import com.bloodbank.transfusion.BloodBag;
import com.bloodbank.util.LinkedList;
import com.bloodbank.util.Queue;

import java.time.LocalDateTime;
import java.util.Stack;

public class Main {
    static HospitalFileHandler hospitalFileHandler = new HospitalFileHandler("data/hospitals.txt");
    static LinkedList hospitalList = hospitalFileHandler.parseRecords();
    static Queue donorQueue = new Queue();
    static Queue tempQueue = new Queue();
    static Stack<BloodBag> bloodStack = new Stack<>();

    public static void main(String[] args) {
        System.out.println(hospitalList.getSize());
        boolean logout = false;
        while (!logout) {
            Object[] options = { "List Blood Bags", "Add donor", "Blood Transfusion", "Transfer Blood Bag" };
            int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chosenOption) {
                case 0: listBloodBags(); break;
                case 1: addDonor(); break;
                case 2: bloodTransfusion(); break;
                case 3: transferBloodBag(); break;
                default: logout = true;
            }
        }

        hospitalFileHandler.saveRecords(hospitalList);
    }

    static void listBloodBags() {
        Object[] obj = new Object[hospitalList.getSize()];
        if (obj.length == 0) {
            return;
        }

        // TODO: add options
        //Object[] options = { "Stored Blood Bags", "Sent Out Blood Bags" };
        //int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

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

    static void addDonor() {
        String ic = JOptionPane.showInputDialog(null, "Enter Donor's IC");
        String name = JOptionPane.showInputDialog(null, "Enter Donor's Name");
        String contact = JOptionPane.showInputDialog(null, "Enter Donor's Contact");

        /* Blood Group */
        String bloodGroup = "";

        Object[] bloodG = {"A", "B", "AB", "O"};
        int chosenOption = JOptionPane.showOptionDialog(null, "Please Choose Donor's Blood Group", "Donor's Blood Group", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, bloodG, bloodG[0]);
        switch (chosenOption) {
            case 0: bloodGroup = "A"; break;
            case 1: bloodGroup = "B"; break;
            case 2: bloodGroup = "AB"; break;
            case 3: bloodGroup = "O"; break;
        }
        /* Blood Group */

        /* Rh Group */
        Object[] rh = {"+", "-"};
        chosenOption = JOptionPane.showOptionDialog(null, "Please Choose Donor's Blood Rh", "Donor's Blood Group", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rh, rh[0]);
        switch (chosenOption) {
            case 0: bloodGroup += "+"; break;
            case 1: bloodGroup += "-"; break;
        }
        /* Blood Group */

        Blood blood = new Blood(bloodGroup);
        Donor donor = new Donor(ic, name, contact, blood);
        donorQueue.enqueue(donor);

        JOptionPane.showMessageDialog(null, "Donor " + donor.getName() + " Added to Queue");
    }

    static void bloodTransfusion() {
        if (donorQueue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Donor Queue is Empty");
            return;
        }

        Donor donor = (Donor) donorQueue.dequeue();
        double volume = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter " + donor.getName() + " Transfusion Volume (mL)"));

        bloodStack.add(new BloodBag(donor, LocalDateTime.now(), volume));
        JOptionPane.showMessageDialog(null, "Blood Bag Added to Stack");
    }

    static void transferBloodBag() {
    }
}