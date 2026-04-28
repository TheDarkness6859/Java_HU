package com.corporate.talent.models;

public final class ExternalConsultor extends Person{

    public ExternalConsultor(String fullName) {

        super(fullName);

    }

    @Override
    public boolean validateEligibility() {
        return true;
    }

}
