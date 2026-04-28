package com.corporate.talent.views;

import com.corporate.talent.models.BusinessRecord;
import com.corporate.talent.models.ExtraBusinessData;
import com.corporate.talent.services.BusinessService;
import com.corporate.talent.services.FactoryDataService;
import com.corporate.talent.ui.ConsoleBanners;
import com.corporate.talent.utils.ScannerInput;

import java.util.InputMismatchException;

public class BusinessView {

    private final ScannerInput input;
    private final FactoryDataService factory;
    private final BusinessService bs;

    public BusinessView(ScannerInput input, FactoryDataService factory, BusinessService bs){

        this.input = input;
        this.factory = factory;
        this.bs = bs;

    }

    public BusinessRecord credentials() {

        while (true) {

            try {

                var name = input.readString("What is the name of your company?: ");

                var nit = input.readLong("What old is your NIT?: ");

                var age = input.readInt("what is the foundation year?, ej: (2001): ");

                var response = input.readString("The business still working? (yes/no): ").equalsIgnoreCase("yes");

                ExtraBusinessData extra = factory.businessInfo();

                return new BusinessRecord(0L, name, nit, age, response, extra.techno(), extra.sites());

            } catch (InputMismatchException err){

                System.err.print("\n Invalid input! Please use numbers where required.");

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
                desc = input.readInt("Which is your decision?:");

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
                desc = 0;

            }
        } while(desc != 5);

    }

    public long search(){

        byte tries = 3;

        while (tries > 0){

            try {

                long id = input.readLong("what is he/she id?: ");

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