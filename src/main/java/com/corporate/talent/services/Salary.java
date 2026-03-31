package com.corporate.talent.services;

import com.corporate.talent.models.Employable;

public class Salary {

    public void salary (Employable newEmployee) {

        double finalSalary = Employable.calculateFinalSalary(newEmployee.getLanguageQuantity(),
                newEmployee.getSalary(), newEmployee.getBonus());
        System.out.printf("the final salary to %s is: %.2f%n", newEmployee.getFullName(), finalSalary);
    };

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
