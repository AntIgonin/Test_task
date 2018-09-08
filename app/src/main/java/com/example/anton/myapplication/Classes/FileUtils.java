package com.example.anton.myapplication.Classes;

import android.content.Context;
import android.util.Log;

import com.example.anton.myapplication.Common.Cars;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 06.09.2018.
 */

public class FileUtils {
    public static List<Cars> loadDataLocal(Context context) {
        List<Cars> arrayList = new ArrayList<>();
        File file = new File(context.getFilesDir(), Constants.CARS_DATA);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = context.openFileInput(Constants.CARS_DATA);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                arrayList = (ArrayList<Cars>) objectInputStream.readObject();
                objectInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            Log.d("Cars", "file not found");
        }
        return arrayList;
    }

    public static boolean checkDataExist(Context context){
        File file = new File(context.getFilesDir(), Constants.CARS_DATA);
        if (file.exists()) {
            return true;
        }else return false;
    }

    public static Boolean writeDataLocal(List<Cars> arrayList, Context context) {
        boolean result = false;

        try {
            FileOutputStream fos = context.openFileOutput(Constants.CARS_DATA, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.flush();
            oos.close();
            result = true;
            Log.d("Success Writing file - ", "");
        } catch (Exception e) {
            Log.d("Error Writing file - ", e.toString());
            e.printStackTrace();
        }
        return result;
    }
}
