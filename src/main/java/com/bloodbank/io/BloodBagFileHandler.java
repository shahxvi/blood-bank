// MIT LICENSE
// Copyright (c) 2026 Marzell

package com.bloodbank.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import com.bloodbank.person.Donor;
import com.bloodbank.recipient.Hospital;
import com.bloodbank.transfusion.Blood;
import com.bloodbank.transfusion.BloodBag;
import com.bloodbank.util.LinkedList;

public class BloodBagFileHandler {
    private File file;

    /**
     * Instantiate a FileHandler
     * @param filePath
     */
    public BloodBagFileHandler(String filePath) {
        file = new File(filePath);
    }

    /**
     * @return LinkedList of hospital's blood bags list
     */
    public LinkedList parseRecords() {
        LinkedList objects = new LinkedList();

        Hospital hospital = null;

        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");

                String nric = tokens.nextToken();
                String name = tokens.nextToken();
                String contact = tokens.nextToken();
                Blood blood = new Blood(tokens.nextToken());
                LocalDateTime transfusionDateTime = LocalDateTime.parse(tokens.nextToken());
                double bloodVolume = Double.parseDouble(tokens.nextToken());

                BloodBag bloodBag = new BloodBag(new Donor(nric, name, contact, blood), transfusionDateTime, bloodVolume);
                objects.insertAtBack(bloodBag);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }

    /**
     * Write saved objects to file
     * @return true if file is saved
     */

    public boolean saveRecords(Stack<BloodBag> bloodBagStack) {
        if (bloodBagStack == null || bloodBagStack.isEmpty()) {
            return false;
        }

        try (PrintWriter outputFile = new PrintWriter(file)) {
            BloodBag bloodBag = bloodBagStack.pop();
            while (bloodBag != null) {
                outputFile.println(bloodBag.toRecord());
                bloodBag = (BloodBag) bloodBagStack.pop();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * @return the number of records in a file
     */
    protected int getSize() {
        int i = 0;
        try (Scanner inputFile = new Scanner(file)) {
            while (inputFile.hasNext()) {
                i++;
                inputFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return i;
    }
}
