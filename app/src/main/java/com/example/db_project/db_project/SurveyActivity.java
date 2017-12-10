package com.example.db_project.db_project;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


/**
 * Created by gicheonkang on 2017. 12. 7..
 */


public class SurveyActivity extends AppCompatActivity{

    public int ratingCount = 0;
    public Button finish_btn;
    public static ArrayList<researchColumn> ratingList = new ArrayList<researchColumn>(10);


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


        for(int i =0; i<10; i++)
            ratingList.add(i, new researchColumn(0, i));


        rb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(0, new researchColumn(rating, 151));
            }
        });

        rb2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(1, new researchColumn(rating, 152));
            }
        });

        rb3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(2, new researchColumn(rating, 153));
            }
        });

        rb4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(3, new researchColumn(rating, 154));
            }
        });

        rb5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(4, new researchColumn(rating, 155));
            }
        });
        rb6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(5, new researchColumn(rating, 156));

            }
        });
        rb7.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(6, new researchColumn(rating, 157));
            }
        });
        rb8.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(7, new researchColumn(rating, 158));
            }
        });
        rb9.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(8, new researchColumn(rating, 159));

            }
        });
        rb10.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingCount++;
                tv.setText(Integer.toString(ratingCount));
                ratingList.set(9, new researchColumn(rating, 160));

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

    public static ArrayList<researchColumn> getRatinglist(){
        return ratingList;
    }
}
