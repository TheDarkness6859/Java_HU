package com.corporate.talent.views;

import com.corporate.talent.controller.EmployeeController;
import com.corporate.talent.models.Developer;
import com.corporate.talent.models.Employable;
import com.corporate.talent.models.Manager;
import com.corporate.talent.services.EmployeeService;
import com.corporate.talent.ui.ConsoleBanners;
import com.corporate.talent.utils.ScannerInput;

import java.util.InputMismatchException;

public class EmployeeView {

    private final ScannerInput input;
    EmployeeController c;

    public EmployeeView(EmployeeController c, ScannerInput input){

        this.c = c;
        this.input = input;

    }

    public Employable credentials() {

        while (true) {

            try {

                var name = input.readString("What is his/her name?: ");

                if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("Only letters and spaces allowed!");
                }

                var age = input.readByte("What old is he/she?: ");

                var score = input.readByte("How many he/she scored in the test?: ");

                var salary = input.readDouble("How much is his/her salary?: ");

                var bonus = input.readFloat("How much is his/her bonus?: ");

                var response = input.readString("he/she have a extra bonus? (yes/no): ");

                if (response.equalsIgnoreCase("yes")) {

                    System.out.println();
                    var extra = input.readFloat("Amount of extra bonus: ");
                    bonus += extra;

                }

                var office = input.readShort("what is his/her office?: ");

                String response2 = input.readString("He/She is active? (yes/no): ");

                boolean active = response2.equalsIgnoreCase("yes");

                int quantity = input.readInt("what languages know?: ");

                char gender = input.readString("What is he gender? (M/F/O): ").toUpperCase().charAt(0);

                ConsoleBanners.employeeDecision();

                int role = input.readInt("Choice: ");

                if (role == 1){

                    String language = input.readString("What is the main language?: ");
                    return new Developer(age, office, salary, gender, bonus, active, quantity, name, score, language);

                }else {

                    double budget = input.readDouble("Monthly budget: ");
                    return new Manager(age, office, salary, gender, bonus, active, quantity, name, score, budget);

                }

            } catch (InputMismatchException err){

                input.readString("\n You can't do it");

            } catch (Exception err){
                System.out.println("Business Error: " + err.getMessage());
            }
        }
    }

    public long search(){

        byte tries = 3;

        while (tries > 0){

            try {

                long id = input.readLong("what is he/she id?: ");

                if (c.exists(id)){

                    System.out.println("Employee found!");
                    return id;

                }else {

                    tries --;
                    System.out.println("Attempts remaining:" + tries);

                }

            } catch(InputMismatchException err){

                System.err.print("Invalid input! Please enter only numbers.");
                tries --;

            }

        }

        System.out.println("No more attempts left.");
        return -1;

    }

    public void employeeDec(){

        int desc;
        long id;
        Employable e;

        do {
            try{

                ConsoleBanners.managementEmployee();
                desc = input.readInt("Which is your decision?: ");

                switch (desc){
                    case 1:
                        e = credentials();
                        c.create(e);
                        c.eligibility();
                        break;
                    case 2:
                        c.findAll();
                        break;
                    case 3:
                        id = search();
                        c.delete(id);
                        break;
                    case 4:
                        id = search();
                        if (c.exists(id)){
                            System.out.println("--- Edit Employee Data ---");
                            Employable data = credentials();
                            c.edit(data);
                        }else{
                            System.out.println("The employee ID doesn't exist.");
                        }
                        break;
                    case 5:
                        employeeReports();
                        break;
                    case 6:
                        break;
                }

            }catch (InputMismatchException err){

                System.err.print("Invalid input! Please enter only numbers.");
                desc = 0;

            }
        } while(desc != 6);

    }

    public void employeeReports(){
        int desc;
        do {
            try {

                ConsoleBanners.employeesData();
                desc = input.readInt("Which is your decision?: ");

                switch (desc) {
                    case 1:
                        c.getShowFirstLast();
                        break;
                    case 2:
                        c.getDescEmployees();
                        break;
                    case 3:
                        c.getReport();
                        break;
                    case 4:
                        c.getPromotionBonuses();
                        break;
                    case 5:
                        break;
                }

            }catch (InputMismatchException err){

                System.err.print("Invalid input! Please enter only numbers.");
                desc = 0;

            }
        } while (desc != 5);
    }
}
