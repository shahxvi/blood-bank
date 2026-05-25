// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.bloodbank.person.Staff;
import com.bloodbank.util.LinkedList;

public class StaffFileHandler extends FileHandler<Staff> {
    public StaffFileHandler(String inputFilePath) {
        super(inputFilePath);
    }

    @Override
    public LinkedList parseRecords() {
        try (Scanner fileReader = new Scanner(super.file)) {
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");

                String nric = tokens.nextToken();
                String name = tokens.nextToken();
                int contact = Integer.parseInt(tokens.nextToken());
                int id = Integer.parseInt(tokens.nextToken());
                String password = tokens.nextToken();

                super.objects.insertAtBack(new Staff(nric, name, contact, id, password));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }
}
