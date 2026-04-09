package com.corporate.talent.ui;

import com.corporate.talent.models.Employable;
import com.corporate.talent.services.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeUI {

    Scanner input = new Scanner(System.in);
    Employee s;

    public EmployeeUI(Employee employeeShared){
        this.s = employeeShared;
    }

    public Employable credentials() {

        while (true) {

            try {

                System.out.print("What is his/her name?: ");
                var name = input.nextLine();

                System.out.print("What old is he/she?: ");
                var age = input.nextByte();

                System.out.print("How many he/she scored in the test?: ");
                var score = input.nextByte();

                System.out.print("How much is his/her salary?: ");
                var salary = input.nextDouble();

                System.out.print("How much is his/her bonus?: ");
                var bonus = input.nextFloat();

                input.nextLine();

                System.out.print("he/she have a extra bonus? (yes/no): ");
                var response = input.nextLine();

                if (response.equalsIgnoreCase("yes")) {

                    System.out.println("Amount of extra bonus: ");
                    float extra = input.nextFloat();
                    bonus += extra;
                    input.nextLine();

                }

                System.out.print("what is his/her office?: ");
                short office = input.nextShort();
                input.nextLine();

                System.out.print("He/She is active? (yes/no): ");
                String response2 = input.nextLine();

                boolean active = response2.equalsIgnoreCase("yes");

                System.out.print("what languages know?: ");
                int quantity = input.nextInt();

                System.out.print("What is he gender? (M/F/O): ");
                char gender = input.next().toUpperCase().charAt(0);

                input.nextLine();

                return new Employable(age, office, salary, gender, bonus, active, quantity, name, score);

            } catch (InputMismatchException err){

                System.err.print("\n You can't do it");
                input.nextLine();

            }
        }
    }

    public long search(){

        byte tries = 3;

        while (tries > 0){

            try {

                System.out.println("what is he/she id?: ");
                long id = input.nextLong();
                input.nextLine();

                if (s.exists(id)){

                    System.out.println("Employee found!");
                    return id;

                }else {

                    tries --;
                    System.out.println("Attempts remaining:" + tries);
                    input.nextLine();

                }

            } catch(InputMismatchException err){

                System.err.print("Invalid input! Please enter only numbers.");
                input.nextLine();
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
                System.out.println("Which is your decision?:");
                desc = input.nextInt();
                input.nextLine();

                switch (desc){
                    case 1:
                        e = credentials();
                        s.addEmployee(e);
                        break;
                    case 2:
                        s.getAllEmployees();
                        break;
                    case 3:
                        id = search();
                        s.removeEmployee(id);
                        break;
                    case 4:
                        id = search();
                        if (s.exists(id)){
                            System.out.println("--- Edit Employee Data ---");
                            Employable data = credentials();
                            s.editEmployee(id, data);
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
                input.nextLine();
                desc = 0;

            }
        } while(desc != 6);

    }

    public void employeeReports(){
        int desc;
        do {
            try {

                ConsoleBanners.employeesData();
                System.out.println("Which is your decision?:");
                desc = input.nextInt();
                input.nextLine();

                switch (desc) {
                    case 1:
                        s.employeeReport();
                        break;
                    case 2:
                        s.descEmployee();
                        break;
                    case 3:
                        break;
                }

            }catch (InputMismatchException err){

                System.err.print("Invalid input! Please enter only numbers.");
                input.nextLine();
                desc = 0;

            }
        } while (desc != 3);
    }
}
