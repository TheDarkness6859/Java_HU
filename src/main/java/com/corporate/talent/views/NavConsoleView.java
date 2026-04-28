package com.corporate.talent.ui;

import com.corporate.talent.models.Employable;
import com.corporate.talent.services.Employee;
import com.corporate.talent.services.Performance;
import com.corporate.talent.services.Salary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NavConsole {

    private final EmployeeUI intBus = EmployeeUI();

    public NavConsole (){}
    //Instances
    Employee  employee = new Employee();
    EmployeeUI intEmp = new EmployeeUI(employee);
    BusinessUI intBus = new BusinessUI();
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
