// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.bloodbank.transfusion.Blood;
import com.bloodbank.person.Donor;
import com.bloodbank.util.LinkedList;

public class DonorFileHandler extends FileHandler<Donor> {
    public DonorFileHandler(String filePath) {
        super(filePath);
    }

    @Override
    public LinkedList parseRecords() {
        try (Scanner fileReader = new Scanner(super.file)) {
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");

                String nric = tokens.nextToken();
                String name = tokens.nextToken();
                int contact = Integer.parseInt(tokens.nextToken());
                Blood blood = new Blood(tokens.nextToken(), Double.parseDouble(tokens.nextToken()));

                super.objects.insertAtFront(new Donor(nric, name, contact, blood));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }
}
