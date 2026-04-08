package com.corporate.talent.services;

import com.corporate.talent.models.ExtraBusinessData;

import java.util.*;

public class FactoryData {

    Scanner input = new Scanner(System.in);

    public ExtraBusinessData businessInfo () {

        String[] tempTech = new String[3];
        HashMap<String, Integer> tempSites = new HashMap<>();


        System.out.println("---Business Data---");

        for (int t = 0; t < tempTech.length; t++){

            String name = validTec(t + 1);
            tempTech[t] = name;

        }

        List<String> technologies = List.of(tempTech);

        for (int s = 0; s < 3; s++){

            String name = validSites();
            int quantity = validQuantity(name);

            tempSites.put(name, quantity);

        }

        Map<String, Integer>  sites = Map.copyOf(tempSites);

        return new ExtraBusinessData(technologies, sites);
    }

    public String validTec (int tec){

        while (true) {

            System.out.println("Add your technologies, #" + tec + ": ");
            String name = input.nextLine().trim();

            if (name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return name;
            } else {
                System.err.println("Invalid input! Only letters and spaces are allowed.");
            }

        }
    }

    public String validSites(){
        while (true){

            try{

                System.out.println("What is the name of your locations: ");
                return input.nextLine();


            }catch (InputMismatchException err){

                System.err.println("You can't do it, only words.");
                input.nextLine();

            }
        }
    }

    public int validQuantity (String name){
        while (true){

            try{

                System.out.println("What is the quantity of your location " + name + "?: ");
                int quantity = input.nextInt();
                input.nextLine();
                return quantity;

            }catch (InputMismatchException err){

                System.err.println("You can't do it, only numbers.");
                input.nextLine();

            }
        }
    }


}
