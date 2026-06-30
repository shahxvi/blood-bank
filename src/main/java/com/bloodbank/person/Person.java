// MIT LICENSE
// Copyright (c) 2026 Isya
// Copyright (c) 2026 Shah   
// Copyright (c) 2026 Maya   

package com.bloodbank.person;

import com.bloodbank.io.Recordable;

public abstract class Person implements Recordable {
    protected String nric;
    protected String name;
    protected String contact;
  
    protected Person(String nric, String name, String contact){
        this.nric = nric;
        this.name = name;
        this.contact = contact;
    }

    /* Setters */
    protected void setNRIC(String nric){
        this.nric = nric;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected void setContact(String contact){
        this.contact = contact;
    }
    /* Setters */

    /* Getters */
    public String getNRIC(){
        return nric;
    }

    public String getName(){
        return name;
    }

    public String getDOB(){
        return String.format("%s-%s-%s", nric.substring(0, 2), nric.substring(2, 4), nric.substring(4, 6));
    }

    public char getGender(){
        return ((nric.charAt(11) - '0') & 1) == 0 ? 'F' : 'M';
    }

    public String getContact(){
        return contact;
    }
    /* Getters */

    /* Printers */
    public String toString() {
        return "NRIC: " + nric +
               "\nName: " + name +
               "\nDate of Birth: " + getDOB() +
               "\nGender: " + getGender() +
               "\nContact: " + contact;
    }

    public String toRecord() {
        return String.format("%s;%s;%s", nric, name, contact);
    }
    /* Printers */
}