package com.example.alice.myhealth;

import android.app.Application;

import com.firebase.client.Firebase;


/**
 * Created by alice on 1/28/18.
 */

public class FireApp extends Application {



    @Override
    public void onCreate(){
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
