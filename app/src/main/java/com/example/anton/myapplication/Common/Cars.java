package com.example.anton.myapplication.Common;

import java.io.Serializable;

public class Cars implements Serializable {

    private int model_id;
    private String year;
    private String owner;
    private String model_name;


    public Cars(int model_id, String year, String owner){
        this.model_id = model_id;
        this.year = year;
        this.owner = owner;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String mofel_name) {
        this.model_name = mofel_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
