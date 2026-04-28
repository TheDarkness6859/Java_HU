package com.corporate.talent.views;

import com.corporate.talent.models.Employable;
import com.corporate.talent.services.*;
import com.corporate.talent.ui.*;
import com.corporate.talent.utils.ScannerInput;

public class NavConsoleView {

    private final EmployeeView intEmp;
    private final BusinessView intBus;
    private final EmployeeService employee;
    private final SalaryService sal;
    private final PerformanceService per;
    private final ScannerInput input;

    public NavConsoleView(EmployeeView intEmp,
                          BusinessView intBus,
                          EmployeeService employee,
                          SalaryService sal,
                          PerformanceService per,
                          ScannerInput input){

        this.intEmp = intEmp;
        this.intBus = intBus;
        this.employee = employee;
        this.sal = sal;
        this.per = per;
        this.input = input;

    }

    public void navConsole() {

        Employable e = null;
        int desc = 0;
        long id;

        do {

            ConsoleBanners.mainConsole();
            desc = input.readInt("Which is your decision?: ");

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


        }while (desc != 7);
    }
}
