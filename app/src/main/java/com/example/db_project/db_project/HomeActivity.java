package com.example.db_project.db_project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;


/**
 * Created by gicheonkang on 2017. 12. 7..
 */

public class HomeActivity extends AppCompatActivity {

    SQLiteDatabase sqliteDB;
    DBManager DBMgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ArrayList<researchColumn> ratings = SurveyActivity.getRatinglist();














        //testModule(); // 테스트용 모듈

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

    private void testModule()
    {
        // DB 매니저 생성
        DBMgr = new DBManager(this, "foodChoose", null, 1);

        DBMgr.resetDB(); // 중복된 튜플 삽입시 SQL Exception이 발생하므로, 우선 디비를 날리고
        DBMgr.initDB(); // 튜플들을 삽입합니다.

        // 이후로는 DB에 값이 잘 들어갔는지 확인하기 위해 로그캣에 디비 정보를 띄우는 코드입니다.
        ArrayList<String> restaurantSqlResult = DBMgr.getRestaurantTable();

        // TEST 설문결과

        researchColumn a = new researchColumn(1, 1);
        researchColumn b = new researchColumn(4, 2);
        researchColumn c = new researchColumn(3, 3);

        ArrayList<researchColumn> arr = new ArrayList<researchColumn>();
        arr.add(a);
        arr.add(b);
        arr.add(c);

        DBMgr.insertResearchResult(arr);

        // TEST 설문결과

        for(int i = 0; i < restaurantSqlResult.size(); i++)
        {
            Log.d("알림", restaurantSqlResult.get(i));
        }

        ArrayList<String> saleSqlResult = DBMgr.getSaleTable();

        for(int i = 0; i < saleSqlResult.size(); i++)
        {
            Log.d("알림", saleSqlResult.get(i));
        }

        ArrayList<String> menuSqlResult = DBMgr.getMenuTable();

        for(int i = 0; i < menuSqlResult.size(); i++)
        {
            Log.d("알림", menuSqlResult.get(i));
        }

        ArrayList<String> userSqlResult = DBMgr.getUserTable();

        for(int i = 0; i < userSqlResult.size(); i++)
        {
            Log.d("알림", userSqlResult.get(i));
        }

        ArrayList<String> reviewSqlResult = DBMgr.getReviewTable();

        for(int i = 0; i < reviewSqlResult.size(); i++)
        {
            Log.d("알림", reviewSqlResult.get(i));
        }

        ArrayList<recommendMenuColumn> recommendSqlResult = DBMgr.getRecommendTable();

        for(int i = 0; i < recommendSqlResult.size(); i++)
        {
            String res = recommendSqlResult.get(i).getRestaurant() + " "
                    + recommendSqlResult.get(i).getMenu() + " "
                    + recommendSqlResult.get(i).getPrice() + " "
                    + recommendSqlResult.get(i).getCount() + " ";

            Log.d("알림", res);
        }

        ArrayList<String> friendSqlResult = DBMgr.getFriendTable();

        for(int i = 0; i < friendSqlResult.size(); i++)
        {
            Log.d("알림", friendSqlResult.get(i));
        }

        ArrayList<sortResultColumn> sortSqlResult = DBMgr.getSortTable("중식");

        for(int i = 0; i < sortSqlResult.size(); i++)
        {
            String res = sortSqlResult.get(i).getName() + " "
                    + sortSqlResult.get(i).getScore() + " "
                    + sortSqlResult.get(i).getService() + " "
                    + sortSqlResult.get(i).getReviewCount() + " ";

            Log.d("알림", res);
        }
    }
}
