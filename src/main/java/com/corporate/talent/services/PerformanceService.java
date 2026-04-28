package com.corporate.talent.services;
import com.corporate.talent.models.Employable;
import com.corporate.talent.models.PerformanceReport;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerformanceService {

    public void EmployeeData (Employable e){

        String[] name = {e.getFullName()};
        double [][] notesData = new double[1][3];

        average(name, notesData, e.getId());

    }

    public void average (String[] name, double [][] notes, long idEmployee){

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

            PerformanceReport report = new PerformanceReport(idEmployee,  average, status);

            printData (name[u], totalNotes, report);

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

    public void printData(String name, double total, PerformanceReport report){

        System.out.printf("""
                --------Final result--------
                Name: %s
                Total notes: %.2f
                Average: %.2f
                Total result: %d
                Status: %s
                ----------------------------
                """, name, total, report.average(), (int) report.average(), report.feedBack())
        ;

        System.out.println("[Performance Report]: " + report);

    }
}
