package com.example.anton.myapplication.Classes;


import com.example.anton.myapplication.Common.Cars;

public class Globals {
    private static Globals instance;
    private Globals() {}

    public static synchronized Globals getInstance() {
        if (instance == null) {
            instance = new Globals();
        }
        return Globals.instance;
    }
   private Cars cars;

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}