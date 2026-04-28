package com.corporate.talent.services;

import com.corporate.talent.models.BusinessRecord;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BusinessService {

    HashMap<Long, BusinessRecord> idBusiness = new HashMap<>();

    public void getAllBusiness() {

        if (idBusiness.isEmpty()){
            System.out.println("No employees registered yet");
            return;
        }

        idBusiness.forEach((id, bus) -> System.out.println("ID:" + id + "| Name:" + bus.name()));

    }

    public void addBusiness (BusinessRecord bus) {

        long id = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);

        BusinessRecord businessId = new BusinessRecord(
                id,
                bus.name(),
                bus.NIT(),
                bus.foundationAge(),
                bus.isWorking(),
                bus.technologies(),
                bus.Sedes())
        ;

        idBusiness.put(id , businessId);
        System.out.println("Business added correctly");

    }

    public void removeBusiness (long id){

        BusinessRecord bus = idBusiness.get(id);

        if (bus != null){

            idBusiness.remove(id);
            System.out.println("Business deleted correctly");

        }else {

            System.out.println("The business doesn't exist");

        }

    }

    public void editBusiness (long id, BusinessRecord updatedData){

        if (idBusiness.containsKey(id)) {

            BusinessRecord safeData = new BusinessRecord(
                    id,
                    updatedData.name(),
                    updatedData.NIT(),
                    updatedData.foundationAge(),
                    updatedData.isWorking(),
                    updatedData.technologies(),
                    updatedData.Sedes())
            ;

            idBusiness.put(id, safeData);
            System.out.println("Business updated correctly");

        }else {

            System.out.println("The Business ID doesnt exist'");

        }
    }

    public BusinessRecord findBusiness(long id) {

        BusinessRecord e = idBusiness.get(id);

        if (e != null){
            System.out.println("Business found, his/her name is:" + e.name());
            return e;
        }else {
            System.out.println("Business don't found!");
            return null;
        }

    }

    public boolean exists(long id) {
        return idBusiness.containsKey(id);
    }

}
