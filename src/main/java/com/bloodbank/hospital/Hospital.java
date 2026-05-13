// MIT LICENSE
// Copyright (c) 2026 Shah

package com.bloodbank.hospital;

import com.bloodbank.io.Recordable;

public class Hospital implements Recordable {
    private String name;
    private String address;
    private int contact;

    public Hospital(String name, String address, int contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    /* Setters */
    public void setName (String name) {
        this.name = name;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public void setContact (int contact) {
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

    public int getContact () {
        return contact;
    }
    /* Getters */

    /* Printers */
    public String toString() {
        return "Name: " + name +
               "\nAddress: " + address +
               "\nContact: " + contact;
    }

    public String toRecord() {
        return name + "; " + address + "; " + contact;
    }
    /* Printers */
}
