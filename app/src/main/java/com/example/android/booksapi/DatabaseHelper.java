package com.example.android.booksapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 7/28/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    String name,surname,mobile,username,password,confirm,blood_group,diseases,medications,state,city,pincode;
    public static final String DATABASE_NAME="Profile.db";
    public static final String TABLE_NAME="PROFILE";
    public static final String TABLE_NAME1="BLOOD_DETAILS";
    public static final String COL1="id";
    public static final String COL2="name";
    public static final String COL4="mobile";
    public static final String COL5="username";
    public static final String COL6="password";
    public static final String COL7="confirm_password";
    public static final String COL8="blood_group";
    public static final String COL9="diseases";
    public static final String COL10="medications";
    public static final String COL11="state";
    public static final String COL12="city";
    public static final String COL13="pincode";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COL1 + " integer primary key autoincrement, " + COL2 +" varchar, "
                + COL4 + " long, " + COL5 + " varchar unique, "
                + COL6 + " varchar, " + COL7 + " varchar, "  + COL8 + " varchar, "+ COL9
                + " varchar, " + COL10 + " varchar, " + COL11 + " varchar, "  + COL12 + " varchar, " +  COL13 + " varchar "+ ")" + ";" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdataprofile(String name, String mobile, String username, String password,
                                     String confirm_password,String blood_group,String diseases,String medications,String state,String city
                                        ,String pincode){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL4,mobile);
        contentValues.put(COL5,username);
        contentValues.put(COL6,password);
        contentValues.put(COL7,confirm_password);
        contentValues.put(COL8,blood_group);
        contentValues.put(COL9,diseases);
        contentValues.put(COL10,medications);
        contentValues.put(COL11,state);
        contentValues.put(COL12,city);
        contentValues.put(COL13,pincode);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return  false;
        }
        return  true;
    }
/*
    public Cursor getname(String username){
        SQLiteDatabase db=getWritableDatabase();
        Cursor name= (db.rawQuery("select " + COL2 +" from " + TABLE_NAME + " where " + COL5 + " = " + "\"" +  username + "\"" + ";",null));
        return  name;
    }

    public Cursor getsurname(String username){
        SQLiteDatabase db=getWritableDatabase();
        Cursor surname= (db.rawQuery("select " + COL3 +" from " + TABLE_NAME + " where " + COL5 + " = " + "\"" +  username + "\"" + ";",null));
        return  surname;
    }

    public Cursor getmobile(String username){
        SQLiteDatabase db=getWritableDatabase();
        Cursor mobile= (db.rawQuery("select " + COL4 +" from " + TABLE_NAME + " where " + COL5 + " = " + "\"" +  username + "\"" + ";",null));
        return  mobile;
    }*/



    public void updatedata(String username,String blood_group,String diseases,String medications,String state,String city,String pincode){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("update "+ TABLE_NAME + " set " + COL8 + " = " + "\"" + blood_group + "\"" + " , " + COL9 +
                " = " + "\"" + diseases + "\"" + " , " +
                COL10 + " = " + "\"" +  medications + "\"" + " , " +  COL11 + " = " + "\"" + state + "\"" + " , " + COL12 + " = " + "\""
                + city + "\"" +  " , " +  COL13 + " = " + "\"" + pincode + "\"" +  " where " + COL5 + " = " + "\"" +  username + "\"" + ";");
    }

    public void updatedatablood(String username,String blood_group){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("update "+ TABLE_NAME + " set " + COL8 + " = " + "\'" + blood_group + "\'" + " where "
                + COL5 + " = " + "\'" +  username + "\'" + ";");
    }

    public Cursor getAllData(String username){
        SQLiteDatabase db=getWritableDatabase();
        Cursor res=db.rawQuery("select * from " + TABLE_NAME +  " where " + COL5 + " = " + "\"" +  username + "\"" + ";",null);
        return res;
    }

    public  String getname(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
             name = res.getString(1);
        }
        return  name;
    }


    public  String getmobile(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            mobile = res.getString(3);
        }
        return  mobile;
    }

    public  String getpassword(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            password = res.getString(5);
        }
        return  password;
    }

    public  String getConfirm(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            confirm = res.getString(6);
        }
        return  confirm;
    }

    public  String getblood_group(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            blood_group = res.getString(7);
        }
        return  blood_group;
    }
    public  String getDiseases(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            diseases = res.getString(8);
        }
        return  diseases;
    }
    public  String getMedications(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            medications = res.getString(9);
        }
        return  medications;
    }
    public  String getstate(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            state = res.getString(10);
        }
        return  state;
    }

    public  String getCity(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            city = res.getString(11);
        }
        return  city;
    }

    public  String getPincode(String username){
        Cursor res=getAllData(username);
        while(res.moveToNext()) {
            pincode = res.getString(12);
        }
        return  pincode;
    }


    public boolean usernamevalid(String username){
        SQLiteDatabase db=getWritableDatabase();
        Cursor res=db.rawQuery("select " + COL5 + " from " + TABLE_NAME + ";",null);
        while(res.moveToNext()) {
            if (username.equals(res.getString(0))) {
                return true;
            }
        }
        return false;
    }
}
