package com.corporate.talent.services;

import com.corporate.talent.models.Employable;
import java.text.NumberFormat;
import java.util.Locale;

public class Salary {

    public void salary (Employable newEmployee) {

        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);

        double finalSalary = Employable.calculateFinalSalary(newEmployee.getLanguageQuantity(),
                newEmployee.getSalary(), newEmployee.getBonus());
        System.out.printf("the final salary to %s is: %s%n", newEmployee.getFullName(), dollarFormat.format(finalSalary));
    };

    public void obtainSalaryCategory(Employable employee) {
        /*

         */

        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);

        switch (employee){
            case null -> System.out.println("You don't have an employee");

            case Employable e when e.getSalary() > 1000 ->
                    System.out.printf("%s you are senior employee!, your salary: %s%n"
                            , e.getFullName(), dollarFormat.format(e.getSalary()))
            ;

            case Employable e when e.getSalary() >= 500 ->
                    System.out.printf("%s you are a mid-level employee!, your salary: %s%n"
                            , e.getFullName(), dollarFormat.format(e.getSalary()))
            ;

            case  Employable e ->
                    System.out.printf("%s you are a junior employee!, your salary: %s%n"
                            , e.getFullName(), dollarFormat.format(e.getSalary()))
            ;
        }
    }

}
