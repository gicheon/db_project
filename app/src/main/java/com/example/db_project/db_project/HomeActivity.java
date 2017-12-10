package com.example.db_project.db_project;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by gicheonkang on 2017. 12. 7..
 */

public class HomeActivity extends AppCompatActivity {

    public SQLiteDatabase sqliteDB;
    public DBManager DBMgr;
    public ArrayList<recommendMenuColumn> recommendSqlResult;
    public static ArrayList<String> friendSqlResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //EditText testTxt = (EditText)findViewById(R.id.editText);
        //testTxt.setText("id: " + ratings.get(5).id + " ratings: " +ratings.get(5).score);

        ImageButton friends_btn = (ImageButton)findViewById(R.id.imageButton5);
        ImageView recommend1_type_image = (ImageView)findViewById(R.id.recommend_type_image1);
        ImageView recommend2_type_image = (ImageView)findViewById(R.id.recommend_type_image2);
        ImageView recommend3_type_image = (ImageView)findViewById(R.id.recommend_type_image3);


        TextView recommend_title_text1 = (TextView)findViewById(R.id.recommend_title_text1);
        TextView recommend_title_text2 = (TextView)findViewById(R.id.recommend_title_text2);
        TextView recommend_title_text3 = (TextView)findViewById(R.id.recommend_title_text3);

        TextView recommend_menu_text1 = (TextView)findViewById(R.id.recommend_menu_text1);
        TextView recommend_menu_text2 = (TextView)findViewById(R.id.recommend_menu_text2);
        TextView recommend_menu_text3 = (TextView)findViewById(R.id.recommend_menu_text3);

        TextView rec_price1 = (TextView)findViewById(R.id.rec_price1);
        TextView rec_price2 = (TextView)findViewById(R.id.rec_price2);
        TextView rec_price3 = (TextView)findViewById(R.id.rec_price3);

        TextView rec_count1 = (TextView)findViewById(R.id.rec_count1);
        TextView rec_count2 = (TextView)findViewById(R.id.rec_count2);
        TextView rec_count3 = (TextView)findViewById(R.id.rec_count3);


        recommend_title_text1.setTypeface(null, Typeface.BOLD);
        recommend_title_text2.setTypeface(null, Typeface.BOLD);
        recommend_title_text3.setTypeface(null, Typeface.BOLD);
        recommend_menu_text1.setTypeface(null, Typeface.BOLD);
        recommend_menu_text2.setTypeface(null, Typeface.BOLD);
        recommend_menu_text3.setTypeface(null, Typeface.BOLD);

        Button rec_btn1 = (Button)findViewById(R.id.rec_btn1);
        Button rec_btn2 = (Button)findViewById(R.id.rec_btn2);
        Button rec_btn3 = (Button)findViewById(R.id.rec_btn3);

        Button rec_btn4 = (Button)findViewById(R.id.rec_btn4);
        Button rec_btn5 = (Button)findViewById(R.id.rec_btn5);
        Button rec_btn6 = (Button)findViewById(R.id.rec_btn6);

        Button rec_btn7 = (Button)findViewById(R.id.rec_btn7);
        Button rec_btn8 = (Button)findViewById(R.id.rec_btn8);
        Button rec_btn9 = (Button)findViewById(R.id.rec_btn9);

        Resources res = getResources();
        String str_temp = res.getString(R.string.hearts);
        rec_btn1.setText(str_temp + " 먹고싶어요");

        str_temp = res.getString(R.string.stars);
        rec_btn2.setText(str_temp+ " 평가하기");

        str_temp = res.getString(R.string.evaluation);
        rec_btn3.setText(str_temp+ " 코멘트");

        str_temp = res.getString(R.string.hearts);
        rec_btn4.setText(str_temp + " 먹고싶어요");

        str_temp = res.getString(R.string.stars);
        rec_btn5.setText(str_temp+ " 평가하기");

        str_temp = res.getString(R.string.evaluation);
        rec_btn6.setText(str_temp+ " 코멘트");

        str_temp = res.getString(R.string.hearts);
        rec_btn7.setText(str_temp + " 먹고싶어요");

        str_temp = res.getString(R.string.stars);
        rec_btn8.setText(str_temp+ " 평가하기");

        str_temp = res.getString(R.string.evaluation);
        rec_btn9.setText(str_temp+ " 코멘트");


        //ArrayList<researchColumn> ratings = SurveyActivity.getRatinglist();
        testModule(); // 테스트용 모듈

