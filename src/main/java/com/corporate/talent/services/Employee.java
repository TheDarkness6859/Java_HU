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

    public void editEmployee (long id, Employable updatedData){

        if (idEmployee.containsKey(id)) {

            updatedData.setId(id);
            idEmployee.put(id, updatedData);

            for (int i = 0; i < employees.size(); i++ ){

                if (employees.get(i).getId() == id){
                    employees.set(i, updatedData);
                    break;
                }
            }

            System.out.println("Employee updated correctly");

        }else {

            System.out.println("The Employee ID doesnt exist'");

        }
    }

    public Employable findEmployee(long id) {

        Employable e = idEmployee.get(id);

        if (e != null){
            System.out.println("Employee found, his/her name is:" + e.getFullName());
            return e;
        }else {
            System.out.println("Employee don't found!");
            return null;
        }

    }

    public boolean exists(long id) {
        return idEmployee.containsKey(id);
    }
}

