package models;
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
    private String fullName;

    //Constructor.
    public Employable(byte age, short office, double salary, char gender, float bonus,
                      boolean isActive, int languageQuantity, String fullName, int testPoint){
        this.age = age;
        this.office = office;
        this.salary = salary;
        this.gender = gender;
        this.bonus = bonus;
        this.isActive = isActive;
        this.languageQuantity = languageQuantity;
        this.fullName = fullName;
        this.testPoint = testPoint;
    }

    public String getFullName() {
        return fullName;
    }

    public byte getAge() {
        return age;
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
}
