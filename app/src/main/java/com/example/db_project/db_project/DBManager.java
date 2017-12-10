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
    // 제출 시 삭제 예정인 코드
    public void initDB()
    {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'안사맨', '중식', 10)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'아주반점', '중식', 80)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'홍콩반점', '중식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'마카오반점', '중식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'홍마반점', '중식', 70)"); // 5
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'아주맛있는중국집', '중식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'더차이나', '중식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'아주차이나', '중식', 20)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'차이차이', '중식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'뽕스토리', '중식', 80)"); // 10
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'흥부각', '중식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'중화반점', '중식', 20)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'몽고반점', '중식', 30)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'차이나타임', '중식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'짬뽕타임', '중식', 80)"); // 15

        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'기숙사식당', '한식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'학생식당', '한식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'교직원식당', '한식', 70)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'팔매', '한식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'다매', '한식', 60)"); // 20
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'미스터쉐프', '한식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'밥도둑', '한식', 30)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'양푼이', '한식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'아주맛있는한식집', '한식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'집밥', '한식', 90)"); // 25
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'깐돌이네', '한식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'내찜닭', '한식', 70)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'꽃찬찜닭', '한식', 90)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'의정부부대찌게', '한식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'맛9단', '한식', 90)"); // 30

        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'베네치아', '양식', 80)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'줌데렐라', '양식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'푸드테라피', '양식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'파스타앤그릴', '양식', 30)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'원스쿱앤고', '양식', 10)"); // 35
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'도스마스', '양식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'밀플랜B', '양식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'VIPS', '양식', 90)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'슈퍼스테이크', '양식', 70)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'도담도담치킨', '양식', 90)"); // 40

        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'멘야고이치', '일식', 60)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'아대돈부리', '일식', 70)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'스시웨이', '일식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'고씨네카레', '일식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'이랏샤이마세', '일식', 90)"); // 45
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'이타다키마스', '일식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'산초메', '일식', 30)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'화산', '일식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'미소야', '일식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'기린식당', '일식', 60)"); // 50

        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'본수원갈비', '한식', 70)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'시골집', '한식', 80)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'이모네손칼국수', '한식', 70)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'만고쿠', '일식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'에스팟', '한식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'미스사이공', '양식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'맥도날드', '양식', 50)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'엽기떡볶이', '한식', 40)");
        db.execSQL("INSERT INTO restaurant VALUES(" +
                "'아웃닭', '양식', 60)");

        ///////////////////////////////////////////////////////////

        db.execSQL("INSERT INTO sale VALUES(" +
                "'안사맨', 1)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'안사맨', 2)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'안사맨', 3)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주반점', 4)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주반점', 5)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주반점', 6)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'홍콩반점', 7)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'홍콩반점', 8)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'홍콩반점', 9)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'마카오반점', 10)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'마카오반점', 11)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'마카오반점', 12)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'홍마반점', 13)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'홍마반점', 14)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'홍마반점', 15)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주맛있는중국집', 16)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주맛있는중국집', 17)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주맛있는중국집', 18)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'더차이나', 19)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'더차이나', 20)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'더차이나', 21)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주차이나', 22)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주차이나', 23)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주차이나', 24)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'차이차이', 25)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'차이차이', 26)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'차이차이', 27)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'뽕스토리', 28)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'뽕스토리', 29)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'뽕스토리', 30)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'흥부각', 31)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'흥부각', 32)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'흥부각', 33)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'중화반점', 34)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'중화반점', 35)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'중화반점', 36)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'몽고반점', 37)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'몽고반점', 38)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'몽고반점', 39)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'차이나타임', 40)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'차이나타임', 41)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'차이나타임', 42)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'짬뽕타임', 43)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'짬뽕타임', 44)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'짬뽕타임', 45)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'기숙사식당', 46)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'기숙사식당', 47)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'기숙사식당', 48)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'학생식당', 49)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'학생식당', 50)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'학생식당', 51)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'교직원식당', 52)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'교직원식당', 53)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'교직원식당', 54)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'팔매', 55)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'팔매', 56)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'팔매', 57)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'다매', 58)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'다매', 59)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'다매', 60)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'미스터쉐프', 61)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'미스터쉐프', 62)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'미스터쉐프', 63)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'밥도둑', 64)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'밥도둑', 65)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'밥도둑', 66)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'양푼이', 67)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'양푼이', 68)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'양푼이', 69)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주맛있는한식집', 70)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주맛있는한식집', 71)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아주맛있는한식집', 72)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'집밥', 73)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'집밥', 74)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'집밥', 75)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'깐돌이네', 76)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'깐돌이네', 77)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'깐돌이네', 78)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'내찜닭', 79)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'내찜닭', 80)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'내찜닭', 81)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'꽃찬찜닭', 82)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'꽃찬찜닭', 83)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'꽃찬찜닭', 84)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'의정부부대찌게', 85)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'의정부부대찌게', 86)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'의정부부대찌게', 87)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'맛9단', 88)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'맛9단', 89)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'맛9단', 90)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'베네치아', 91)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'베네치아', 92)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'베네치아', 93)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'줌데렐라', 94)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'줌데렐라', 95)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'줌데렐라', 96)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'푸드테라피', 97)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'푸드테라피', 98)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'푸드테라피', 99)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'파스타앤그릴', 100)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'파스타앤그릴', 101)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'파스타앤그릴', 102)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'원스쿱앤고', 103)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'원스쿱앤고', 104)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'원스쿱앤고', 105)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'도스마스', 106)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'도스마스', 107)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'도스마스', 108)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'밀플랜B', 109)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'밀플랜B', 110)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'밀플랜B', 111)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'VIPS', 112)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'VIPS', 113)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'VIPS', 114)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'슈퍼스테이크', 115)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'슈퍼스테이크', 116)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'슈퍼스테이크', 117)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'도담도담치킨', 118)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'도담도담치킨', 119)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'도담도담치킨', 120)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'멘야고이치', 121)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'멘야고이치', 122)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'멘야고이치', 123)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'아대돈부리', 124)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아대돈부리', 125)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아대돈부리', 126)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'스시웨이', 127)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'스시웨이', 128)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'스시웨이', 129)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'고씨네카레', 130)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'고씨네카레', 131)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'고씨네카레', 132)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'이랏샤이마세', 133)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'이랏샤이마세', 134)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'이랏샤이마세', 135)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'이타다키마스', 136)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'이타다키마스', 137)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'이타다키마스', 138)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'산초메', 139)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'산초메', 140)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'산초메', 141)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'화산', 142)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'화산', 143)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'화산', 144)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'미소야', 145)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'미소야', 146)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'미소야', 147)");

        db.execSQL("INSERT INTO sale VALUES(" +
                "'기린식당', 148)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'기린식당', 149)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'기린식당', 150)");


        db.execSQL("INSERT INTO sale VALUES(" +
                "'짬뽕타임', 151)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'본수원갈비', 152)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'시골집', 153)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'이모네손칼국수', 154)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'만고쿠', 155)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'에스팟', 156)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'미스사이공', 157)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'맥도날드', 158)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'엽기떡볶이', 159)");
        db.execSQL("INSERT INTO sale VALUES(" +
                "'아웃닭', 160)");


        ////////////////////////////////////////////////////

        db.execSQL("INSERT INTO menu VALUES(" +
                "1, '짜장면', 3000, 80, 50, 90, 0, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "2, '짬뽕', 5000, 50, 50, 40, 40, 30, 15)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "3, '볶음밥', 5000, 60, 40, 70, 30, 10, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "4, '짜장면', 6000, 50, 50, 70, 20, 50, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "5, '탕수육', 18000, 30, 20, 50, 0, 90, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "6, '짬뽕', 7000, 40, 50, 20, 90, 0, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "7, '깐풍기', 21000, 20, 60, 40, 70, 70, 6)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "8, '라조육', 28000, 10, 50, 50, 50, 50, 5)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "9, '탕수육', 16000, 40, 30, 30, 10, 90, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "10, '동파육', 25000, 20, 80, 40, 30, 70, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "11, '짜장면', 5000, 50, 30, 80, 20, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "12, '짬뽕', 6000, 50, 50, 10, 90, 20, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "13, '짜장면', 4000, 70, 50, 30, 80, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "14, '동파육', 26000, 20, 70, 40, 30, 80, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "15, '깐풍기', 25000, 10, 40, 30, 80, 80, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "16, '아주맛있는짜장면', 6000, 90, 10, 80, 30, 30, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "17, '아주맛있는짬뽕', 6000, 90, 20, 10, 70, 20, 70)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "18, '아주맛있는볶음밥', 6000, 90, 20, 40, 40, 40, 70)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "19, '짜장면', 5000, 50, 30, 80, 20, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "20, '볶음밥', 6000, 60, 40, 70, 30, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "21, '라조육', 24000, 20, 50, 40, 50, 40, 5)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "22, '짬뽕', 6000, 80, 20, 10, 70, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "23, '볶음밥', 6000, 80, 20, 40, 40, 40, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "24, '깐풍기', 25000, 10, 40, 30, 80, 80, 5)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "25, '짜장짜장', 5000, 50, 30, 80, 20, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "26, '짬뽕짬뽕', 6000, 80, 20, 10, 70, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "27, '볶음볶음밥', 6000, 80, 20, 40, 40, 40, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "28, '해물짬뽕', 6000, 60, 20, 20, 60, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "29, '삼선볶음밥', 6000, 60, 40, 40, 40, 40, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "30, '쟁반짜장', 6000, 70, 50, 30, 70, 20, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "31, '짜장면', 4000, 80, 30, 80, 20, 20, 50)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "32, '쟁반짜장면', 5000, 70, 40, 70, 30, 30, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "33, '해물짜장면', 6000, 60, 40, 70, 20, 30, 40)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "34, '중화짜장', 7000, 40, 80, 60, 20, 20, 5)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "35, '중화짬뽕', 7000, 40, 80, 10, 80, 10, 5)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "36, '중화볶음밥', 7000, 40, 80, 40, 30, 30, 5)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "37, '몽고식짜장면', 6000, 50, 70, 60, 20, 20, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "38, '몽고식짬뽕', 6000, 50, 70, 10, 80, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "39, '몽고식볶음밥', 6000, 50, 70, 30, 30, 30, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "40, '짜장면', 4000, 80, 30, 80, 20, 20, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "41, '짬뽕', 6000, 80, 20, 10, 70, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "42, '볶음밥', 6000, 80, 20, 40, 40, 40, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "43, '해물짬뽕', 6000, 80, 20, 10, 70, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "44, '굴짬뽕', 7000, 70, 20, 40, 80, 10, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "45, '삼선짬뽕', 7000, 70, 30, 10, 70, 20, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "46, '김치볶음밥', 3000, 80, 10, 10, 70, 60, 100)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "47, '부대찌게', 4000, 80, 30, 40, 70, 40, 110)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "48, '함박마요', 3000, 80, 30, 80, 0, 40, 90)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "49, '설렁탕', 4000, 70, 30, 40, 20, 10, 110)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "50, '닭강정', 3000, 80, 10, 20, 60, 90, 130)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "51, '제육볶음', 4000, 70, 20, 10, 70, 60, 80)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "52, '삼겹살', 5000, 70, 10, 40, 10, 30, 70)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "53, '떡만두국', 5000, 70, 20, 50, 10, 40, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "54, '해물순두부찌게', 5000, 70, 30, 10, 70, 20, 70)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "55, '쫄면', 3000, 80, 10, 10, 80, 40, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "56, '칼국수', 2000, 80, 20, 60, 20, 20, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "57, '뚝배기불고기', 4000, 60, 20, 40, 20, 60, 80)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "58, '치즈불닭', 4000, 70, 20, 30, 80, 20, 70)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "59, '제육덮밥', 4000, 60, 20, 10, 70, 60, 80)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "60, '메밀비빔면', 3000, 70, 10, 10, 80, 40, 60)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "61, '제육볶음', 7000, 30, 20, 10, 70, 60, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "62, '곱창순두부', 6000, 40, 30, 60, 70, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "63, '새우치즈알밥', 6000, 40, 20, 70, 10, 30, 40)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "64, '제육볶음', 6000, 40, 20, 10, 70, 60, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "65, '순두부찌게', 5000, 50, 30, 20, 70, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "66, '된장찌게', 5000, 50, 30, 40, 40, 20, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "67, '제육비빔밥', 4000, 70, 20, 10, 70, 60, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "68, '간장제육비빔밥', 4000, 70, 30, 40, 20, 60, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "69, '간장닭비빔밥', 4000, 70, 30, 40, 20, 60, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "70, '아주맛있는김치찌게', 5000, 60, 30, 20, 70, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "71, '아주맛있는된장찌게', 5000, 60, 30, 40, 40, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "72, '아주맛있는제육볶음', 5000, 60, 20, 10, 70, 60, 60)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "73, '제육볶음', 6000, 50, 20, 10, 70, 60, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "74, '순두부찌게', 6000, 50, 30, 20, 70, 20, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "75, '백반정식', 6000, 60, 20, 20, 70, 60, 70)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "76, '돼지김치찌게', 6000, 50, 30, 20, 70, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "77, '참치김치찌게', 6000, 50, 30, 20, 70, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "78, '부대김치찌게', 6000, 50, 30, 20, 70, 20, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "79, '간장찜닭', 8000, 20, 30, 40, 30, 60, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "80, '매콤찜닭', 8000, 20, 20, 10, 80, 20, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "81, '불찜닭', 9000, 20, 10, 0, 90, 10, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "82, '간장찜닭', 8000, 20, 30, 40, 30, 60, 60)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "83, '매콤찜닭', 8000, 20, 20, 10, 80, 20, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "84, '치즈찜닭', 9000, 20, 20, 40, 70, 20, 50)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "85, '부대찌게', 6000, 50, 30, 40, 60, 20, 50)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "86, '소고기부대찌게', 8000, 30, 30, 40, 60, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "87, '해물부대찌게', 7000, 40, 30, 40, 60, 20, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "88, '돼지김치찌게', 6000, 50, 30, 20, 70, 20, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "89, '해물김치찌게', 7000, 40, 30, 20, 70, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "90, '부대찌게', 6000, 50, 30, 40, 60, 20, 50)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "91, '치즈돈까스', 8000, 30, 20, 80, 10, 30, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "92, '돈까스알밥', 7000, 40, 10, 60, 30, 30, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "93, '돈까스', 7000, 30, 10, 70, 10, 20, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "94, '치즈고구마돈까스', 9000, 20, 10, 80, 10, 60, 50)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "95, '등심돈까스', 7000, 30, 10, 70, 10, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "96, '안심돈까스', 7000, 30, 10, 70, 10, 20, 40)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "97, '삼겹그릴덮밥', 5000, 60, 10, 60, 10, 60, 50)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "98, '매콤삼겹그릴덮밥', 5000, 60, 10, 60, 70, 60, 50)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "99, '퓨전부대찌게', 5000, 60, 30, 40, 60, 20, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "100, '스파게티', 7000, 30, 20, 40, 20, 30, 15)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "101, '까르보나라', 8000, 20, 40, 70, 10, 40, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "102, '그릴치킨', 7000, 30, 20, 40, 30, 60, 15)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "103, '돈까스', 7000, 40, 10, 70, 10, 20, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "104, '그릴치킨', 7000, 30, 20, 40, 30, 60, 50)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "105, '스파게티', 7000, 30, 20, 40, 20, 30, 60)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "106, '치킨부리또', 4000, 70, 50, 50, 50, 50, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "107, '비프부리또', 4000, 70, 50, 50, 50, 50, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "108, '부리또', 3000, 80, 50, 50, 50, 50, 40)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "109, '부리또', 3000, 80, 50, 50, 50, 50, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "110, '핫도그', 3000, 80, 20, 30, 40, 60, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "111, '프릿젤', 3000, 80, 10, 70, 0, 40, 40)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "112, '스테이크', 9000, 20, 20, 50, 10, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "113, '스파게티', 7000, 20, 20, 40, 20, 30, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "114, '폭립', 9000, 20, 20, 40, 30, 60, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "115, '폭립', 8000, 30, 20, 40, 30, 60, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "116, '스테이크', 9000, 20, 20, 50, 10, 20, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "117, '그릴삼겹', 9000, 20, 20, 40, 30, 60, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "118, '양념치킨', 7000, 60, 10, 40, 60, 60, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "119, '후라이드치킨', 7000, 60, 10, 60, 20, 30, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "120, '간장치킨', 7000, 60, 10, 50, 20, 50, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "121, '부타동', 6000, 60, 20, 60, 10, 60, 50)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "122, '미소라멘', 6000, 50, 40, 40, 40, 40, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "123, '돈코츠라멘', 7000, 40, 40, 50, 40, 40, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "124, '규동', 7000, 30, 20, 60, 10, 60, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "125, '사케동', 8000, 20, 40, 30, 10, 10, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "126, '차슈동', 6000, 50, 20, 60, 10, 60, 50)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "127, '초밥10피스', 8000, 20, 40, 30, 10, 10, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "128, '초밥15피스', 11000, 20, 40, 30, 10, 10, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "129, '일식정식', 14000, 10, 40, 30, 10, 10, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "130, '카레', 6000, 50, 50, 20, 50, 30, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "131, '돈까스카레', 6000, 50, 50, 40, 50, 40, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "132, '치킨카레', 6000, 40, 50, 40, 50, 40, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "133, '부타동', 7000, 50, 20, 60, 10, 60, 40)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "134, '차슈동', 7000, 50, 20, 60, 10, 60, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "135, '미소라멘', 6000, 50, 40, 40, 40, 40, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "136, '미소라멘', 7000, 30, 40, 40, 40, 40, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "137, '쇼우라멘', 7000, 30, 40, 40, 40, 40, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "138, '돈코츠라멘', 7000, 30, 40, 50, 40, 40, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "139, '쇼우라멘', 6000, 40, 40, 40, 40, 40, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "140, '차슈라멘', 6000, 40, 40, 40, 40, 40, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "141, '차슈동', 6000, 50, 20, 60, 10, 60, 30)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "142, '매콤차슈동', 6000, 40, 10, 60, 80, 60, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "143, '극라멘', 6000, 40, 20, 20, 90, 40, 30)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "144, '버닝타코야키', 6000, 30, 10, 60, 80, 70, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "145, '돈까스', 5000, 60, 10, 50, 10, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "146, '메밀소바', 5000, 60, 30, 10, 10, 30, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "147, '알밥', 5000, 60, 20, 30, 30, 30, 10)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "148, '돈까스', 5000, 60, 10, 50, 10, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "149, '카레돈까스', 6000, 50, 50, 40, 50, 40, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "150, '카레우동', 6000, 50, 50, 30, 50, 40, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "151, '짬뽕', 6000, 50, 30, 10, 70, 20, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "152, '소갈비', 15000, 10, 10, 30, 10, 60, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "153, '제육볶음', 6000, 40, 20, 10, 70, 40, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "154, '칼국수', 6000, 50, 20, 40, 40, 10, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "155, '연어덮밥', 8000, 30, 50, 40, 10, 30, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "156, '샤브샤브', 10000, 20, 30, 30, 20, 40, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "157, '쌀국수', 4000, 70, 70, 30, 30, 20, 10)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "158, '햄버거', 6000, 40, 10, 70, 10, 30, 20)");
        db.execSQL("INSERT INTO menu VALUES(" +
                "159, '떡볶이', 5000, 50, 30, 10, 90, 40, 20)");

        db.execSQL("INSERT INTO menu VALUES(" +
                "160, '간장치킨', 8000, 40, 10, 60, 20, 70, 20)");



        ////////////////////////////////////////////////////////////////

        db.execSQL("INSERT INTO user VALUES(" +
                "2, '김한이', 40, 50, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "3, '김한삼', 50, 40, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "4, '김한사', 50, 50, 40, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "5, '김한오', 50, 50, 50, 40, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "6, '김한육', 50, 50, 50, 50, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "7, '김한칠', 40, 40, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "8, '김한팔', 40, 50, 40, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "9, '김한구', 40, 50, 50, 40, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "10, '김한', 40, 50, 50, 50, 40)");

        db.execSQL("INSERT INTO user VALUES(" +
                "11, '이영일', 60, 50, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "12, '이영이', 50, 60, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "13, '이영삼', 50, 50, 60, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "14, '이영사', 50, 50, 50, 60, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "15, '이영오', 50, 50, 50, 50, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "16, '이영육', 60, 60, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "17, '이영칠', 60, 50, 60, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "18, '이영팔', 60, 50, 50, 60, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "19, '이영구', 60, 50, 50, 50, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "20, '이영', 40, 60, 50, 50, 50)");

        db.execSQL("INSERT INTO user VALUES(" +
                "21, '최재일', 40, 60, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "22, '최재이', 60, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "23, '최재삼', 40, 40, 60, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "24, '최재사', 40, 40, 40, 60, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "25, '최재오', 40, 40, 40, 40, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "26, '최재육', 60, 60, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "27, '최재칠', 60, 40, 60, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "28, '최재팔', 60, 40, 40, 60, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "29, '최재구', 60, 40, 40, 40, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "30, '최재민', 40, 40, 40, 40, 40)");

        db.execSQL("INSERT INTO user VALUES(" +
                "31, '임창일', 60, 70, 60, 70, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "32, '임창이', 60, 60, 30, 60, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "33, '임창삼', 60, 40, 60, 70, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "34, '임창사', 20, 60, 60, 40, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "35, '임창오', 70, 60, 30, 60, 70)");
        db.execSQL("INSERT INTO user VALUES(" +
                "36, '임창육', 70, 30, 60, 40, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "37, '임창칠', 20, 60, 50, 60, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "38, '임창팔', 60, 50, 60, 80, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "39, '임창구', 60, 20, 60, 40, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "40, '임창정', 60, 70, 60, 50, 60)");

        db.execSQL("INSERT INTO user VALUES(" +
                "41, '박정일', 40, 70, 30, 60, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "42, '박정이', 40, 30, 40, 30, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "43, '박정삼', 30, 40, 30, 40, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "44, '박정사', 70, 60, 40, 40, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "45, '박정오', 20, 60, 60, 40, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "46, '박정육', 50, 40, 30, 30, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "47, '박정칠', 70, 20, 20, 70, 20)");
        db.execSQL("INSERT INTO user VALUES(" +
                "48, '박정팔', 40, 50, 30, 30, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "49, '박정구', 30, 20, 10, 10, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "50, '박정우', 40, 70, 40, 30, 30)");

        db.execSQL("INSERT INTO user VALUES(" +
                "51, '송은일', 20, 20, 20, 20, 80)");
        db.execSQL("INSERT INTO user VALUES(" +
                "52, '송은이', 30, 30, 30, 30, 70)");
        db.execSQL("INSERT INTO user VALUES(" +
                "53, '송은삼', 40, 40, 40, 40, 70)");
        db.execSQL("INSERT INTO user VALUES(" +
                "54, '송은사', 20, 20, 20, 80, 20)");
        db.execSQL("INSERT INTO user VALUES(" +
                "55, '송은오', 30, 30, 30, 70, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "56, '송은육', 40, 40,40, 70, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "57, '송은칠', 20, 20, 80, 20, 20)");
        db.execSQL("INSERT INTO user VALUES(" +
                "58, '송은팔', 30, 30, 70, 30, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "59, '송은구', 40, 40, 70, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "60, '송은상', 20, 80, 20, 20, 20)");

        db.execSQL("INSERT INTO user VALUES(" +
                "61, '주하일', 30, 70, 30, 30, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "62, '주하이', 40, 70, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "63, '주하삼', 40, 60, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "64, '주하사', 80, 20, 20, 20, 20)");
        db.execSQL("INSERT INTO user VALUES(" +
                "65, '주하오', 80, 30, 30, 30, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "66, '주하육', 70, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "67, '주하칠', 70, 50, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "68, '주하팔', 70, 40, 40, 40, 70)");
        db.execSQL("INSERT INTO user VALUES(" +
                "69, '주하구', 70, 40, 40, 70, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "70, '주하은', 70, 40, 70, 40, 40)");

        db.execSQL("INSERT INTO user VALUES(" +
                "71, '최은일', 50, 50, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "72, '최은이', 80, 30, 40, 20, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "73, '최은삼', 70, 40, 40, 10, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "74, '최은사', 30, 30, 40, 40, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "75, '최은어', 20, 80, 70, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "76, '최은육', 30, 60, 60, 70, 70)");
        db.execSQL("INSERT INTO user VALUES(" +
                "77, '최은칠', 30, 20, 20, 60, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "78, '최은팔', 70, 40, 30, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "79, '최은구', 50, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "80, '최은', 60, 40, 40, 30, 40)");

        db.execSQL("INSERT INTO user VALUES(" +
                "81, '김영일', 70, 30, 30, 40, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "82, '김영이', 60, 30, 20, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "83, '김영삼', 70, 40, 70, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "84, '김영사', 40, 40, 30, 30, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "85, '김영오', 30, 30, 30, 30, 30)");
        db.execSQL("INSERT INTO user VALUES(" +
                "86, '김영육', 60, 60, 60, 60, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "87, '김영칠', 30, 30, 70, 60, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "88, '김영팔', 40, 40, 60, 60, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "89, '김영구', 50, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "90, '김영', 50, 30, 30, 40, 40)");

        db.execSQL("INSERT INTO user VALUES(" +
                "91, '심영', 50, 50, 50, 50, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "92, '김철수', 80, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "93, '최은희', 40, 40, 40, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "94, '임세진', 50, 60, 40, 50, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "95, '박철수', 40, 40, 70, 40, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "96, '김영희', 40, 70, 70, 70, 70)");
        db.execSQL("INSERT INTO user VALUES(" +
                "97, '박재민', 50, 40, 20, 50, 40)");
        db.execSQL("INSERT INTO user VALUES(" +
                "98, '최성우', 50, 40, 60, 30, 60)");
        db.execSQL("INSERT INTO user VALUES(" +
                "99, '김이민', 30, 40, 60, 40, 50)");
        db.execSQL("INSERT INTO user VALUES(" +
                "100, '강하영', 30, 40, 30, 40, 40)");

        ///////////////////////////////////////////////

        db.execSQL("INSERT INTO review VALUES(" +
                "1, 1, 20, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 11, 20, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 12, 70, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 24, 70, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 35, 20, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 42, 40, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 50, 50, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 51, 50, 10)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 52, 50, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 53, 50, 5)");

        db.execSQL("INSERT INTO review VALUES(" +
                "1, 71, 40, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 72, 40, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 73, 60, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 85, 70, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 104, 20, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 112, 70, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 132, 70, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 142, 30, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 143, 30, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "1, 144, 70, 1)");

        db.execSQL("INSERT INTO review VALUES(" +
                "5, 10, 40, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 20, 60, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 40, 60, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 60, 60, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 70, 60, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 90, 60, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 100, 20, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 110, 20, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 120, 80, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "5, 140, 80, 2)");

        db.execSQL("INSERT INTO review VALUES(" +
                "23, 10, 90, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 20, 90, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 30, 90, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 40, 90, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 50, 90, 10)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 60, 90, 10)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 70, 30, 13)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 80, 50, 6)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 90, 50, 6)");
        db.execSQL("INSERT INTO review VALUES(" +
                "23, 100, 50, 7)");

        db.execSQL("INSERT INTO review VALUES(" +
                "44, 110, 40, 7)");
        db.execSQL("INSERT INTO review VALUES(" +
                "44, 120, 40, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "44, 130, 40, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "44, 140, 40, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "44, 150, 40, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "56, 30, 40, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "56, 40, 50, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "56, 70, 50, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "56, 80, 50, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "56, 100, 50, 5)");

        db.execSQL("INSERT INTO review VALUES(" +
                "67, 24, 60, 7)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 36, 60, 7)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 55, 70, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 61, 70, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 82, 70, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 112, 60, 13)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 113, 60, 13)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 114, 70, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 115, 50, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "67, 122, 50, 3)");

        db.execSQL("INSERT INTO review VALUES(" +
                "72, 1, 50, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "72, 2, 40, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "72, 3, 50, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "80, 75, 50, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "80, 84, 40, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "80, 92, 60, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "80, 112, 60, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "80, 132, 70, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "95, 142, 70, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "95, 143, 30, 3)");

        db.execSQL("INSERT INTO review VALUES(" +
                "100, 5, 60, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "100, 6, 60, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "100, 33, 30, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "100, 45, 30, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "111, 54, 30, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "111, 72, 60, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "111, 82, 40, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "111, 92, 50, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "111, 112, 50, 7)");
        db.execSQL("INSERT INTO review VALUES(" +
                "111, 122, 50, 3)");

        db.execSQL("INSERT INTO review VALUES(" +
                "121, 143, 20, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "122, 7, 20, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "123, 17, 80, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "123, 46, 80, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "123, 55, 70, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "123, 78, 70, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "128, 78, 80, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "128, 133, 80, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "133, 134, 70, 2)");
        db.execSQL("INSERT INTO review VALUES(" +
                "133, 135, 80, 3)");

        db.execSQL("INSERT INTO review VALUES(" +
                "136, 9, 50, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "136, 39, 60, 5)");
        db.execSQL("INSERT INTO review VALUES(" +
                "141, 49, 40, 4)");
        db.execSQL("INSERT INTO review VALUES(" +
                "141, 59, 40, 1)");
        db.execSQL("INSERT INTO review VALUES(" +
                "144, 63, 70, 9)");
        db.execSQL("INSERT INTO review VALUES(" +
                "144, 83, 70, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "145, 113, 50, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "146, 123, 50, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "148, 136, 30, 3)");
        db.execSQL("INSERT INTO review VALUES(" +
                "149, 149, 60, 3)");

        db.close();
    }

    // 데이터베이스의 모든 칼럼을 날림
    // 제출시 삭제 예정인 코드
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
    // 제출시 삭제 예정인 코드
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
    // 제출시 삭제 예정인 코드
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
    // 제출시 삭제 예정인 코드
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
    // 제출 시 삭제 예정
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
    // 제출 시 삭제 예정
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

    // 유저의 정보를 토대로 추천 메뉴를 선정하는 모듈
    // 유저의 아이디는 1으로 가정하며, 3개의 메뉴를 추천하여 반환한다.
    public ArrayList<recommendMenuColumn> getRecommendTable()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<recommendMenuColumn> result = new ArrayList<recommendMenuColumn>();
        Cursor cursor = null;
        Cursor subCursor = null;

        int dist = 10;
        int tableSize = 0;
        final int minTableSize = 15;

        // 유저 정보 조회
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

        // 조회한 유저 정보를 토대로 유저의 입맛에 맞는 음식들을 찾는다.
        // 처음엔 strict한 기준으로 메뉴를 선정하지만, 추천 메뉴 수가 부족할 경우, 그 기준을 점점 넓히며 탐색한다.
        while (true)
        {
            // 현재 기준에 적합하는 메뉴들 선정
            cursor = null;
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

            // 추천할 메뉴의 가짓수가 충분한 경우, 각 메뉴의 정보를 column 클래스에 삽입
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

                    // 유저가 해당 메뉴를 몇번이나 먹었는지를 조회하는 질의
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

            // 추천메뉴 가짓수가 충분하지 않을 경우, 기준을 완화하여 다시 탐색
            dist += 5;
        }
        db.close();

        // 조건에 부합하는 메뉴 중, 3개를 랜덤으로 출력
        ArrayList<recommendMenuColumn> croppedResult = new ArrayList<recommendMenuColumn>();
        int[] randSeq = getRandomSequence(tableSize, 3);

        for(int i = 0; i < 3; i++)
        {
            croppedResult.add(result.get(randSeq[i]));
        }

        return croppedResult;
    }

    // 유저의 정보를 토대로 입맛이 비슷한 친구를 추천하는 모듈
    // 유저의 아이디는 1으로 가정하며, 7명의 유저를 추천하여 반환한다.
    public ArrayList<String> getFriendTable()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> result = new ArrayList<String>();
        Cursor cursor = null;

        int dist = 10;
        int tableSize = 0;
        final int minTableSize = 15;

        // 유저 정보 조회
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

        // 조회한 유저 정보를 토대로 유저와 입맛이 비슷한 유저들을 추천한다.
        // 처음엔 strict한 기준으로 유저를 선정하지만, 추천 유저 수가 부족할 경우, 그 기준을 점점 넓히며 탐색한다.
        while (true)
        {
            // 현재 기준에 적합하는 유저들 선정
            cursor = null;
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

            // 추천할 유저의 수가 충분한 경우, 유저의 이름을 array에 삽입
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

            // 추천유저수가 충분하지 않을 경우, 기준을 완화하여 다시 탐색
            dist += 5;
        }

        db.close();

        // 조건에 부합하는 유저 중, 7명을 랜덤으로 출력
        ArrayList<String> croppedResult = new ArrayList<String>();
        int[] randSeq = getRandomSequence(tableSize, 7);

        for(int i = 0; i < 7; i++)
        {
            croppedResult.add(result.get(randSeq[i]));
        }

        return croppedResult;
    }

    // 유저가 처음 앱을 실행한 후 설문조사를 행하면, 설문조사의 결과를 토대로 유저의 정보를 갱신하는 모듈
    public void insertResearchResult(ArrayList<researchColumn> input)
    {
        float count = 0;
        int sumQuantity = 0, sumSpice = 0, sumCreamy = 0, sumHot = 0, sumSweet = 0;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;

        // 설문조사의 결과를 유저 점수로 환산하기 위한 준비
        // 각 메뉴에 매긴 별점을 토대로 가중치를 둔 평균을 산출한다.
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

        // 설문 결과가 모두 0점이거나 없을 경우, default로 모두 50점을 삽입한다.
        if(count == 0)
        {
            db.execSQL("INSERT INTO user VALUES(" +
                    "1, '김한일', 50, 50, 50, 50, 50)");
        }

        // 그게 아닐 경우, 가중치 평균을 계산하여 삽입한다.
        else
        {
            db.execSQL("INSERT INTO user VALUES" +
                    "(1, '김한일', " +
                    (int)(sumQuantity / count) + ", " +
                    (int)(sumSpice / count) + ", " +
                    (int)(sumCreamy / count) + ", " +
                    (int)(sumHot / count) + ", " +
                    (int)(sumSweet / count) + " )");
        }
    }

    // 유저가 한식,중식,양식,일식 중 하나를 고를 경우, 해당되는 모든 음식점의 점포를 출력해준다.
    public ArrayList<sortResultColumn> getSortTable(String sort)
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<sortResultColumn> result = new ArrayList<sortResultColumn>();
        Cursor cursor = null;
        Cursor subCursor;

        // 해당 분류의 음식점들을 탐색하는 질의
        cursor = db.rawQuery("SELECT name, service FROM restaurant " +
                "WHERE sort = '" + sort + "'", null);

        while(cursor.moveToNext())
        {
            // 각 음식점의 상세 정보를 산출하여 출력하는 질의
            // 유저들이 매긴 점수를 기반으로 리뷰 평균 점수와 리뷰의 갯수를 추가로 탐색한다.
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

    // 난수를 생성하되, 그 값이 중복되지 않도록 하는 모듈
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