package com.example.db_project.db_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by gicheonkang on 2017. 12. 7..
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button friends_btn = (Button)findViewById(R.id.friendbtn);
        friends_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), FriendsActivity.class);
                        startActivity(intent);
                    }
                }
        );


    }

}
