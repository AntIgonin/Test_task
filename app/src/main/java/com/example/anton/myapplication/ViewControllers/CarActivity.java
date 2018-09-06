package com.example.anton.myapplication.ViewControllers;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anton.myapplication.Fragments.FragmentButton;
import com.example.anton.myapplication.Fragments.FragmentCar.FragmentCarView;
import com.example.anton.myapplication.R;

public class CarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        getFragmentManager().beginTransaction()
                .add(R.id.container_car, new FragmentCarView())
                .commit();
    }
}
