package com.corporate.talent.services;

import com.corporate.talent.models.Employable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Credentials {

    public Employable credentials() {

        Scanner input = new Scanner(System.in);

        while (true) {

            try {

                System.out.print("What is his/her name?: ");
                String name = input.nextLine();

                System.out.print("What old is he/she?: ");
                byte age = input.nextByte();

                System.out.print("How many he/she scored in the test?: ");
                int score = input.nextInt();

                System.out.print("How much is his/her salary?: ");
                double salary = input.nextDouble();

                System.out.print("How much is his/her bonus?: ");
                float bonus = input.nextFloat();

                input.nextLine();

                System.out.print("he/she have a extra bonus? (yes/no): ");
                String response = input.nextLine();

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

                return new Employable(age, office, salary, gender, bonus, active, quantity, name, score);

            } catch (InputMismatchException err){

                System.err.print("\n You can't do it");
                input.nextLine();

            }
        }
    }
}
