package com.corporate.talent.models;

public class Manager extends Employable{

    private double monthlyBudget;

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

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

}
