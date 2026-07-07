// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.recipient;

import com.bloodbank.io.Recordable;

import java.util.ArrayList;

public class Hospital implements Recordable {
    private int hospitalId;
    private String name;
    private String address;
    private double distance;
    private String contact;
    private ArrayList<BloodBag> bloodBags;

    public Hospital(int hospitalId, String name, String address, double distance, String contact, ArrayList<BloodBag> bloodBags) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.contact = contact;
        this.bloodBags = bloodBags;
    }

    /* Setters */
    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public void setDistance (double distance) {
        this.distance = distance;
    }

    public void setContact (String contact) {
        this.contact = contact;
    }

    public void setBloodBags (ArrayList<BloodBag> bloodBags) {
        this.bloodBags = bloodBags;
    }

    /* Setters */

    /* Getters */
    public int getHospitalId() {
        return hospitalId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public void getBloodBags() {
        return bloodBags;
    }
    /* Getters */

    /* Printers */
    public String toString() {
        return "Hospital ID: " + hospitalId +
               "\nName: " + name +
               "\nAddress: " + address +
               "\nContact: " + contact +
               "\nBlood Bags: " + bloodBags;
    }

    public String toRecord() {
        return hospitalId + ";" + name + ";" + address + ";" + contact + ";" + bloodBags;
    }
    /* Printers */
}
