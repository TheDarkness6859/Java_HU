package com.corporate.talent.views;

import com.corporate.talent.models.Employable;
import com.corporate.talent.services.*;
import com.corporate.talent.ui.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NavConsoleView {

    private final EmployeeUI intEmp;
    private final BusinessUI intBus;
    private final Employee employee;
    private final Salary sal;
    private final Performance per;

    public NavConsoleView(EmployeeUI intEmp, BusinessUI intBus, Employee employee, Salary sal, Performance per){

        this.intEmp = intEmp;
        this.intBus = intBus;
        this.employee = employee;
        this.sal = sal;
        this.per = per;

    }

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
                        intEmp.employeeDec();
                        break;
                    case 2:
                        intBus.businessDec();
                        break;
                    case 3:
                        employee.getAllEmployees();
                        id = intEmp.search();
                        e = employee.findEmployee(id);
                        break;
                    case 4:
                        if (e != null){
                            sal.salary(e);
                        }else {
                            System.out.println("Please, search for an employee first (Option 3).");
                        }
                        break;
                    case 5:
                        if (e != null){
                            sal.obtainSalaryCategory(e);
                        }else {
                            System.out.println("Please, search for an employee first (Option 3).");
                        }
                        break;
                    case 6:
                        if (e != null){
                            per.EmployeeData(e);
                        }else {
                            System.out.println("Please, search for an employee first (Option 3).");
                        }
                        break;
                    case 7:
                        break;
                }
            }catch (InputMismatchException err){
                System.err.println("Please enter a number.");
                dec.nextLine();
                desc = 0;
            }

        }while (desc != 7);
    }
}
