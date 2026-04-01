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

        try {

            System.out.println("---Employee Data---");

            for (int u = 0; u < name.length; u ++){

                double totalNotes = 0;

                for (int d = 0; d < notes[u].length; d++){

                    System.out.println("Enter the note of trimester " + (d + 1) + ":");
                    notes[u][d] = input.nextDouble();
                    totalNotes += notes[u][d];

                }

                double average = totalNotes / notes[u].length;

                printData (name[u], totalNotes, average, (int) average);

            }

        }catch (InputMismatchException err){
            System.err.print("You can't do it, try put the value with ',' or '.' ");
            input.nextLine();
        }
    }

    public void printData(String name, double total, double average, int rounded){

        System.out.printf("""
                --------Final result--------
                Name: %s
                Total notes: %.2f
                Average: %.2f
                Total result: %d
                ----------------------------
                """, name, total, average, rounded)
        ;

    }
}
