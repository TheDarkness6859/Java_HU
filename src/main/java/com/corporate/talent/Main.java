package com.corporate.talent;

import com.corporate.talent.services.*;
import com.corporate.talent.views.BusinessView;
import com.corporate.talent.ui.ConsoleBanners;
import com.corporate.talent.views.EmployeeView;
import com.corporate.talent.utils.ScannerInput;
import com.corporate.talent.views.NavConsoleView;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //Class:
        EmployeeService emp = new EmployeeService();

        //Utils:
        Scanner scanner = new Scanner(System.in);
        ScannerInput input = new ScannerInput(scanner);

        //Services:
        SalaryService sal = new SalaryService();
        PerformanceService perf = new PerformanceService();
        FactoryDataService factory = new FactoryDataService();
        BusinessService business = new BusinessService();

        //Views:
        BusinessView businessview = new BusinessView(input, factory, business);
        EmployeeView employeeView = new EmployeeView(emp , input);
        NavConsoleView console = new NavConsoleView(employeeView, businessview, emp, sal, perf, input);


        ConsoleBanners.banner();
        console.navConsole();

        //lab.laboratory();

    }
}

