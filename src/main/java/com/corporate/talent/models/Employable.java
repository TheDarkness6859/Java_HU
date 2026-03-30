package com.corporate.talent.models;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//Java 8 class:
public class Employable {

    //Random id for user.
    private long id = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);

    //Features of each user (Primitives).
    private byte age;
    private short office;
    private double salary;
    private char gender;
    private float bonus;
    private boolean isActive;
    private int languageQuantity;
    private int testPoint;

    //In Java, String is an object and isn't part of the primitives.
    private final String fullName;

    //Constructor.
    public Employable(byte age, short office, double salary, char gender, float bonus,
                      boolean isActive, int languageQuantity, String fullName, int testPoint){
        setAge(age);
        setOffice(office);
        setSalary(salary);
        setGender(gender);
        this.bonus = bonus;
        setTestPoint(testPoint);
        setActive(isActive);
        setLanguageQuantity(languageQuantity);
        this.fullName = fullName;
    }

    public void setAge(byte age) {
        if (age <= 0 || age >= 105) {
            System.out.println("it can't possible");
        }else{
            this.age = age;
        }
    }

    public void setOffice(short office) {
        if (office <= 0 || office >= 105) {
            System.out.println("I don't believe that");
        }else{
            this.office = office;
        }
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            System.out.println("I don't believe that");
        }else{
            this.salary = salary;
        }
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'F' || gender == 'O'){
            this.gender = gender;
        }else{
            System.out.println("It genre not exist");
        }
    }

    public void setActive(boolean isActive){
        if(isActive && this.testPoint < 50){
            System.out.println("no can't be active with low score, sorry.");
            this.isActive = false;
        }else {
            this.isActive = isActive;
        }
    }

    public void setLanguageQuantity(int languageQuantity){
        if (languageQuantity < 0 || languageQuantity > 100){
            System.out.println("It is impossible");
        }else{
            this.languageQuantity = languageQuantity;
        }
    }

    public void setTestPoint(int testPoint){
        if (testPoint < 0 || testPoint > 100){
            System.out.println("It is impossible");
        }else{
            this.testPoint = testPoint;
        }
    }

    public float getBonus(){
        return bonus;
    }


    public static double calculateFinalSalary(int languageQuantity,double salary, float bonus) {

        double result =  (salary + (salary * (bonus * 1.10))) - (salary * 0.05);

        /*
            the order for complete this equation is:
            (Parentheses => Multiplication => Addition => Subtraction)
         */

        if(languageQuantity % 2 == 0){
            return result * 1.02;
        }

        return result;
    }

    public static boolean validateEligibility(byte age, boolean isActive, short office, int testPoint){

        return testPoint <= 85 || age >= 30 || office != 1 || !isActive;

    }

    public void addNewEmployee(byte age, short office, double salary, char gender, float bonus,
                               boolean isActive, int languageQuantity, String fullName, int testPoint){

        Scanner input = new Scanner(System.in);


    }
}
