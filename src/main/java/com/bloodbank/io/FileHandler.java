// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

import com.bloodbank.util.LinkedList;

public class FileHandler {
    protected File file;

    /**
     * Instantiate a FileHandler
     * @param filePath
     */
    protected FileHandler(String filePath) {
        file = new File(filePath);
        objects = new LinkedList();
    }

    /**
     * @return LinkedList of hospital's blood bags list
     */
    protected LinkedList parseRecords() {
        LinkedList objects = new LinkedList();

        try (Scanner fileReader = new Scanner(super.file)) {
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");

                // Hospital
                int hospitalId = Integer.parseInt(tokens.nextToken());
                String name = tokens.nextToken();
                String address = tokens.nextToken();
                double distance = Double.parseDouble(tokens.nextToken());
                String contact = tokens.nextToken();

                Hospital hospital = new Hospital(hospitalId, name, address, distance, contact);

                ArrayList<BloodBag> bloodBags = new ArrayList<>();

                // Blood Bag
                String nric = tokens.nextToken();
                String name = tokens.nextToken();
                String contact = tokens.nextToken();
                Blood blood = new Blood(tokens.nextToken(), Double.parseDouble(tokens.nextToken()));
                LocalDateTime transfusionDateTime = LocalDateTime.parse(tokens.nextToken());

                BloodBag = new BloodBag(BloodBag(bloodBagId, new Donor(nric, name, contact, blood), transfusionDateTime));

                //super.objects.insertAtBack(new BloodBag(bloodBagId, new Donor(nric, name, contact, blood), transfusionDateTime));
                //super.objects.insertAtBack(new Hospital(hospitalId, name, address, distance, contact));
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
