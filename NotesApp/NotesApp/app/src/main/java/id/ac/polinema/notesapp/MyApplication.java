package id.ac.polinema.notesapp;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MyApplication extends Application {

    public void OnCreate(){
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
