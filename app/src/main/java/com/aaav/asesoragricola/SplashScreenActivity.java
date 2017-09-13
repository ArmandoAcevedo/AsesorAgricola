package com.aaav.asesoragricola;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Armando Acevedo on 3/8/2017.
 */

public class SplashScreenActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        goToMainActivity();
        finish();
    }

    private void goToMainActivity() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
