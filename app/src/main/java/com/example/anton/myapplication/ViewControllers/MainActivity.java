package com.example.anton.myapplication.ViewControllers;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import com.example.anton.myapplication.Fragments.FragmentButton;
import com.example.anton.myapplication.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.container, new FragmentButton())
                .commit();

    }
}
