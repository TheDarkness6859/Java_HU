package com.corporate.talent.ui;

import com.corporate.talent.models.BusinessRecord;
import com.corporate.talent.models.ExtraBusinessData;
import com.corporate.talent.services.Business;
import com.corporate.talent.services.FactoryData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusinessUI {

    Scanner input = new Scanner(System.in);
    FactoryData factory = new FactoryData();
    Business bs = new Business();

    public BusinessRecord credentials() {

        while (true) {

            try {

                System.out.print("What is the name of your company?: ");
                var name = input.nextLine();

                System.out.print("What old is your NIT?: ");
                var nit = input.nextLong();
                input.nextLine();

                System.out.print("what is the foundation year?, ej: (2001): ");
                var age = input.nextInt();
                input.nextLine();

                System.out.print("The business still working? (yes/no): ");
                var response = input.nextLine().equalsIgnoreCase("yes");

                ExtraBusinessData extra = factory.businessInfo();

                return new BusinessRecord(0L, name, nit, age, response, extra.techno(), extra.sites());

            } catch (InputMismatchException err){

                System.err.print("\n Invalid input! Please use numbers where required.");
                input.nextLine();

            }
        }
    }

    public void businessDec(){

        int desc;
        long id;
        BusinessRecord b = null;

        do {
            try{

                ConsoleBanners.managementBusiness();
                System.out.println("Which is your decision?:");
                desc = input.nextInt();
                input.nextLine();

                switch (desc){
                    case 1:
                        b = credentials();
                        bs.addBusiness(b);
                        break;
                    case 2:
                        bs.getAllBusiness();
                        break;
                    case 3:
                        id = search();
                        bs.removeBusiness(id);
                        break;
                    case 4:
                        id = search();
                        if (bs.exists(id)){
                            System.out.println("--- Edit Business Data ---");
                            BusinessRecord data = credentials();
                            bs.editBusiness(id, data);
                        }else{
                            System.out.println("The Business ID doesn't exist.");
                        }
                        break;
                    case 5:
                        break;
                }

            }catch (InputMismatchException err){

                System.err.print("Invalid input! Please enter only numbers.");
                input.nextLine();
                desc = 0;

            }
        } while(desc != 5);

    }

    public long search(){

        byte tries = 3;

        while (tries > 0){

            try {

                System.out.println("what is he/she id?: ");
                long id = input.nextLong();
                input.nextLine();

                if (bs.exists(id)){

                    System.out.println("Business found!");
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
}