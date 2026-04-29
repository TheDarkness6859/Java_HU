package com.corporate.talent.models;

public interface Promotion {

    double calculatePromotion ();

    default void logOperation(String message) {

        System.out.println("[System] : " + message);

    }

}
