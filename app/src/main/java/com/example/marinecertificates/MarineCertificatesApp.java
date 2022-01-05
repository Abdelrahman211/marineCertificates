package com.example.marinecertificates;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MarineCertificatesApp extends Application {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    public ProfileList myProfileList;
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        myProfileList =  new ProfileList();
        loadDate();
        //load saved data
    }
    public static Context getContext() {
        //  return instance.getApplicationContext();
        return mContext;
    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate(){
        super.onTerminate();

    }

    public void saveData(){
        SharedPreferences sharedpreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(myProfileList.addedItems);
        editor.putString("profile list",json);
        editor.apply();
    }
    private void loadDate(){
        SharedPreferences sharedpreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedpreferences.getString("profile list",null);
        Type type = new TypeToken<ArrayList<CardItem>>(){}.getType();
        myProfileList.addedItems=  gson.fromJson(json,type);
        if(myProfileList.addedItems==null)
            myProfileList.addedItems= new ArrayList<>();
    }


}
