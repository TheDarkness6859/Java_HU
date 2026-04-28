package com.corporate.talent.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInput {

    private final Scanner input;

    public ScannerInput (Scanner input){

        this.input = input;

    }

    public int readInt (String prompt){

        while (true) {

            try {

                System.out.println(prompt);
                int value = input.nextInt();
                input.nextLine();
                return value;

            }catch (InputMismatchException err) {

                System.out.println("Error: you need input a valid number!");
                input.nextLine();

            }

        }

    }

    public String readString(String prompt){
        String value;

        do {

            System.out.println(prompt);
            value = input.nextLine().trim();

            if (value.isEmpty()){

                System.err.println("The input cannot be empty");

            }

        }while (value.isEmpty());

        return value;

    }

    public double readDouble (String prompt){

        while (true) {

            try {

                System.out.println(prompt);
                double value = input.nextDouble();
                input.nextLine();
                return value;

            }catch (InputMismatchException err) {

                System.out.println("Error: you need input a valid number!");
                input.nextLine();

            }

        }

    }

}
