package com.example.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splash_Activity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar = (ProgressBar)findViewById(R.id.progressBar_id);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                gotoApp();
            }
        });
        thread.start();
    }

    public void dowork(){
       for (progresses=1;progresses<=100;progresses=progresses+1){
           try {
               Thread.sleep(20
               );progressBar.setProgress(progresses);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    public void gotoApp(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}