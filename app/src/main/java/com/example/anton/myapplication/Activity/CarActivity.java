package com.example.anton.myapplication.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.anton.myapplication.Fragments.FragmentCar.FragmentCarView;
import com.example.anton.myapplication.R;

public class CarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        Log.d("Create","Create");
        getFragmentManager().beginTransaction()
                .add(R.id.container_car, new FragmentCarView())
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
