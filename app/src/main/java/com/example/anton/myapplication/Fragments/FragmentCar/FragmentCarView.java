package com.example.anton.myapplication.Fragments.FragmentCar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anton.myapplication.Classes.ApiClient;
import com.example.anton.myapplication.Classes.FileUtils;
import com.example.anton.myapplication.Interface.RequestCallback;
import com.example.anton.myapplication.Model.Cars;
import com.example.anton.myapplication.ModelPresenter.CarPresenter;
import com.example.anton.myapplication.R;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCarView extends Fragment implements RequestCallback {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_car, container, false);

        recyclerViewAdapter.setCarList(FileUtils.loadDataLocal(getActivity().getBaseContext()));
        initRecyclerView(rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCar();
    }

    private void initRecyclerView(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void loadCar(){
        CarPresenter carPresenter = new CarPresenter(getActivity().getBaseContext());
        carPresenter.uploadCars(this);
    }

    @Override
    public void updateAdapter(List<Cars> arrayList) {
        recyclerViewAdapter.setCarList(arrayList);
    }
}
