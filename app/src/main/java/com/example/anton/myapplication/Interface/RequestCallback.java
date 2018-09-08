package com.example.anton.myapplication.Interface;

import com.example.anton.myapplication.Common.Cars;

import java.util.List;

/**
 * Created by Anton on 06.09.2018.
 */

public interface RequestCallback {
    public void updateAdapter(List<Cars> arrayList);
}
