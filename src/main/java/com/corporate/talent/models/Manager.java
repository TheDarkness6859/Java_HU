package com.corporate.talent.models;

public class Manager extends Employable implements Promotion{

    private final double monthlyBudget;

    public Manager(byte age,
                   short office,
                   double salary,
                   char gender,
                   float bonus,
                   boolean isActive,
                   int languageQuantity,
                   String fullName,
                   byte testPoint,
                   double monthlyBudget) {


        super(age, office, salary, gender, bonus, isActive, languageQuantity, fullName, testPoint);
        this.monthlyBudget = monthlyBudget;

    }

    public Manager(long id,
                   byte age,
                   short office,
                   double salary,
                   char gender,
                   float bonus,
                   boolean isActive,
                   int languageQuantity,
                   String fullName,
                   byte testPoint,
                   double monthlyBudget) {


        super(id, age, office, salary, gender, bonus, isActive, languageQuantity, fullName, testPoint);
        this.monthlyBudget = monthlyBudget;

    }

    @Override
    public double calculatePromotion () {

        System.out.println("Calculate budget to ascends to manager" + this.getFullName());

        return this.getSalary() * 0.20;

    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

}
