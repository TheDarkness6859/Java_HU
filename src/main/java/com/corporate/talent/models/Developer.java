package com.corporate.talent.models;

public class Developer extends Employable{

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

    public String getMainLanguage() {
        return mainLanguage;
    }

}
