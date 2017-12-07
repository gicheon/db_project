package com.example.db_project.db_project;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstTimeActivity extends AppCompatActivity{

    public Button btn1;
    public Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsttime);

        // btn1 : 나중에 할게요 btn2 : 좋아요
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        setup_ui();


        // survey activity start !
        btn2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Intent intent1 = new Intent(v.getContext(), SurveyActivity.class);
                        startActivity(intent1);
                    }
                }
        );
    }

    private void setup_ui(){
        btn1.setTextSize(18);
        btn2.setTextSize(18);
    }
}
