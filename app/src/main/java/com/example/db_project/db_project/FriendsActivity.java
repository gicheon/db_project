package com.example.db_project.db_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by gicheonkang on 2017. 12. 8..
 */

public class FriendsActivity extends AppCompatActivity{

    Button frn1_btn;
    Button frn2_btn;
    Button frn3_btn;
    Button frn4_btn;
    Button frn5_btn;
    Button frn6_btn;
    Button frn7_btn;


    TextView frn1_txt;
    TextView frn2_txt;
    TextView frn3_txt;
    TextView frn4_txt;
    TextView frn5_txt;
    TextView frn6_txt;
    TextView frn7_txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        frn1_btn = (Button)findViewById(R.id.frn_button1);
        frn2_btn = (Button)findViewById(R.id.frn_button2);
        frn3_btn = (Button)findViewById(R.id.frn_button3);
        frn4_btn = (Button)findViewById(R.id.frn_button4);
        frn5_btn = (Button)findViewById(R.id.frn_button5);
        frn6_btn = (Button)findViewById(R.id.frn_button6);
        frn7_btn = (Button)findViewById(R.id.frn_button7);


        frn1_txt = (TextView)findViewById(R.id.frn_textView1);
        frn2_txt = (TextView)findViewById(R.id.frn_textView2);
        frn3_txt = (TextView)findViewById(R.id.frn_textView3);
        frn4_txt = (TextView)findViewById(R.id.frn_textView4);
        frn5_txt = (TextView)findViewById(R.id.frn_textView5);
        frn6_txt = (TextView)findViewById(R.id.frn_textView6);
        frn7_txt = (TextView)findViewById(R.id.frn_textView7);


        setup_ui();

        frn1_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getApplicationContext(),frn1_txt.getText()+"에게 신청하였습니다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                }
        );

        frn2_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getApplicationContext(),frn2_txt.getText()+"에게 신청하였습니다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                }
        );

        frn3_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getApplicationContext(),frn3_txt.getText()+"에게 신청하였습니다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                }
        );

        frn4_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getApplicationContext(),frn4_txt.getText()+"에게 신청하였습니다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                }
        );

        frn5_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getApplicationContext(),frn5_txt.getText()+"에게 신청하였습니다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                }
        );

        frn6_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getApplicationContext(),frn6_txt.getText()+"에게 신청하였습니다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                }
        );

        frn7_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getApplicationContext(),frn7_txt.getText()+"에게 신청하였습니다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                }
        );

    }

    private void setup_ui(){
        frn1_btn.setTextSize(20);
        frn2_btn.setTextSize(20);
        frn3_btn.setTextSize(20);
        frn4_btn.setTextSize(20);
        frn5_btn.setTextSize(20);
        frn6_btn.setTextSize(20);
        frn7_btn.setTextSize(20);
    }
}
