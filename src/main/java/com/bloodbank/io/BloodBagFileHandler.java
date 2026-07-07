// MIT LICENSE
// Copyright (c) 2026 Marzell
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import com.bloodbank.person.Donor;
import com.bloodbank.transfusion.BloodBag;
import com.bloodbank.transfusion.Blood;
import com.bloodbank.util.LinkedList;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BloodBagFileHandler extends FileHandler<BloodBag> {
    public BloodBagFileHandler(String filePath){
        super(filePath);
    }

    @Override
    protected LinkedList parseRecords() {
        try (Scanner fileReader = new Scanner(super.file)) {
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");

                int bloodBagId = Integer.parseInt(tokens.nextToken());
                String nric = tokens.nextToken();
                String name = tokens.nextToken();
                String contact = tokens.nextToken();
                Blood blood = new Blood(tokens.nextToken(), Double.parseDouble(tokens.nextToken()));
                LocalDateTime transfusionDateTime = LocalDateTime.parse(tokens.nextToken());

                super.objects.insertAtBack(new BloodBag(bloodBagId, new Donor(nric, name, contact, blood), transfusionDateTime));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }

}
