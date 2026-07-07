// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.bloodbank.person.Donor;
import com.bloodbank.recipient.Hospital;
import com.bloodbank.transfusion.Blood;
import com.bloodbank.transfusion.BloodBag;
import com.bloodbank.util.LinkedList;

public class FileHandler {
    protected File file;

    /**
     * Instantiate a FileHandler
     * @param filePath
     */
    public FileHandler(String filePath) {
        file = new File(filePath);
    }

    /**
     * @return LinkedList of hospital's blood bags list
     */
    public LinkedList parseRecords() {
        LinkedList objects = new LinkedList();

        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");

                // Hospital
                int hospitalId = Integer.parseInt(tokens.nextToken());
                String name = tokens.nextToken();
                String address = tokens.nextToken();
                double distance = Double.parseDouble(tokens.nextToken());
                String contact = tokens.nextToken();


                int noBloodBags = Integer.parseInt(tokens.nextToken());


                ArrayList<BloodBag> bloodBags = new ArrayList<>();

                for(int i = 0; i < noBloodBags; i++){
                    String nric = tokens.nextToken();
                    name = tokens.nextToken();
                    contact = tokens.nextToken();
                    Blood blood = new Blood(tokens.nextToken(), Double.parseDouble(tokens.nextToken()));
                    LocalDateTime transfusionDateTime = LocalDateTime.parse(tokens.nextToken());

                    BloodBag bloodBag = new BloodBag(new Donor(nric, name, contact, blood), transfusionDateTime);
                    bloodBags.add(bloodBag);
                }

                Hospital hospital = new Hospital(name, address, distance, contact, bloodBags);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }

    /**
     * Write saved objects to file
     * @return true if file is saved

    public boolean saveRecords(LinkedList objects) {
        if (objects == null) {
            return false;
        }

        try (PrintWriter outputFile = new PrintWriter(file)) {
            T obj = (T) objects.getFirst();
            while (obj != null) {
                outputFile.println(obj.toRecord());
                obj = (T) objects.getNext();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
    */

    /**
     * @return the number of records in a file
     */
    protected int getCount() {
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
