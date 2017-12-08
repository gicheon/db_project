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

public class SurveyActivity extends AppCompatActivity{

    public int ratingCount = 0;
    public Button finish_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        finish_btn = (Button)findViewById(R.id.finish_btn);
        finish_btn.setTextSize(20);

        final TextView tv = (TextView)findViewById(R.id.foodcount);
        tv.setText(Integer.toString(ratingCount));
        RatingBar rb1 = (RatingBar)findViewById(R.id.ratingbar1);
        RatingBar rb2 = (RatingBar)findViewById(R.id.ratingbar2);
        RatingBar rb3 = (RatingBar)findViewById(R.id.ratingbar3);
        RatingBar rb4 = (RatingBar)findViewById(R.id.ratingbar4);
        RatingBar rb5 = (RatingBar)findViewById(R.id.ratingbar5);
        RatingBar rb6 = (RatingBar)findViewById(R.id.ratingbar6);
        RatingBar rb7 = (RatingBar)findViewById(R.id.ratingbar7);
        RatingBar rb8 = (RatingBar)findViewById(R.id.ratingbar8);
        RatingBar rb9 = (RatingBar)findViewById(R.id.ratingbar9);
        RatingBar rb10 = (RatingBar)findViewById(R.id.ratingbar10);



        rb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });

        rb2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });

        rb3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });

        rb4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });

        rb5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });
        rb6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });
        rb7.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });
        rb8.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });
        rb9.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });
        rb10.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
            }
        });

        // survey activity start !
        finish_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                }
        );


    }
}
