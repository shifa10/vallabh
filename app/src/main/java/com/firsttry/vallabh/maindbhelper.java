package com.firsttry.vallabh;
import  com.firsttry.vallabh.model.oredermodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class maindbhelper extends SQLiteOpenHelper {

   final static String DBNAME="mydatabase.db";
   final  static int DBVERSION=4;

    public maindbhelper(@Nullable Context context ) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

     sqLiteDatabase.execSQL(
             "create table oreders"+
                     "(id integer primary key autoincrement,"+
                     "name text,"+
                     "phone text,"+
                     "price int,"+
                     "manchurian int,"+
                     "quantity int,"+
                     "description text,"+
                     "foodname text)"


     );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
  sqLiteDatabase.execSQL("DROP table if exists oreders ");
  onCreate(sqLiteDatabase);
    }
    public  boolean insertorders(String name,String phone,int price,int manchurian,String foodname,String description,int quantity){
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();
        /*

        id=0
        name=1
        phone=2
        price=3
        image=4
        foodname=5
        desc=6
       quan=7


         */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("manchurian",manchurian);
        values.put("foodname",foodname);
        values.put("description",description);
        values.put("quantity",quantity);
       long id= database.insert("oreders",null,values);
       if(id <= 0){
           return  false;
       }else
       {
           return  true;
       }


    }
    public ArrayList<oredermodel>getoredrs()
    {
        ArrayList<oredermodel>orders=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("select id,foodname,manchurian,price from oreders",null);
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                oredermodel model = new oredermodel();
                model.setOredernmber(cursor.getInt(0) + "");
                model.setSolditem(cursor.getString(1));
                model.setOrederimage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) + "");
                orders.add(model);


        }

        }
        cursor.close();
        database.close();
        return  orders;
    }
    public Cursor getorderbyid(int id){

        //ArrayList<oredermodel>orders=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("select * from oreders where id="+id,null);


         if(cursor != null)
             cursor.moveToFirst();


        return cursor;

    }

    public  boolean updateorders(String name,String phone,int price,int manchurian,String foodname,String description,int quantity,int id){
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();
        /*

        id=0
        name=1
        phone=2
        price=3
        image=4
        foodname=5
        desc=6
       quan=7


         */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("manchurian",manchurian);
        values.put("foodname",foodname);
        values.put("description",description);
        values.put("quantity",quantity);
        long raw= database.update("oreders",values,"id="+1d,null);
        if(raw <= 0){
            return  false;
        }else
        {
            return  true;
        }


    }

    public int deleteoreder(String id){
        SQLiteDatabase database=this.getWritableDatabase();
        return  database.delete("oreders","id="+id,null);


    }

}
