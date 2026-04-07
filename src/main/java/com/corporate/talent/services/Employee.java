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

    public void addEmployee(Employable emp) {

        employees.add(emp);
        idEmployee.put(emp.getId(), emp);
        System.out.println("Employee added correctly");

    }

    public void removeEmployee(long id){

        Employable emp = idEmployee.get(id);

        if (emp != null){

            idEmployee.remove(id);
            employees.remove(emp);
            System.out.println("Employee deleted correctly");

        }else {

            System.out.println("The employee doesn't exist");

        }

    }

}

