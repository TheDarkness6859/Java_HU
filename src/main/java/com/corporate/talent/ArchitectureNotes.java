package com.corporate.talent;
import models.BusinessRecord;
import models.Employable;

import java.util.Scanner;

public class ArchitectureNotes {

    /*
        This class has the documentation and the difference between java 8 (Legacy) and java 17/21 LTS
     */

    /*
        Java 8 (Legacy): in this version we need to know the syntax and structure of the classes,
        because we need to create the constructor, the getters(Obtain) and the setters(Set),
        make it mutable (with setters),you need give the type of data like String, int, etc...
        this was know how POJOs(Plain Old Java Objects).This cause the "Boilerplate code"(repetitive code).

        Java 17/21 LTS: with these versions we have a new technologies like the Records that allow us
        to create classes simpler and practical with only one line of code and are unchanging (without setters).
        this feature is only for transport data.Java automatically create the accessors.
        But no only this tool too the GC(Garbage Collector) and the JVM(Java Virtual Machine).
        This tools help us to improve the quality of our code and our
        memory management, because with the GC we won more efficiency
        to cleaning our information with the Heap memory.
        Improve it use with the algorithms G1 and ZGC these are created for resolve the problem with
        old versions of Java called Stop-the-World that freeze the apps while clean the memory.

        GC (Garbage Collector): this tool is used for Java to improve the performance to the apps or code
        this tool working in the Heap storage where you can find objects, arrays instead classes,
        and when this code don't have owner or isn't used for the main code this tool delete this objects.

        JVM (Java Virtual Machine): the JVM is the heart of Java, why?, because "Write Once, Run Anywhere"
        this is the tool that allow the traduction of Java in different operative system
        like Linux, Windows and macOS . But with the new version we have the upgrade of
        JIT (Just-In-Time compiler) that make the Java code lighter,
        identify the "Hot Spots", repetitve code like loops or calcs; the JIT compile and then
        become the code in Machine code and save it.
     */

    /*
        We can watch the difference between the old classes and the new records.
        With the old classes, you need create the class, its variables with its type, then
        you need create a Constructor with redundancy repeat the same code, become this in
        Boilerplate code. In contrast, records are more simple because you only declare the
        variables and Java internally with the complier generate a class with the file .class;
        this class is created how final class that y close and secure.
     */

    public static void main(String[] args) {

        String textContent = """

            ====================================================
                    SYSTEM: CORPORATE TALENT MANAGEMENT
            ====================================================
                    [Welcome to the main core system]

                            Status: Online
            ====================================================

            """;

        System.out.println(textContent);

        ArchitectureNotes app = new ArchitectureNotes();

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

        app.credentials();
    }

    public void credentials(){
        Scanner input = new Scanner(System.in);

        System.out.print("What is his/her name?: ");
        String name = input.nextLine();

        System.out.print("What old is he/she?: ");
        byte age = input.nextByte();

        System.out.print("How many he/she scored in the test?: ");
        int score = input.nextInt();

        System.out.print("How much is his/her salary?: ");
        double salary = input.nextDouble();

        System.out.print("How much is his/her bonus?: ");
        float bonus = input.nextFloat();

        input.nextLine();

        System.out.print("he/she have a extra bonus? (yes/no): ");
        String response = input.nextLine();

        if (response.equalsIgnoreCase("yes")){

            System.out.println("Amount of extra bonus: ");
            float extra = input.nextFloat();
            bonus += extra;
            input.nextLine();

        }

        System.out.print("what is his/her office?: ");
        short office = input.nextShort();
        input.nextLine();

        System.out.print("He/She is active? (yes/no): ");
        String response2 = input.nextLine();

        boolean active = response2.equalsIgnoreCase("yes");

        System.out.print("what languages know?: ");
        int quantity = input.nextInt();

        System.out.print("What is he gender? (M/F/O): ");
        char gender = input.next().toUpperCase().charAt(0);

        Employable newEmployee = new Employable(age, office, salary, gender, bonus, active, quantity, name, score);

        double finalSalary = Employable.calculateFinalSalary(quantity, salary, newEmployee.getBonus());
        System.out.printf("the final salary to %s is: %.2f%n", name, finalSalary);

    }

}

