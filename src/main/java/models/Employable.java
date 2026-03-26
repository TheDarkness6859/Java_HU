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

    //In Java, String is an object and isn't part of the primitives.
    private String fullName;

    //Constructor.
    public Employable(byte age, short office, double salary, char gender, float bonus,
                      boolean isActive, int languageQuantity, String fullName){
        this.age = age;
        this.office = office;
        this.salary = salary;
        this.gender = gender;
        this.bonus = bonus;
        this.isActive = isActive;
        this.languageQuantity = languageQuantity;
        this.fullName = fullName;
    }

}
