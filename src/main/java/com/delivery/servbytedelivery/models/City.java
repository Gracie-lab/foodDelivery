package com.delivery.servbytedelivery.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
//@Data
public enum City {
    ABUJA("Abuja"), WARRI("Warri"), LAGOS("Lagos"), ONITSHA("Onitsha"), IBADAN("Ibadan"),
    UYO("Uyo"), ABIA("Abia"), PORTHACOURT("Porthacourt"), ENUGU("Enugu"), ASABA("Asaba"), KANO("Kano"), UMUAHIA("Umuahia");

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    private String value;

    City(String value) {
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }


}
