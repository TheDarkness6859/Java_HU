package com.corporate.talent.controller;

import com.corporate.talent.models.Employable;
import com.corporate.talent.models.Person;
import com.corporate.talent.services.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeController {

    private final EmployeeService service = new EmployeeService();

    public void create(Employable emp) {

        if (service.addEmployee(emp)) {
            System.out.println("Saved successfully!");
        }

    }

    public void delete (long id){

        if (service.removeEmployee(id)){
            System.out.println("Deleted successfully!");
        }

    }

    public Employable findById (long id){

        Person p = service.findEmployee(id);

        if (p instanceof Employable emp){

            return emp;

        }

        return null;

    }

    public List<Person> findAll () {

        return service.getAllEmployees();

    }

    public void edit (Employable emp){

        if (service.editEmployee(emp)){
            System.out.println("Updated successfully!");
        }


    }

    public boolean exists (long id) {

        if (service.exists(id)){

            return true;

        }

        return false;

    }

    public void getReport () {

        service.finalEmployeesData();

    }

    public void getShowFirstLast () {

        service.employeeReport();

    }

    public void getDescEmployees () {

        service.descEmployee();

    }

    public void purgeIneligible () {

        service.purgeIneligible();

    }

    public void eligibility () {

        service.checkEligibility();

    }

    public void getPromotionBonuses() {

        service.showPromotion();

    }

    public void validateRol (Employable emp){

        service.validateRol(emp);

    }

}
