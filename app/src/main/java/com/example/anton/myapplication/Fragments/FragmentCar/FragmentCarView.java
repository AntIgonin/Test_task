package com.example.anton.myapplication.Fragments.FragmentCar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anton.myapplication.Classes.FileUtils;
import com.example.anton.myapplication.Interface.RequestCallback;
import com.example.anton.myapplication.Common.Cars;
import com.example.anton.myapplication.Model.CarModel;
import com.example.anton.myapplication.Presenter.CarPresenter;
import com.example.anton.myapplication.R;

import java.util.List;

public class FragmentCarView extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();

    CarPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_car, container, false);


        initRecyclerView(rootView);
        initPresenter();


        return rootView;
    }

    private void initRecyclerView(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initPresenter(){
        CarModel carModel = new CarModel(getActivity().getBaseContext());
        presenter = new CarPresenter(carModel);
        presenter.attachView(this);
        presenter.viewReady();
    }

    public void showCarList(List<Cars> cars){
        recyclerViewAdapter.setCarList(cars);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
