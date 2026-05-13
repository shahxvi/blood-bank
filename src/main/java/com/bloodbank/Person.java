//MIT LICENSE
//Copyright (c) 2026 Isya
//Copyright (c) 2026 Maya   
//Copyright (c) 2026 Shah   

package com.bloodbank;

import com.bloodbank.io.Recordable;

public abstract class Person implements Recordable {
    //Declare
    protected int nric;
    protected String name;
    protected String dob; // YY-MM-DD
    protected char gender;
    protected int contact;
  
    //Normal constructor 
    protected Person(int nric, String name, int contact){
        String nricStr = Integer.toString(nric);
        this.nric = nric;
        this.name = name;
        this.dob = String.format("%s-%s-%s", nricStr.substring(0, 3), nricStr.substring(2, 4), nricStr.substring(4, 6));
        this.gender = ((nricStr.charAt(11) - '0') & 1) == 0 ? 'F' : 'M';
        this.contact = contact;
    }

    /* Setters */
    protected void setNRIC(int nric){
        this.nric = nric;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected void setContact(int contact){
        this.contact = contact;
    }
    /* Setters */

    /* Getters */
    public int getNRIC(){
        return nric;
    }

    public String getName(){
        return name;
    }

    public String getDob(){
        return dob;
    }

    public char getGender(){
        return gender;
    }

    public int getContact(){
        return contact;
    }
    /* Getters */
    public String toString() {
        return nric + name + dob + gender + contact;
    }

    public String toRecord() {
        return String.format("%d; %s; %c; %i", name, dob, gender, contact);
    }
}