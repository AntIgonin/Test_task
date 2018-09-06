package com.example.anton.myapplication.Interface;

import com.example.anton.myapplication.Model.Cars;
import com.example.anton.myapplication.Model.ModelCars;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerApi {
    @GET("cars")
    Call<List<Cars>> getCar();

    @GET("car_model_ref")
    Call<List<ModelCars>> getCarModel();

}
