package com.example.anton.myapplication.Presenter;

import com.example.anton.myapplication.Activity.CarActivity;
import com.example.anton.myapplication.Common.Cars;
import com.example.anton.myapplication.Fragments.FragmentCar.FragmentCarView;
import com.example.anton.myapplication.Interface.RequestCallback;
import com.example.anton.myapplication.Model.CarModel;

import java.util.List;

public class CarPresenter implements RequestCallback {

    private FragmentCarView carView;
    private CarModel model;

    public CarPresenter(CarModel model){
        this.model = model;
    }

    public void attachView(FragmentCarView carView){
        this.carView = carView;
    }

    public void detachView(){
        model = null;
    }

    public void viewReady(){
        model.uploadCars(this);
    }

    @Override
    public void updateAdapter(List<Cars> arrayList) {
        carView.showCarList(arrayList);
    }
}
