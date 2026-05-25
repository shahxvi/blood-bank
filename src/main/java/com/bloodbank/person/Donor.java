// MIT LICENSE
// Copyright (c) 2026 Maya
// Copyright (c) 2026 Shah

package com.bloodbank.person;

import com.bloodbank.Blood;

public class Donor extends Person {
    private Blood blood;

    public Donor(String nric, String name, int contact, Blood blood) {
        super(nric, name, contact);
        this.blood = blood;
    }

    /* Setter */
    public void setBlood(Blood blood) {
        this.blood = blood;
    }
    /* Setter */
    
    /* Getter */
    public Blood getBlood() {
        return blood;
    }
    /* Getter */

    /* Printers*/
    @Override
    public String toString() {
        return super.toString() + 
               "\n" + blood.toString(); 
    }

    @Override
    public String toRecord() {
        return super.toRecord() + ";" + blood.toRecord();
    }
    /* Printers*/
}
