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
        /*
            With the integration of the helpful NPEs(JEP 358) in java 14 we can watch in the console the error and where are this
            error, this was an experimental feature that after become in the standard with Java 17/21; it allows that
            the error message was more descriptive. Java internally analyze the bytecode at the moment to run the code,
            where the error appears and give us a message. Previously in Java 8 you only watch the error, but you never know
            what is the variable with the null or problem.
         */

        BusinessRecord data = new BusinessRecord("Riwi", 800123456, 2000, true);
        System.out.println("Registered business: " + data.name());

        Employable empA = new Employable((byte)20, (short)10, 1000.0, 'M', 0.1f, true, 2, "Test", 80);
        Employable empB = new Employable((byte)20, (short)10, 1000.0, 'M', 0.1f, true, 2, "Test", 80);

        System.out.println("\n¿empA == empB is:? " + (empA == empB));
        /*
            When you compare an object, Java don't compare the value, Java uses the reference (memory address) of the object, when
            you use the == operator. With this context we can understand the following: although you create the same object,
            Java assigns different reference when the object is created in the heap, because the operator new (instance) creates a
            place in the memory; there, the heap gives to the object a reference like this "models.Employable@7ad123". In contrast,
            the .equals() method goes into the object, "look inside" and checks its content. By overriding this method;
            here we can define our own rules to compare, this allows Java to confirm if two different instances (new) have the
            same logic.
         */
    }

}
