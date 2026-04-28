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
        Employee emp = new Employee();

        //Utils:
        Scanner scanner = new Scanner(System.in);
        ScannerInput input = new ScannerInput(scanner);

        //Services:
        Salary sal = new Salary();
        Performance perf = new Performance();
        FactoryData factory = new FactoryData();
        Business business = new Business();

        //Views:
        BusinessView businessview = new BusinessView(input, factory, business);
        EmployeeView employeeView = new EmployeeView(emp , input);
        NavConsoleView console = new NavConsoleView(employeeView, businessview, emp, sal, perf, input);


        ConsoleBanners.banner();
        console.navConsole();

        //lab.laboratory();

    }
}

