package com.example.anton.myapplication.ModelPresenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.anton.myapplication.Classes.ApiClient;
import com.example.anton.myapplication.Classes.FileUtils;
import com.example.anton.myapplication.Interface.RequestCallback;
import com.example.anton.myapplication.Model.Cars;
import com.example.anton.myapplication.Model.ModelCars;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarPresenter {
    List<Cars> cars;
    List<ModelCars> modelCars;
    Context context;

    public CarPresenter(Context context){
        this.context = context;
    }

    public void uploadCars(final RequestCallback requestCallback) {


        Call<List<Cars>> messages = ApiClient.getClient().getCar();
            messages.enqueue(new Callback<List<Cars>>()
        {
            @Override
            public void onResponse (Call < List < Cars >> call, Response< List < Cars >> response){
                cars = response.body();
                uploadModelCars(requestCallback);

        }
            @Override
            public void onFailure (Call < List < Cars >> call, Throwable t){
        }
        });
    }

    private void uploadModelCars(final RequestCallback requestCallback){
        Call<List<ModelCars>> messages = ApiClient.getClient().getCarModel();
        messages.enqueue(new Callback<List<ModelCars>>()
        {
            @Override
            public void onResponse (Call < List < ModelCars >> call, Response< List < ModelCars >> response){
                modelCars = response.body();
                Log.d("resp",response.toString());
                setModel(requestCallback);
            }
            @Override
            public void onFailure (Call < List < ModelCars >> call, Throwable t){
            }
        });

    }

    private void setModel(RequestCallback requestCallback){
        for(Cars car:cars){
            for (ModelCars modelCar:modelCars){
                if (car.getModel_id().equals(String.valueOf(modelCar.getId()))){
                    car.setModel_id(modelCar.getTitle());
                }
            }
        }
        FileUtils.writeDataLocal(cars,context);
        requestCallback.updateAdapter(cars);
    }

}
