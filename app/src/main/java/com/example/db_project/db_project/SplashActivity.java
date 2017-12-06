package com.example.db_project.db_project;

/**
 * Created by gicheonkang on 2017. 12. 6..
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Handler hd = new Handler();

        hd.postDelayed(new splashhandler(), 3000);
    }

    private class splashhandler implements Runnable{

        @Override
        public void run() {
            startActivity(new Intent(getApplication(), FirstTimeActivity.class));
            SplashActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed(){}

}