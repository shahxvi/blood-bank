// MIT LICENSE
// Copyright (c) 2026 Iqbal
// Copyright (c) 2026 Shah

package com.bloodbank.person;

public class Staff extends Person {
    private int id;
    private String password;
    
    public Staff(String nric, String name, int contact, int id, String password) {
        super(nric, name, contact);
        this.id = id;
        this.password = password;
    }
    
    /* Setters */
    private void setID(int id) {
        this.id = id;
    }
    
    private void setPassword(String password) {
        this.password = password;
    }
    /* Setters */
    
    public boolean verifyCredentials(int id, String password){
        if(id == this.id && this.password.equals(password))
            return true;
        return false;
    }
    
    /* Printers */
    public String toString() {
        return super.toString() +
               "\nID: " + id +
               "\nPassword: " + password;
    }
    
    public String toRecord() {
        return super.toRecord() + ";" + id + ";" + password;
    }
    /* Printers */
}
