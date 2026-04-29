package com.corporate.talent.models;

//Java 8 class:
public non-sealed class Employable extends Person{

    //Features of each user (Primitives).
    private byte age;
    private short office;
    private double salary;
    private char gender;
    private float bonus;
    private byte testPoint;
    private boolean isActive;
    private int languageQuantity;


    //Constructor.
    public Employable(byte age, short office, double salary, char gender, float bonus,
                      boolean isActive, int languageQuantity, String fullName, byte testPoint){
        super(fullName);
        setAge(age);
        setOffice(office);
        setSalary(salary);
        setGender(gender);
        this.bonus = bonus;
        setTestPoint(testPoint);
        setActive(isActive);
        setLanguageQuantity(languageQuantity);
    }

    public Employable(long id, byte age, short office, double salary, char gender, float bonus,
                      boolean isActive, int languageQuantity, String fullName, byte testPoint){
        super(fullName);
        this.id = id;
        setAge(age);
        setOffice(office);
        setSalary(salary);
        setGender(gender);
        this.bonus = bonus;
        setTestPoint(testPoint);
        setActive(isActive);
        setLanguageQuantity(languageQuantity);
    }

    public float getBonus(){
        return bonus;
    }
    public double getSalary() {return salary;}
    public int getLanguageQuantity() {return languageQuantity;}
    public long getId() {return id;}

    public void setId(long id){
        this.id = id;
    }

    public void setAge(byte age) {
        if (age <= 0 || age >= 105) {
            throw new IllegalArgumentException("your age is: " +age+ " it can't possible");
        }else{
            this.age = age;
        }
    }

    public void setOffice(short office) {
        if (office <= 0 || office >= 105) {
            throw new IllegalArgumentException("Office:" +office+ "I don't believe that");
        }else{
            this.office = office;
        }
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("I don't believe that he/she work free? " + salary);
        }else{
            this.salary = salary;
        }
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'F' || gender == 'O'){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("It genre not exist: " + gender);
        }
    }

    public void setActive(boolean isActive){
        if(isActive && this.testPoint < 50){
            this.isActive = false;
            throw new IllegalArgumentException("no can't be active with low score, sorry:" + testPoint);
        }else {
            this.isActive = isActive;
        }
    }

    public void setLanguageQuantity(int languageQuantity){
        if (languageQuantity < 0 || languageQuantity > 30){
            throw new IllegalArgumentException("It is impossible it quantity of languages: "+ languageQuantity);
        }else{
            this.languageQuantity = languageQuantity;
        }
    }

    public void setTestPoint(byte testPoint){
        if (testPoint < 0 || testPoint > 100){
            throw new IllegalArgumentException("It is impossible We only rate since 100: " + testPoint);
        }else{
            this.testPoint = testPoint;
        }
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

    @Override
    public boolean validateEligibility(){

        return this.testPoint > 60 && this.age >= 18 && this.office >= 1 && this.isActive;

    }

    public byte getAge() {
        return age;
    }

    public short getOffice() {
        return office;
    }

    public char getGender() {
        return gender;
    }

    public byte getTestPoint() {
        return testPoint;
    }

    public boolean isActive() {
        return isActive;
    }
}
