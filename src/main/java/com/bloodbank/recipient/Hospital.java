// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.recipient;

import com.bloodbank.io.Recordable;

public class Hospital implements Recordable {
    private String name;
    private String address;
    private double distance;
    private String contact;

    public Hospital(String name, String address, double distance, String contact) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.contact = contact;
    }

    /* Setters */
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
    /* Setters */

    /* Getters */
    public String getName () {
        return name;
    }

    public String getAddress () {
        return address;
    }

    public double getDistance () {
        return distance;
    }

    public String getContact () {
        return contact;
    }
    /* Getters */

    /* Printers */
    public String toString() {
        return "Name: " + name +
               "\nAddress: " + address +
               "\nDistance: " + distance + "KM" +
               "\nContact: " + contact;
    }

    public String toRecord() {
        return name + ";" + address + ";" + distance + ";" + contact;
    }
    /* Printers */
}
