package com.example.marinecertificates;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

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

        // save data

    }


}
