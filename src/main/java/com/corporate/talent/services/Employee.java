package com.corporate.talent.services;

import com.corporate.talent.models.Employable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Employee {

    private final ArrayList<Employable> employees = new ArrayList<>();
    private final HashMap<Long, Employable> idEmployee = new HashMap<>();

    public void getAllEmployees() {

        if (idEmployee.isEmpty()){
            System.out.println("No employees registered yet");
            return;
        }

        idEmployee.forEach((id, emp) -> System.out.println("ID:" + id + "| Name:" + emp.getFullName()));

    }

    public void addEmployee(Employable emp) {

        long id = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
        emp.setId(id);

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

    public void employeeReport () {

        if(!employees.isEmpty()){

            //Java 8 (Legacy)
            /*
                Employable oldFirst = employees.get(0);
                Employable oldLast = employees.get(employees.size()-1);
             */

            //Java 21
            Employable first = employees.getFirst();
            Employable last = employees.getLast();

            System.out.println("Your first Employee is: \n ID:" + first.getId() + "| Name:" + first.getFullName());
            System.out.println("Your last Employee is: \n ID:" + last.getId() + "| Name:" + last.getFullName());

        }else {

            System.out.println("There's no one on the list yet.");

        }

    }

    public void descEmployee(){

        if (!employees.isEmpty()){

            /*
                List<Employable> oldCopy = new ArrayList<>(employees);
                Collections.reverse(oldCopy);
             */

            List<Employable> desc = employees.reversed();

            System.out.println("--- Employees in Descending Order ---");

            desc.forEach(emp -> System.out.println("ID:" + emp.getId() + "| Name:" + emp.getFullName()));

        }else {

            System.out.println("There's no one on the list yet.");

        }
    }

    public void checkEligibility(){

        employees.removeIf(emp -> {

            if (!emp.validateEligibility()) {
                System.out.println(emp.getFullName() + " is currently ineligible and has been removed from the active list.");
                return true;
            }else {
                return false;
            }

        });

    }

    public boolean exists(long id) {
        return idEmployee.containsKey(id);
    }
}

