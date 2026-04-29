package com.corporate.talent.models;

public class Developer extends Employable implements Promotion{

    private final String mainLanguage;

    public Developer (byte age,
                      short office,
                      double salary,
                      char gender,
                      float bonus,
                      boolean isActive,
                      int languageQuantity,
                      String fullName,
                      byte testPoint,
                      String mainLanguage){

        super(age, office, salary, gender, bonus, isActive, languageQuantity, fullName, testPoint);
        this.mainLanguage = mainLanguage;

    }

    @Override
    public double calculatePromotion () {

        System.out.println("Calculate budget to ascends to developer" + this.getFullName());

        return this.getSalary() * 0.10;

    }

    public String getMainLanguage() {
        return mainLanguage;
    }

}
