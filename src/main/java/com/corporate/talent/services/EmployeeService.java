package com.corporate.talent.services;

import com.corporate.talent.dao.impl.UserDAOImpl;
import com.corporate.talent.db.DatabaseConnection;
import com.corporate.talent.models.*;
import com.corporate.talent.ui.ConsoleBanners;
import com.corporate.talent.utils.LogManager;

import java.util.*;

public class EmployeeService {

    private final UserDAOImpl dao = new UserDAOImpl();

    public void validateRol (Employable emp){

        if (emp == null) return;

        if (emp instanceof Developer){

            Developer oldDev = (Developer) emp;
            System.out.println("[Legacy] Language: " + oldDev.getMainLanguage());

        }

        if (emp instanceof Developer dev){

            System.out.println("[Modern] Language: " + dev.getMainLanguage());

        }else if (emp instanceof Manager man){

            System.out.println("[Modern] Budge: " + man.getMonthlyBudget());

        }

    }

    public List<Person> getAllEmployees() {

            return dao.readAll();

    }

    public boolean addEmployee(Employable emp) {

        try {

            DatabaseConnection.startTransaction();
            boolean success = dao.save(emp);

            if (success) {
                DatabaseConnection.commit();
                return true;
            }

            DatabaseConnection.rollback();
            return false;

        } catch (Exception e) {

            DatabaseConnection.rollback();
            return false;

        } finally {

            try { DatabaseConnection.closeConnection(); } catch (Exception ignore) {}

        }

    }

    public boolean removeEmployee(long id){

        try {

            DatabaseConnection.startTransaction();

            boolean deleted = dao.delete(id);

            if (deleted) {

                DatabaseConnection.commit();
                LogManager.addLog("INFO", "Empleado eliminado: " + id);
                return true;

            }

            DatabaseConnection.rollback();
            return false;

        }catch (Exception e) {

            DatabaseConnection.rollback();
            LogManager.addLog("ERROR", "Error al eliminar: " + e.getMessage());
            return false;

        } finally {

            try { DatabaseConnection.closeConnection(); } catch (Exception ignore) {}

        }

    }

    public boolean editEmployee (Person p){

        try {

            DatabaseConnection.startTransaction();

            boolean updated = dao.edit(p);

            if (updated) {

                DatabaseConnection.commit();
                LogManager.addLog("INFO", "Empleado actualizado: " + p.getFullName());
                return true;

            }

            DatabaseConnection.rollback();
            return false;

        } catch (Exception e) {

            DatabaseConnection.rollback();
            LogManager.addLog("ERROR", "Error al actualizar: " + e.getMessage());
            return false;

        } finally {

            try { DatabaseConnection.closeConnection(); } catch (Exception ignore) {}

        }
    }

    public Person findEmployee(long id) {

        Optional<Person> p = dao.readId(id);

        if (p.isPresent()){

            System.out.println("Employee found, his/her name is:" + p.get().getFullName());
            return p.get();

        }else {

            System.out.println("Employee don't found!");
            return null;

        }

    }

    public void employeeReport () {

        List<Person> employees = dao.readAll();

        if(!employees.isEmpty()){

            //Java 8 (Legacy)
            /*
                Employable oldFirst = employees.get(0);
                Employable oldLast = employees.get(employees.size()-1);
             */

            //Java 21
            Person first = employees.getFirst();
            Person last = employees.getLast();

            System.out.println("Your first Employee is: \n ID:" + first.getId() + "| Name:" + first.getFullName());
            System.out.println("Your last Employee is: \n ID:" + last.getId() + "| Name:" + last.getFullName());

        }else {

            System.out.println("There's no one on the list yet.");

        }

    }

    public void descEmployee(){

        List<Person> employees = dao.readAll();

        if (!employees.isEmpty()){

            /*
                List<Person> oldCopy = new ArrayList<>(Person);
                Collections.reverse(oldCopy);
             */

            List<Person> desc = employees.reversed();

            System.out.println("--- Employees in Descending Order ---");

            desc.forEach(emp -> System.out.println("ID:" + emp.getId() + "| Name:" + emp.getFullName()));

        }else {

            System.out.println("There's no one on the list yet.");

        }
    }

    public void checkEligibility(){

        List<Person> employees = dao.readAll();

        employees.removeIf(emp -> {

            if (!emp.validateEligibility()) {
                System.out.println(emp.getFullName() + " is currently ineligible and has been removed from the active list.");
                return true;
            }else {
                return false;
            }

        });

    }

    public void finalEmployeesData() {

        List<Person> employees = dao.readAll();

        if (employees.isEmpty()){

            System.out.println("The registry is empty.");
            return;

        }

        double totalSalary = 0;
        int competent = 0;
        int total = employees.size();

        for (Person p: employees){

            if (p instanceof Employable emp){

                totalSalary += emp.getSalary();

                if (emp.validateEligibility()) {
                    competent++;
                }

            }

        }

        int declined = total - competent;
        double average = totalSalary / total;

        ConsoleBanners.employeesInfo(total, declined, totalSalary, average);

    }

    public void showPromotion () {

        List<Person> employees = dao.readAll();

        if (employees.isEmpty()) {
            System.out.println("Don't have employee to get bonus.");
            return;
        }

        System.out.println("--- Bonus of ascends ---");

        for (Person p : employees) {

            if (p instanceof Promotion pro) {

                double bonus = pro.calculatePromotion();
                System.out.println("Candidate: " + p.getFullName() + " | Bonus: $" + bonus);

            }
        }

    }

    public void purgeIneligible() {

        List<Person> employees = dao.readAll();

        for (Person p : employees) {

            if (!p.validateEligibility()) {

                System.out.println("Removing ineligible: " + p.getFullName());
                removeEmployee(p.getId());

            }

        }

    }

    public boolean exists(long id) {
        return dao.readId(id).isPresent();
    }

}

