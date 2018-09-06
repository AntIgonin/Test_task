package com.example.anton.myapplication.Model;

public class Cars {

    String model_id;
    String year;
    String owner;

    public Cars(String model_id, String year, String owner){
        this.model_id = model_id;
        this.year = year;
        this.owner = owner;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
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
