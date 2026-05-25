// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.bloodbank.recipient.Hospital;
import com.bloodbank.util.LinkedList;

public class HospitalFileHandler extends FileHandler<Hospital> {
    public HospitalFileHandler(String inputFilePath) {
        super(inputFilePath);
    }

    @Override
    public LinkedList parseRecords() {
        try (Scanner fileReader = new Scanner(super.file)) {
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");

                String name = tokens.nextToken();
                String address = tokens.nextToken();
                double distance = Double.parseDouble(tokens.nextToken());
                int contact = Integer.parseInt(tokens.nextToken());

                super.objects.insertAtFront(new Hospital(name, address, distance, contact));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }
}
