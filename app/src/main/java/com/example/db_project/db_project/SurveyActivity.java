package com.example.db_project.db_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * Created by gicheonkang on 2017. 12. 7..
 */

public class SurveyActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        //final TextView tv = (TextView)findViewById(R.id.)
        RatingBar rb1 = (RatingBar)findViewById(R.id.ratingbar1);


        rb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                //tv.setText("rating : " + rating);
            }
        });
    }





}
