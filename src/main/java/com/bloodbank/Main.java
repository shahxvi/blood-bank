// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank;

import javax.swing.JOptionPane;

import com.bloodbank.io.*;
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

    static BloodBagFileHandler bloodBagFileHandler = new BloodBagFileHandler("data/bloodBags.txt");
    static LinkedList bloodBagList = bloodBagFileHandler.parseRecords();

    static Queue donorQueue = new Queue();
    static Queue tempQueue = new Queue();

    static Stack<BloodBag> bloodBagStack = new Stack<>();

    static LinkedList aBloodBagList = new LinkedList();
    static LinkedList bBloodBagList = new LinkedList();
    static LinkedList oBloodBagList = new LinkedList();
    static LinkedList abBloodBagList = new LinkedList();

    public static void main(String[] args) {
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
        Object[] options = { "Stored Blood Bags", "Sent Out Blood Bags" };
        int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (chosenOption == 0) {

        } else if (chosenOption == 1) {
            Hospital hospital = (Hospital) hospitalList.getFirst();
            for (int i = 0; i < obj.length; i++) {
                obj[i++] = hospital.getName();
                hospital = (Hospital) hospitalList.getNext();
            }

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

            // TODO: Courasell menu fo
            for(int j = 0; j < hospital.getBloodBags().size(); j++) {
                JOptionPane.showMessageDialog(null, hospital.getBloodBags().toString());
            }
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

        bloodBagStack.add(new BloodBag(donor, LocalDateTime.now(), volume));
        JOptionPane.showMessageDialog(null, "Blood Bag Added to Stack");
    }

    static void transferBloodBag() {
        if (bloodBagStack.isEmpty() || bloodBagStack == null){
            return;
        }

        // 1. Choose Blood Bag Group to Send = bloodGroup
        Object[] bloodG = {"A", "B", "AB", "O"};
        int chosenOption = JOptionPane.showOptionDialog(null, "Please Choose Blood Group to Send", "Choose Blood Group", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, bloodG, bloodG[0]);
        String bloodGroup = null;

        switch (chosenOption) {
            case 0: bloodGroup = "A"; break;
            case 1: bloodGroup = "B"; break;
            case 2: bloodGroup = "AB"; break;
            case 3: bloodGroup = "O"; break;
        }

        // 2. Choose Hospital to Send Chosen Blood Bag = hospital
        Object[] obj = new Object[hospitalList.getSize()];
        Hospital hospital = (Hospital) hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            obj[i++] = hospital.getName();
            hospital = (Hospital) hospitalList.getNext();
        }
        String chosenHospital = (String) JOptionPane.showInputDialog(null, "Which hospital would you like to send blood bag to?", "Send blood bag", JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);
        if (chosenHospital == null) return;

        hospital = (Hospital) hospitalList.getFirst();
        for (int i = 0; i < obj.length; i++) {
            if (chosenHospital.equals(hospital.getName())) {
                break;
            }
            hospital = (Hospital) hospitalList.getNext();
        }

        // 3. Send one chosen blood bag group to the hospital
        int size = 0;
        if (bloodGroup.contains("A"))       size = aBloodBagList.getSize();
        else if (bloodGroup.contains("B"))  size = bBloodBagList.getSize();
        else if (bloodGroup.contains("AB")) size = abBloodBagList.getSize();
        else if (bloodGroup.contains("O"))  size = oBloodBagList.getSize();

        obj = new Object[size];
        int i = 0;
        while (i < obj.length) {
            obj[i] = i++;
        }

        String numberToSendStr = (String) JOptionPane.showInputDialog(null, "Which hospital would you like to send blood bag to?", "Send blood bag", JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);
        if (numberToSendStr == null) return;
        int numberToSend = Integer.parseInt(numberToSendStr);

        for (int j = 0; j < numberToSend; j++) {
            if (bloodGroup.contains("A"))       hospital.getBloodBags().add((BloodBag) aBloodBagList.removeFromFront());
            else if (bloodGroup.contains("B"))  hospital.getBloodBags().add((BloodBag) bBloodBagList.removeFromFront());
            else if (bloodGroup.contains("AB")) hospital.getBloodBags().add((BloodBag) abBloodBagList.removeFromFront());
            else if (bloodGroup.contains("O"))  hospital.getBloodBags().add((BloodBag) oBloodBagList.removeFromFront());
        }
    }

    static void sortBloodBagStack() {
        BloodBag bloodBag = bloodBagStack.pop();
        while (bloodBag != null) {
            bloodBag = bloodBagStack.pop();
            String bloodGroup = bloodBag.getDonor().getBlood().getGroup();
            if (bloodGroup.contains("A"))       aBloodBagList.insertAtBack(bloodBag);
            else if (bloodGroup.contains("B"))  bBloodBagList.insertAtBack(bloodBag);
            else if (bloodGroup.contains("AB")) abBloodBagList.insertAtBack(bloodBag);
            else if (bloodGroup.contains("O"))  oBloodBagList.insertAtBack(bloodBag);
        }
    }

    static void sortBloodBagList() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; i < aBloodBagList.getSize(); i++) {
                if (j == 1) { bloodBagStack.push((BloodBag) aBloodBagList.removeFromFront());
                } else if (j == 2) { bloodBagStack.push((BloodBag) bBloodBagList.removeFromFront());
                } else if (j == 3) { bloodBagStack.push((BloodBag) abBloodBagList.removeFromFront());
                } else if (j == 4) { bloodBagStack.push((BloodBag) oBloodBagList.removeFromFront());
                }
            }
        }
    }
}
