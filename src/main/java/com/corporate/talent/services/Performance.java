package com.corporate.talent.services;
import com.corporate.talent.models.Employable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Performance {

    public void EmployeeData (Employable e){

        String[] name = {e.getFullName()};
        double [][] notesData = new double[1][3];

        average(name, notesData);

    }

    public void average (String[] name, double [][] notes){

        Scanner input = new Scanner(System.in);

        System.out.println("---Employee Data---");

        for (int u = 0; u < name.length; u ++){

            double totalNotes = 0;

            for (int d = 0; d < notes[u].length; d++){

                notes[u][d] = validNotes(input, d + 1);
                totalNotes += notes[u][d];

            }

            double average = totalNotes / notes[u].length;
            String status = (average >= 3.5) ? "PROMOTED" : "NOT PROMOTED";
            printData (name[u], totalNotes, average, (int) average, status);
            /*
            In Java, we have something called "Narrowing", basically transform a big object (64 bits) into a
            small box (32 bits), where you do this "(int) average" happen two critical things.

            1.Overflow: A double can save larger numbers than int. if the double is more than the limit of
            int (2,147,483,647), when you transform it into int, the value is broken, and only you had the biggest
            value of int, lost the real value.

            2.Truncation: Java doesn't round the number at number more near, Java only cut the decimal part, for example
            if you have 3.999999, you lost the .99... and you had only the Integer 3.
             */
        }

    }

    public double validNotes (Scanner input, int trimester){
        while(true){
            try {
                System.out.println("Enter the note of trimester " + trimester + ":");
                double note = input.nextDouble();

                if (note > 5 || note < 0){
                    System.err.println("Error: The note must be between 0 and 5.");
                    continue;
                }

                return note;

            }catch (InputMismatchException err){
                System.err.print("You can't do it, try put the value with ',' or '.' ");
                input.nextLine();
            }
        }
    }

    public void printData(String name, double total, double average, int rounded, String status){

        System.out.printf("""
                --------Final result--------
                Name: %s
                Total notes: %.2f
                Average: %.2f
                Total result: %d
                Status: %s
                ----------------------------
                """, name, total, average, rounded, status)
        ;

    }
}
