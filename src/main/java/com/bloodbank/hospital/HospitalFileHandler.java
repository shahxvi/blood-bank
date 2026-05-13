// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.hospital;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;

import com.bloodbank.io.FileHandler;

public class HospitalFileHandler extends FileHandler<Hospital> {
    public HospitalFileHandler(String inputFilePath) {
        super(inputFilePath);
        objects = new Hospital[super.getCount()];
    }

    @Override
    public Hospital[] praseRecods() {
        try (Scanner fileReader = new Scanner(super.file)) {
            int i = 0;
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");
                objects[i++] = new Hospital(tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }
}