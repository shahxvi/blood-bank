// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class FileHandler<T extends Recordable> {
    protected File file;
    protected T[] objects;

    protected FileHandler(String filePath) {
        file = new File(filePath);
    }

    protected abstract T[] praseRecods();

    protected boolean saveRecords() {
        if (objects == null) {
            return false;
        }

        try (PrintWriter outputFile = new PrintWriter(file)) {
            for (int i = 0; i < getCount(); i++) {
                outputFile.println(objects[i].toRecord());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

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