package com.cunha.samuel.monday.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cunha.samuel.monday.R;

import gr.net.maroulis.library.EasySplashScreen;

/**
 * @version 0.1
 * Created by Samuel Cunha on 12/12/17.
 */
public class SleepScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_screen);

        View easySplashScreenView = new EasySplashScreen(SleepScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(R.color.colorPrimary)
                .withFooterText("Copyright 2017")
                .withLogo(R.drawable.ic_monday)
                .withAfterLogoText("SWCunha")
                .create();

        setContentView(easySplashScreenView);
    }
}
