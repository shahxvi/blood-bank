// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.recipient;

import com.bloodbank.transfusion.BloodBag;

import java.util.ArrayList;

public class Hospital {
    private String name;
    private String address;
    private String contact;
    private ArrayList<BloodBag> bloodBags;

    public Hospital(String name, String address, String contact, ArrayList<BloodBag> bloodBags) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.bloodBags = bloodBags;
    }

    /* Setters */
    public void setName (String name) {
        this.name = name;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public void setContact (String contact) {
        this.contact = contact;
    }

    public void setBloodBags (ArrayList<BloodBag> bloodBags) {
        this.bloodBags = bloodBags;
    }

    /* Setters */

    /* Getters */
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public ArrayList<BloodBag> getBloodBags() {
        return bloodBags;
    }
    /* Getters */

    /* Printers */
    public String toString() {
        return "Name: " + name +
               "\nAddress: " + address +
               "\nContact: " + contact +
               "\nBlood Bags: " + bloodBags;
    }

    public String toRecord(int recordNumber) {
        return name + ";" + address + ";" + contact + ";" + bloodBags.size() + ";" + bloodBags.get(recordNumber).toRecord();
    }
    /* Printers */
}
