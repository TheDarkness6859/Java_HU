package com.corporate.talent.ui;

import com.corporate.talent.models.Employable;
import com.corporate.talent.services.Employee;
import com.corporate.talent.services.Performance;
import com.corporate.talent.services.Salary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NavConsole {

    //Instances
    Employee  employee = new Employee();
    EmployeeUI interaction = new EmployeeUI(employee);
    Salary sal = new Salary();
    Performance per = new Performance();

    public void navConsole() {

        Scanner dec = new Scanner(System.in);
        Employable e = null;
        int desc;
        long id;

        do {
            try {
                ConsoleBanners.mainConsole();
                System.out.println("Which is your decision?:");
                desc = dec.nextInt();
                dec.nextLine();

                switch (desc) {
                    case 1:
                        interaction.employeeDec();
                        break;
                    case 2:
                        id = interaction.search();
                        e = employee.findEmployee(id);
                        break;
                    case 3:
                        if (e != null){
                            sal.salary(e);
                        }else {
                            System.out.println("You don't have a employee.");
                        }
                        break;
                    case 4:
                        if (e != null){
                            sal.obtainSalaryCategory(e);
                        }else {
                            System.out.println("Please, search for an employee first (Option 2).");
                        }
                        break;
                    case 5:
                        if (e != null){
                            per.EmployeeData(e);
                        }else {
                            System.out.println("Please, search for an employee first (Option 2).");
                        }
                        break;
                    case 6:
                        break;
                }
            }catch (InputMismatchException err){
                System.err.println("Please enter a number.");
                dec.nextLine();
                desc = 0;
            }

        }while (desc != 6);
    }
}
