// MIT LICENSE
// Copyright (c) 2026 Iqbal
// Copyright (c) 2026 Shah

package com.bloodbank.person;

public class Staff extends Person {
    private String id;
    private String password;
    
    public Staff(String nric, String name, int contact, String id, String password) {
        super(nric, name, contact);
        this.id = id;
        this.password = password;
    }
    
    /* Setters */
    private void setID(String id) {
        this.id = id;
    }
    
    private void setPassword(String password) {
        this.password = password;
    }
    /* Setters */
    
    public boolean verifyCredentials(String id, String password){
        if(this.id.equals(id) && this.password.equals(password))
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
