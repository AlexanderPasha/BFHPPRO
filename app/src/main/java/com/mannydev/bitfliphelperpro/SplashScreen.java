package com.mannydev.bitfliphelperpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mannydev.bitfliphelperpro.bitflip.Controller;


/**
 * Created by manny on 17.01.18.
 */

public class SplashScreen extends AppCompatActivity {
    public static Controller controller;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        for (int i =0;i<100000000;i++){
            int a=i+i;
        }


        startActivity(intent);
        finish();


    }
}