        recommend_title_text1.setText(recommendSqlResult.get(0).getRestaurant());
        recommend_title_text2.setText(recommendSqlResult.get(1).getRestaurant());
        recommend_title_text3.setText(recommendSqlResult.get(2).getRestaurant());

        recommend_menu_text1.setText(recommendSqlResult.get(0).getMenu());
        recommend_menu_text2.setText(recommendSqlResult.get(1).getMenu());
        recommend_menu_text3.setText(recommendSqlResult.get(2).getMenu());

        rec_price1.setText("가격: "+recommendSqlResult.get(0).getPrice() + "원");
        rec_price2.setText("가격: "+recommendSqlResult.get(1).getPrice() + "원");
        rec_price3.setText("가격: "+recommendSqlResult.get(2).getPrice() + "원");

        rec_count1.setText("방문횟수: "+recommendSqlResult.get(0).getCount() + "회");
        rec_count2.setText("방문횟수: "+recommendSqlResult.get(1).getCount() + "회");
        rec_count3.setText("방문횟수: "+recommendSqlResult.get(2).getCount() + "회");


        System.out.println((recommendSqlResult.get(0).getSort()));
        System.out.println((recommendSqlResult.get(1).getSort()));
        System.out.println((recommendSqlResult.get(2).getSort()));


        String korean = new String("한식");
        String chinese = new String("중식");
        String japanese = new String("일식");
        String western = new String("양식");


        if (recommendSqlResult.get(0).getSort().equals(korean)){
            recommend1_type_image.setImageResource(R.drawable.type_korean);
        }
        else if(recommendSqlResult.get(0).getSort().equals(chinese)){
            recommend1_type_image.setImageResource(R.drawable.type_chinese);
        }
        else if(recommendSqlResult.get(0).getSort().equals(western)){
            recommend1_type_image.setImageResource(R.drawable.type_western);
        }
        else{
            recommend1_type_image.setImageResource(R.drawable.type_japanese);
        }

        if (recommendSqlResult.get(1).getSort().equals(korean)){
            recommend2_type_image.setImageResource(R.drawable.type_korean);
        }
        else if(recommendSqlResult.get(1).getSort().equals(chinese)){
            recommend2_type_image.setImageResource(R.drawable.type_chinese);
        }
        else if(recommendSqlResult.get(1).getSort().equals(western)){
            recommend2_type_image.setImageResource(R.drawable.type_western);
        }
        else{
            recommend2_type_image.setImageResource(R.drawable.type_japanese);
        }


        if (recommendSqlResult.get(2).getSort().equals(korean)){
            recommend3_type_image.setImageResource(R.drawable.type_korean);
        }
        else if(recommendSqlResult.get(2).getSort().equals(chinese)){
            recommend3_type_image.setImageResource(R.drawable.type_chinese);
        }
        else if(recommendSqlResult.get(2).getSort().equals(western)){
            recommend3_type_image.setImageResource(R.drawable.type_western);
        }
        else{
            recommend3_type_image.setImageResource(R.drawable.type_japanese);
        }



        // friends list
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


        ArrayList<researchColumn> arr = SurveyActivity.getRatinglist();
        DBMgr.insertResearchResult(arr);

        // TEST 설문결과

        /*
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

        */

        // 맛집 3개 추천 정보
        recommendSqlResult = DBMgr.getRecommendTable();



        for(int i = 0; i < recommendSqlResult.size(); i++)
        {
            String res = recommendSqlResult.get(i).getRestaurant() + " "
                    + recommendSqlResult.get(i).getMenu() + " "
                    + recommendSqlResult.get(i).getPrice() + " "
                    + recommendSqlResult.get(i).getCount() + " ";

            //Log.d("추천", res);
        }



        friendSqlResult = DBMgr.getFriendTable();
        for(int i = 0; i < friendSqlResult.size(); i++)
        {
            Log.d("알림", friendSqlResult.get(i));
        }

        /*
        ArrayList<sortResultColumn> sortSqlResult = DBMgr.getSortTable("중식");

        for(int i = 0; i < sortSqlResult.size(); i++)
        {
            String res = sortSqlResult.get(i).getName() + " "
                    + sortSqlResult.get(i).getScore() + " "
                    + sortSqlResult.get(i).getService() + " "
                    + sortSqlResult.get(i).getReviewCount() + " ";

            Log.d("알림", res);
        }
        */

    }
}
