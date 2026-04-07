package com.corporate.talent.services;

import com.corporate.talent.models.Employable;
import com.corporate.talent.ui.EmployeeUI;

import java.util.*;

public class Employee {

    private ArrayList<Employable> employees = new ArrayList<>();
    private HashMap<Long, Employable> idEmployee = new HashMap<>();

    public void getAllEmployees() {

        if (idEmployee.isEmpty()){
            System.out.println("No employees registered yet");
            return;
        }

        idEmployee.forEach((id, emp) -> {

            System.out.println("ID:" + id + "| Name:" + emp.getFullName());

        });

    }

}

