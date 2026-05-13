// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class FileHandler<T extends Recordable> {
    protected File file;
    protected T[] objects;

    /**
     * Instantiate a FileHandler
     * @param filePath
     */
    protected FileHandler(String filePath) {
        file = new File(filePath);
    }

    /**
     * Reads all records from file and converts them
     * into an array of objects of type {@code T}.
     *
     * @return an array containing all parsed records from the file
     */
    protected abstract T[] praseRecods();

    /**
     * Write saved objects to file
     * @return true if file is saved
     */
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