package com.corporate.talent.ui;

import com.corporate.talent.models.Employable;
import com.corporate.talent.services.Performance;
import com.corporate.talent.services.Salary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NavConsole {

    //Instances
    EmployeeUI cre = new EmployeeUI();
    Salary sal = new Salary();
    Performance per = new Performance();

    public void navConsole() {

        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Create a employee      |
                | 2) Watch employee salary  |
                | 3) Salary category        |
                | 4) Employee notes         |
                | 5) Exit                   |
                -----------------------------
                """
                ;

        Scanner dec = new Scanner(System.in);
        Employable e = null;
        int desc;

        do {
            try {
                System.out.println(console);
                System.out.println("Which is your decision?:");
                desc = dec.nextInt();
                dec.nextLine();

                switch (desc) {
                    case 1:
                        e = cre.credentials();
                        System.out.println("Employee created!");
                        break;
                    case 2:
                        if (e != null){
                            sal.salary(e);
                        }else {
                            System.out.println("You don't have a employee.");
                        }
                        break;
                    case 3:
                        sal.obtainSalaryCategory(e);
                        break;
                    case 4:
                        if (e != null){
                            per.EmployeeData(e);
                        }else {
                            System.out.println("You don't have a employee.");
                        }
                        break;
                    case 5:
                        break;
                }
            }catch (InputMismatchException err){
                System.err.println("Please enter a number.");
                dec.nextLine();
                desc = 0;
            }

        }while (desc != 5);
    }
}
