// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.staff;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.bloodbank.io.FileHandler;

public class StaffFileHandler extends FileHandler<Staff> {
    public StaffFileHandler(String inputFilePath) {
        super(inputFilePath);
        objects = new Staff[super.getCount()];
    }

    @Override
    protected Staff[] praseRecods() {
        try (Scanner fileReader = new Scanner(super.file)) {
            int i = 0;
            while (fileReader.hasNext()) {
                StringTokenizer tokens = new StringTokenizer(fileReader.nextLine(), ";");
                // objects[i++] = new Staff(tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return objects;
    }
}