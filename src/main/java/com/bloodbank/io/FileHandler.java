// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.bloodbank.util.LinkedList;

public abstract class FileHandler<T extends Recordable> {
    protected File file;
    protected LinkedList objects;

    /**
     * Instantiate a FileHandler
     * @param filePath
     */
    protected FileHandler(String filePath) {
        file = new File(filePath);
        objects = new LinkedList();
    }

    /**
     * Reads all records from file and converts them
     * into an array of objects of type {@code T}.
     *
     * @return an array containing all parsed records from the file
     */
    protected abstract LinkedList parseRecords();

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
