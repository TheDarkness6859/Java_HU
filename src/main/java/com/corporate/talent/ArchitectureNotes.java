package com.corporate.talent;

import com.corporate.talent.models.BusinessRecord;
import com.corporate.talent.models.Employable;

import java.util.Scanner;
import java.util.InputMismatchException;

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
        But no only this tool, also the GC(Garbage Collector) and the JVM(Java Virtual Machine).
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
        app.navConsole();
    }

    public Employable credentials(){
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

        return new Employable(age, office, salary, gender, bonus, active, quantity, name, score);

    }

    public void salary (Employable newEmployee) {

        double finalSalary = Employable.calculateFinalSalary(newEmployee.getLanguageQuantity(),
                newEmployee.getSalary(), newEmployee.getBonus());
        System.out.printf("the final salary to %s is: %.2f%n", newEmployee.getFullName(), finalSalary);
    }


    public void navConsole() {

        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Create a employee      |
                | 2) Watch employee salary  |
                | 3) Salary category        |
                | 4) Exit                   |
                -----------------------------
                """
        ;

        Scanner dec = new Scanner(System.in);
        Employable e = null;
        int desc;

        do {
            try {
                System.out.println(console);
                System.out.println("Which is your decision?:");
                desc = dec.nextInt();
                dec.nextLine();

                switch (desc) {
                    case 1:
                        e = credentials();
                        System.out.println("Employee created!");
                        break;
                    case 2:
                        if (e != null){
                            salary(e);
                        }
                        else{
                            System.out.println("You don't have a employee.");
                        }
                        break;
                    case 3:
                        obtainSalaryCategory(e);
                        break;
                    case 4:
                        break;
                }
            }catch (InputMismatchException err){
                System.err.println("Please enter a number.");
                dec.nextLine();
                desc = 0;
            }

        }while (desc != 4);
    }

    public void obtainSalaryCategory(Employable employee) {
        /*
            Java 8 (Legacy): In this version the switch was only for instructions or "statement",
            what means that?, is like you create a code block for follow an
            instruction or cases for response is all is a direct task or command; we had
            a problem with the old switch it never return, only follow the command, you can't
            save the result of the switch. Also, we have a heritage problem from c and c++ called
            fall-through(neglect), this phenomenon appear when you forget the break in as far as
            case. although in some situations the people did that intentional but usually
            was forgotten the break, this caused that all case was displayed sequentially execution.

            Java 17(Transition): Between Java 17 and Java 21 was added different things for the switch. First in Java 17 was added
            the switch expression(->) and allow return values with this was deleted the fall-through and the use
            necessary of break; but in this version you have a limit of data types(Strings, numbers and Enums).
            yet not use the pattern matching because was a preview feature, it was hidden,
            but in Java 21 is an official feature.

            Java 21(Now - JEP 441): In this would implement the pattern matching, in this version you don't need
            to create an if inside the switch, already you can control the conditionals directly in the switch using
            Guarded Pattern(when). Now you can create a case of null, verification the type of object in the case.
         */

        switch (employee){
            case null -> System.out.println("You don't have an employee");

            case Employable e when e.getSalary() > 1000 ->
                    System.out.printf("%s you are senior employee!", e.getFullName())
            ;

            case Employable e when e.getSalary() >= 500 ->
                    System.out.printf("%s you are a mid-level employee!", e.getFullName())
            ;

            case  Employable e ->
                    System.out.printf("%s you are a junior employee!", e.getFullName())
            ;
        }
    }
}

