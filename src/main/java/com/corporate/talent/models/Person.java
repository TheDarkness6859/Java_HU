package com.corporate.talent.models;

public abstract sealed class Person permits Employable, ConsultorExterno {

    protected final String fullName;
    protected long id;

    protected Person (String fullName){

        this.fullName = fullName;

    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract boolean validateEligibility();

}
