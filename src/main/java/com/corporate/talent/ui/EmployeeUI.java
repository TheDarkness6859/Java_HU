package com.corporate.talent.ui;

import com.corporate.talent.models.Employable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeUI {

    Scanner input = new Scanner(System.in);

    public Employable credentials() {

        while (true) {

            try {
                /*
                Java 8 (Legacy): In this version the language is very strict with the data, because you need no matter
                what define the type of it, leading to a verbose coding style, this became the code more long and
                repeat the code (boilerplate).

                Java 10+ (JEP 286) : In this version would add the reserved word "var",
                but It doesn't mean Java is no longer strictly typed,
                only the compiler is smarter and identify the type of the data, use the data by its side (right),
                although it only can use in methods (Local variable), don't can use like a parameter,
                attribute without value, etc. It deletes the redundancy and improve the clean code.
                 */

                System.out.print("What is his/her name?: ");
                var name = input.nextLine();

                System.out.print("What old is he/she?: ");
                var age = input.nextByte();

                System.out.print("How many he/she scored in the test?: ");
                var score = input.nextInt();

                System.out.print("How much is his/her salary?: ");
                var salary = input.nextDouble();

                System.out.print("How much is his/her bonus?: ");
                var bonus = input.nextFloat();

                input.nextLine();

                System.out.print("he/she have a extra bonus? (yes/no): ");
                var response = input.nextLine();

                if (response.equalsIgnoreCase("yes")) {

                    System.out.println("Amount of extra bonus: ");
                    float extra = input.nextFloat();
                    bonus += extra;
                    input.nextLine();

                }

                System.out.print("what is his/her office?: ");
                short office = input.nextShort();
                input.nextLine();

                System.out.print("He/She is active? (yes/no): ");
                String response2 = input.nextLine();

                boolean active = response2.equalsIgnoreCase("yes");

                System.out.print("what languages know?: ");
                int quantity = input.nextInt();

                System.out.print("What is he gender? (M/F/O): ");
                char gender = input.next().toUpperCase().charAt(0);

                input.nextLine();

                return new Employable(age, office, salary, gender, bonus, active, quantity, name, score);

            } catch (InputMismatchException err){

                System.err.print("\n You can't do it");
                input.nextLine();

            }
        }
    }

    public long search(){

        byte tries = 3;

        while (tries > 0){

            try {

                System.out.println("what is he/she id? (Attempts remaining: " + tries + "): ");
                long id = input.nextLong();
                input.nextLine();
                return id;

            } catch(InputMismatchException err){

                System.err.print("Invalid input! Please enter only numbers.");
                input.nextLine();
                tries --;

            }

        }

        System.out.println("No more attempts left.");
        return -1;
    }

}
