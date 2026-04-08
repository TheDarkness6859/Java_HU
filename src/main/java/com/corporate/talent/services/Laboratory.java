package com.corporate.talent.services;

import com.corporate.talent.models.BusinessRecord;
import com.corporate.talent.models.Employable;

public class Laboratory {

    public void laboratory(){
        System.out.println("laboratory tests:");

        String emptyName = null;

        try {
            System.out.println(emptyName.length());
        }catch (NullPointerException e){
            System.out.println("Error diagnostic:");
            System.out.println("Message:" + e.getMessage());
        }

        BusinessRecord data = new BusinessRecord("Riwi", 800123456, 2000, true);
        System.out.println("Registered business: " + data.name());

        Employable empA = new Employable((byte)20, (short)10, 1000.0, 'M', 0.1f, true, 2, "Test", 80);
        Employable empB = new Employable((byte)20, (short)10, 1000.0, 'M', 0.1f, true, 2, "Test", 80);

        System.out.println("\n¿empA == empB is:? " + (empA == empB));
    }

}
