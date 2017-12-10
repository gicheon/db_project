package com.example.db_project.db_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

// 데이터베이스 매니져 클래스
public class DBManager extends SQLiteOpenHelper
{
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    // 데이터 베이스 첫 생성시 호출. 프로그램에 쓰일 테이블들 생성.
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE restaurant (" +
                "name TEXT PRIMARY KEY, " +
                "sort TEXT, " +
                "service INTEGER)");

        db.execSQL("CREATE TABLE sale (" +
                "name TEXT," +
                "menu_id INTEGER PRIMARY KEY," +
                "FOREIGN KEY(name) REFERENCES restaurant(name))");

        db.execSQL("CREATE TABLE menu (" +
                "menu_id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "price INTEGER," +
                "quantity INTEGER," +
                "spice INTEGER," +
                "creamy INTEGER," +
                "hot INTEGER," +
                "sweet INTEGER," +
                "review_count INTEGER)");

        db.execSQL("CREATE TABLE user (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "pref_quantity INTEGER," +
                "pref_spice INTEGER," +
                "pref_creamy INTEGER," +
                "pref_hot INTEGER," +
                "pref_sweet INTEGER)");

        db.execSQL("CREATE TABLE review (" +
                "id TEXT," +
                "menu_id INTEGER," +
                "review_score INTEGER," +
                "dining_count INTEGER," +
                "PRIMARY KEY (id, menu_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    // 데이터베이스 각 테이블에 임의의 칼럼들을 삽입함
    public void initDB()
    {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'중식집', '중식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'양식집', '양식', 80)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'한식집', '한식', 90)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'한식집이', '한식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'한식집삼', '한식', 30)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'중식집', 1)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'중식집', 2)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'양식집', 3)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집', 4)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집', 5)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'양식집', 6)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집', 7)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집', 8)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'중식집', 9)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집', 10)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집이', 11)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집이', 12)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'한식집삼', 13)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "1, '짜장면', 3000, 40, 40, 70, 40, 40, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "2, '짬뽕', 5000, 70, 40, 40, 40, 40, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "3, '돈까스', 7000, 40, 40, 40, 40, 70, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "4, '제육', 6000, 20, 40, 40, 40, 40, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "5, '냉면', 5000, 20, 80, 70, 20, 20, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "6, '육', 6000, 50, 30, 20, 30, 30, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "7, '칠', 5000, 50, 50, 50, 50, 50, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "8, '팔', 5000, 20, 20, 20, 20, 20, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "9, '구', 5000, 40, 40, 40, 40, 40, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "10, '십', 5000, 20, 70, 20, 70, 20, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "11, '십일', 1000, 10, 10, 10, 10, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "12, '십이', 1000, 10, 10, 10, 10, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "13, '십삼', 1000, 10, 10, 10, 10, 10, 10)");

        db.execSQL("INSERT INTO user VALUES(" +
                "1, '일일일', 50, 50, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "2, '이이이', 80, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "3, '삼삼삼', 40, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "4, '사사사', 50, 60, 40, 50, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "5, '오오오', 40, 40, 70, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "6, '육육육', 40, 70, 70, 70, 70)");
        db.execSQL("INSERT INTO user VALUES(" +
                "7, '칠칠칠', 90, 40, 40, 40, 40)");

        db.execSQL("INSERT INTO review VALUES(" +
                "1, 1, 50, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 2, 60, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "3, 3, 70, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "2, 5, 20, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 4, 30, 9)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 12, 50, 3)");

        db.close();
    }

    // 데이터베이스의 모든 칼럼을 날림
    public void resetDB()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM restaurant");
        db.execSQL("DELETE FROM sale");
        db.execSQL("DELETE FROM menu");
        db.execSQL("DELETE FROM user");
        db.execSQL("DELETE FROM review");
        db.close();
    }

    // 식당 테이블을 ("이름 종류 점수\n") 형태의 칼럼 어레이로 반환
    public ArrayList<String> getRestaurantTable()
    {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<String> result = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT * FROM restaurant", null);
        while(cursor.moveToNext())
        {
            String col = "";

            col += cursor.getString(0) + "  "
                    + cursor.getString(1) + "  "
                    + cursor.getString(2) + "\n";

            result.add(col);
        }
        db.close();
        return result;
    }

    // 판매 테이블을 ("이름 메뉴코드\n") 형태의 칼럼 어레이로 반환
    public ArrayList<String> getSaleTable()
    {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<String> result = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT * FROM sale", null);
        while(cursor.moveToNext())
        {
            String col = "";

            col += cursor.getString(0) + "  "
                    + cursor.getString(1) + "\n";

            result.add(col);
        }
        db.close();
        return result;
    }

    // 메뉴 테이블을 ("메뉴코드 이름 가격 각종점수\n") 형태의 칼럼 어레이로 반환
    public ArrayList<String> getMenuTable()
    {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<String> result = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT * FROM menu", null);
        while(cursor.moveToNext())
        {
            String col = "";

            col += cursor.getString(0) + "  "
                    + cursor.getString(1) + "  "
                    + cursor.getString(2) + "  "
                    + cursor.getString(3) + "  "
                    + cursor.getString(4) + "  "
                    + cursor.getString(5) + "  "
                    + cursor.getString(6) + "  "
                    + cursor.getString(7) + "  "
                    + cursor.getString(8) + "\n";

            result.add(col);
        }
        db.close();
        return result;
    }

    // 유저 테이블을 ("아이디 이름 가격 각종기호점수\n") 형태의 칼럼 어레이로 반환
    public ArrayList<String> getUserTable()
    {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<String> result = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT * FROM user", null);
        while(cursor.moveToNext())
        {
            String col = "";

            col += cursor.getString(0) + "  "
                    + cursor.getString(1) + "  "
                    + cursor.getString(2) + "  "
                    + cursor.getString(3) + "  "
                    + cursor.getString(4) + "  "
                    + cursor.getString(5) + "  "
                    + cursor.getString(6) +  "\n";

            result.add(col);
        }
        db.close();
        return result;
    }

    // 식당 테이블을 ("아이디 메뉴코드 점수\n") 형태의 칼럼 어레이로 반환
    public ArrayList<String> getReviewTable()
    {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<String> result = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT * FROM review", null);
        while(cursor.moveToNext())
        {
            String col = "";

            col += cursor.getString(0) + "  "
                    + cursor.getString(1) + "  "
                    + cursor.getString(2) + "  "
                    + cursor.getString(3) + "\n";

            result.add(col);
        }
        db.close();
        return result;
    }

    public ArrayList<recommendMenuColumn> getRecommendTable()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<recommendMenuColumn> result = new ArrayList<recommendMenuColumn>();
        Cursor cursor = null;
        Cursor subCursor = null;

        int dist = 10;
        int tableSize = 0;
        final int minTableSize = 5;

        cursor = db.rawQuery("SELECT * FROM user WHERE id = 1", null);

        cursor.moveToNext();
        userColumn user = new userColumn(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getInt(3),
                cursor.getInt(4),
                cursor.getInt(5),
                cursor.getInt(6)
        );

        String userInfo = user.getId() + " " + user.getName() + " " + user.getQuantityPref()
                + " " + user.getSpicePref() + " " + user.getCreamyPref()
                + " " + user.getHotPref() + " " + user.getSweetPref();
        Log.d("유저정보", userInfo);

        while (true)
        {
            cursor = null;

            Log.d("디버깅", "sql 발동");
            cursor = db.rawQuery("SELECT DISTINCT sale.name, menu.name, menu.price, menu.menu_id, restaurant.sort " +
                            "FROM sale, menu, restaurant " +
                            "WHERE " +
                            "(menu.quantity BETWEEN " + (user.getQuantityPref() - dist) + " AND " + (user.getQuantityPref() + dist) + ")" +
                            "AND " +
                            "(menu.spice BETWEEN " + (user.getSpicePref() - dist) + " AND " + (user.getSpicePref() + dist) + ")" +
                            "AND " +
                            "(menu.creamy BETWEEN " + (user.getCreamyPref() - dist) + " AND " + (user.getCreamyPref() + dist) + ")" +
                            "AND " +
                            "(menu.hot BETWEEN " + (user.getHotPref() - dist) + " AND " + (user.getHotPref() + dist) + ")" +
                            "AND " +
                            "(menu.sweet BETWEEN " + (user.getSweetPref() - dist) + " AND " + (user.getSweetPref() + dist) + ")" +
                            "AND " +
                            "(menu.menu_id = sale.menu_id)" +
                            "AND" +
                            "(sale.name = restaurant.name)",
                    null);
            Log.d("디버깅", "sql 완료");

            if(cursor.getCount() >= minTableSize)
            {
                String restaurant = "";
                String menu ="";
                int price = 0;
                int menu_id = 0;
                int reviewCount = 0;
                String sort ="";

                while(cursor.moveToNext())
                {
                    restaurant = cursor.getString(0);
                    menu = cursor.getString(1);
                    price = cursor.getInt(2);

                    menu_id =  cursor.getInt(3);
                    sort = cursor.getString(4);

                    subCursor = null;
                    subCursor = db.rawQuery("SELECT dining_count FROM review " +
                            "WHERE (menu_id = " + menu_id + " )" +
                            "AND (id = 1)", null);

                    if(subCursor.getCount() > 0)
                    {
                        subCursor.moveToNext();
                        reviewCount = subCursor.getInt(0);
                    }

                    else
                    {
                        reviewCount = 0;
                    }

                    recommendMenuColumn col = new recommendMenuColumn(
                            restaurant, menu, price,  reviewCount, sort);
                    result.add(col);
                }

                tableSize = cursor.getCount();
                break;
            }

            dist += 5;
        }
        db.close();

        /*ArrayList<recommendMenuColumn> croppedResult = new ArrayList<recommendMenuColumn>();
        int[] randSeq = getRandomSequence(tableSize, 5);

        for(int i = 0; i < 5; i++)
        {
            croppedResult.add(result.get(randSeq[i]));
        }

        //return croppedResult;*/

        return result;
    }

    public ArrayList<String> getFriendTable()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> result = new ArrayList<String>();
        Cursor cursor = null;

        int dist = 10;
        int tableSize = 0;
        final int minTableSize = 3;

        cursor = db.rawQuery("SELECT * FROM user WHERE id = 1", null);

        cursor.moveToNext();
        userColumn user = new userColumn(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getInt(3),
                cursor.getInt(4),
                cursor.getInt(5),
                cursor.getInt(6)
        );

        String userInfo = user.getId() + " " + user.getName() + " " + user.getQuantityPref()
                + " " + user.getSpicePref() + " " + user.getCreamyPref()
                + " " + user.getHotPref() + " " + user.getSweetPref();
        Log.d("유저정보", userInfo);

        while (true)
        {
            cursor = null;

            Log.d("디버깅", "친추 sql 발동");
            cursor = db.rawQuery("SELECT DISTINCT name FROM user WHERE" +
                            "(pref_quantity BETWEEN " + (user.getQuantityPref() - dist) + " AND " + (user.getQuantityPref() + dist) + ")" +
                            "AND " +
                            "(pref_spice BETWEEN " + (user.getSpicePref() - dist) + " AND " + (user.getSpicePref() + dist) + ")" +
                            "AND " +
                            "(pref_creamy BETWEEN " + (user.getCreamyPref() - dist) + " AND " + (user.getCreamyPref() + dist) + ")" +
                            "AND " +
                            "(pref_hot BETWEEN " + (user.getHotPref() - dist) + " AND " + (user.getHotPref() + dist) + ")" +
                            "AND " +
                            "(pref_sweet BETWEEN " + (user.getSweetPref() - dist) + " AND " + (user.getSweetPref() + dist) + ")" +
                            "AND " +
                            "id != 1",
                    null);
            Log.d("디버깅", "친추 sql 완료");

            if(cursor.getCount() >= minTableSize)
            {
                while(cursor.moveToNext())
                {
                    String res = cursor.getString(0);
                    result.add(res);
                }

                tableSize = cursor.getCount();
                break;
            }

            dist += 5;
        }

        db.close();

        /*ArrayList<String> croppedResult = new ArrayList<String>();
        int[] randSeq = getRandomSequence(tableSize, 7);

        for(int i = 0; i < 7; i++)
        {
            croppedResult.add(result.get(randSeq[i]));
        }

        return croppedResult;*/

        return result;
    }

    public void insertResearchResult(ArrayList<researchColumn> input)
    {
        float count = 0;
        int sumQuantity = 0, sumSpice = 0, sumCreamy = 0, sumHot = 0, sumSweet = 0;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;

        for(int i = 0; i < input.size(); i++)
        {
            cursor = null;
            cursor = db.rawQuery("SELECT * FROM menu " +
                    "WHERE menu_id = " + input.get(i).id, null);

            cursor.moveToNext();

            sumQuantity += (int)(cursor.getInt(3) * input.get(i).score);
            sumSpice += (int)(cursor.getInt(4) * input.get(i).score);
            sumCreamy += (int)(cursor.getInt(5) * input.get(i).score);
            sumHot += (int)(cursor.getInt(6) * input.get(i).score);
            sumSweet+= (int)(cursor.getInt(7) * input.get(i).score);

            count += input.get(i).score;
        }

        db.close();
        db = null;
        db = getWritableDatabase();

        // for test use user 8
        db.execSQL("DELETE FROM user WHERE id = 8");

        if(count == 0)
        {
            Log.d ("디버깅", "인서트 쿼리 발동");
            db.execSQL("INSERT INTO user VALUES" +
                    "(8, '팔팔팔', 50, 50, 50, 50, 50) ");
            Log.d ("디버깅", "인서트 쿼리 완료");
        }

        else
        {
            Log.d ("디버깅", "인서트 쿼리 발동");
            db.execSQL("INSERT INTO user VALUES" +
                    "(8, '팔팔팔', " +
                    (int)(sumQuantity / count) + ", " +
                    (int)(sumSpice / count) + ", " +
                    (int)(sumCreamy / count) + ", " +
                    (int)(sumHot / count) + ", " +
                    (int)(sumSweet / count) + " )");
            Log.d ("디버깅", "인서트 쿼리 완료");
        }
        //for test 연동시 UPDATE SET 문으로 교체할것
    }


    public ArrayList<sortResultColumn> getSortTable(String sort)
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<sortResultColumn> result = new ArrayList<sortResultColumn>();
        Cursor cursor = null;
        Cursor subCursor;

        cursor = db.rawQuery("SELECT name, service FROM restaurant " +
                "WHERE sort = '" + sort + "'", null);

        while(cursor.moveToNext())
        {
            subCursor = null;
            subCursor = db.rawQuery("SELECT SUM(review_score * dining_count), SUM(dining_count) FROM review " +
                    "WHERE menu_id IN (" +
                    "SELECT menu_id FROM sale WHERE name = '" +
                    cursor.getString(0) + "')", null);

            int score = 0;

            subCursor.moveToNext();
            int count = subCursor.getInt(1);

            if(count != 0)
            {
                count = subCursor.getInt(1);
                score = subCursor.getInt(0) / count;
            }

            sortResultColumn col = new sortResultColumn(cursor.getString(0), score, cursor.getInt(1), count);
            result.add(col);
        }

        return result;
    }

    private int[] getRandomSequence(int total, int count)
    {
        int[] randomSeq = new int[count];
        boolean[] rebundCheck = new boolean[total];
        int finishedNum = 0;

        for(int i = 0; i < count; i++)
        {
            rebundCheck[i] = false;
        }

        for(finishedNum = 0; finishedNum < count;)
        {
            Random rand = new Random();
            int randNum = rand.nextInt(total);

            if(!rebundCheck[randNum])
            {
                randomSeq[finishedNum] = randNum;
                rebundCheck[randNum] = true;
                finishedNum++;
            }

        }
        return randomSeq;
    }
}