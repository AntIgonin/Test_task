package com.example.anton.myapplication.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.anton.myapplication.Classes.ApiClient;
import com.example.anton.myapplication.Classes.FileUtils;
import com.example.anton.myapplication.Interface.RequestCallback;
import com.example.anton.myapplication.Common.Cars;
import com.example.anton.myapplication.Common.ModelCars;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarModel {
    List<Cars> cars;
    List<ModelCars> modelCars;
    Context context;

    public CarModel(Context context){
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
                if(FileUtils.checkDataExist(context)){
                    cars = FileUtils.loadDataLocal(context);
                    requestCallback.updateAdapter(cars);
                }else {
                    Toast toast = Toast.makeText(context,
                            "Требуется соединение с интернетом!", Toast.LENGTH_SHORT);
                    toast.show();
                }
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
                if(FileUtils.checkDataExist(context)){
                    cars = FileUtils.loadDataLocal(context);
                    requestCallback.updateAdapter(cars);
                }else {
                    Toast toast = Toast.makeText(context,
                            "Требуется соединение с интернетом!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    private void setModel(RequestCallback requestCallback){
        for(Cars car:cars){
            for (ModelCars modelCar:modelCars){
                if (car.getModel_id() == modelCar.getId()){
                    car.setModel_name(modelCar.getTitle());
                }
            }
        }
        FileUtils.writeDataLocal(cars,context);
        requestCallback.updateAdapter(cars);
    }

}
