package com.example.paypark1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    String UNAME="ADMIN";

    private Context context;

    public DBHelper(@Nullable Context context) {
        super(context, "paypark.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE \"parkinglogin\" (\n" +
                "\t\"email\"\tTEXT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\t\"phoneno\"\tTEXT,\n" +
                "\t\"place\"\tTEXT\n" +
                ");");

        DB.execSQL("CREATE TABLE \"parkingaccepted\" (\n" +
                "\t\"useremail\"\tTEXT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"userphone\"\tTEXT,\n" +
                "\t\"userplace\"\tTEXT,\n" +
                "\t\"userslotno\"\tTEXT,\n" +
                "\t\"userdate\"\tTEXT\n" +
                ");");

        DB.execSQL("CREATE TABLE \"parkingdeclined\" (\n" +
                "\t\"useremail\"\tTEXT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"userphone\"\tTEXT,\n" +
                "\t\"userplace\"\tTEXT,\n" +
                "\t\"userslotno\"\tTEXT,\n" +
                "\t\"userdate\"\tTEXT\n" +
                ");");

        DB.execSQL("CREATE TABLE \"parkingfeedback\" (\n" +
                "\t\"email\"\tTEXT,\n" +
                "\t\"subject\"\tTEXT,\n" +
                "\t\"description\"\tTEXT\n" +
                ");");

        DB.execSQL("CREATE TABLE \"currentbooking\" (\n" +
                "\t\"slotemail\"\tTEXT,\n" +
                "\t\"slotusername\"\tTEXT,\n" +
                "\t\"slotphoneno\"\tTEXT,\n" +
                "\t\"slotplace\"\tTEXT,\n" +
                "\t\"slotno\"\tTEXT,\n" +
                "\t\"slotdate\"\tTEXT,\n" +
                "\t\"slottime\"\tTEXT,\n" +
                "\t\"slotcardno\"\tTEXT,\n" +
                "\t\"slotcvv\"\tTEXT,\n" +
                "\t\"slotexpdate\"\tTEXT,\n" +
                "\t\"slotholdername\"\tTEXT\n" +
                ");");

        DB.execSQL("CREATE TABLE \"slotbooking\" (\n" +
                "\t\"slotemail\"\tTEXT,\n" +
                "\t\"slotusername\"\tTEXT,\n" +
                "\t\"slotphoneno\"\tTEXT,\n" +
                "\t\"slotplace\"\tTEXT,\n" +
                "\t\"slotno\"\tTEXT,\n" +
                "\t\"slotdate\"\tTEXT,\n" +
                "\t\"slottime\"\tTEXT,\n" +
                "\t\"slotcardno\"\tTEXT,\n" +
                "\t\"slotcvv\"\tTEXT,\n" +
                "\t\"slotexpdate\"\tTEXT,\n" +
                "\t\"slotholdername\"\tTEXT\n" +
                ");");

        DB.execSQL("CREATE TABLE \"userquery\" (\n" +
                "\t\"useremail\"\tTEXT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"userphoneno\"\tTEXT,\n" +
                "\t\"userquery\"\tTEXT\n" +
                ");");

        DB.execSQL("INSERT INTO parkinglogin (email,username,password,phoneno,place) VALUES (\n" +
                "                'RAAJANTHINESH8@GMAIL.COM',\n" +
                "                'ADMIN',\n" +
                "                'admin0811',\n" +
                "                '6379300216',\n" +
                "                'TIRUPATTUR'\n" +
                "        );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        DB.execSQL("drop Table if exists parkinglogin");
        DB.execSQL("drop Table if exists parkingfeedback");
        DB.execSQL("drop Table if exists currentbooking");
        DB.execSQL("drop Table if exists parkingaccepted");
        DB.execSQL("drop Table if exists parkingdeclined");
        DB.execSQL("drop Table if exists slotbooking");
        DB.execSQL("drop Table if exists userquery");


    }

    public void addnewuser(String Email, String Username, String Password,String Phoneno,String Place) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email", Email);
        values.put("username", Username);
        values.put("password", Password);
        values.put("phoneno", Phoneno);
        values.put("place", Place);
        db.insert("parkinglogin", null, values);
        db.close();
    }

    public boolean checkuser(String Email)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM parkinglogin WHERE email = ?", new String[] {Email});
        if (c.moveToFirst()){
            do{
                if(c.getCount() > 0 )
                {
                    Toast.makeText(context, "Email Id Already Exists...", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }while(c.moveToNext());
        }
        c.close();
        return true;


    }


    public void addfeedback(String Email, String Subject, String Description) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email", Email);
        values.put("subject", Subject);
        values.put("description", Description);
        db.insert("parkingfeedback", null, values);
        db.close();
    }



    public Cursor getuserlogincrct(String Username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM parkinglogin WHERE username = '"+Username+"'", null);
        UNAME=Username;

        return cursor;


    }



    public void addbookings(String Bookemail, String Bookname, String Bookphone, String Bookplace, String Bookslotno, String Bookdate, String Booktime, String Bookcardno, String Bookcvno, String Bookexp, String Bookholdername ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("slotemail", Bookemail);
        values.put("slotusername", Bookname);
        values.put("slotphoneno", Bookphone);
        values.put("slotplace", Bookplace);
        values.put("slotno", Bookslotno);
        values.put("slotdate", Bookdate);
        values.put("slottime", Booktime);
        values.put("slotcardno", Bookcardno);
        values.put("slotcvv", Bookcvno);
        values.put("slotexpdate", Bookexp);
        values.put("slotholdername", Bookholdername);

        db.insert("currentbooking", null, values);
        db.close();
    }

    public void slotbookings(String Bookemail, String Bookname, String Bookphone, String Bookplace, String Bookslotno, String Bookdate, String Booktime, String Bookcardno, String Bookcvno, String Bookexp, String Bookholdername ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("slotemail", Bookemail);
        values.put("slotusername", Bookname);
        values.put("slotphoneno", Bookphone);
        values.put("slotplace", Bookplace);
        values.put("slotno", Bookslotno);
        values.put("slotdate", Bookdate);
        values.put("slottime", Booktime);
        values.put("slotcardno", Bookcardno);
        values.put("slotcvv", Bookcvno);
        values.put("slotexpdate", Bookexp);
        values.put("slotholdername", Bookholdername);

        db.insert("slotbooking", null, values);
        db.close();
    }

    public Cursor getCurrentBook(String SLOTNUM)
    {

        SQLiteDatabase DB = this.getWritableDatabase();
        String query="SELECT slotemail, slotusername , slotphoneno , slotplace, slotno, slotdate FROM currentbooking WHERE slotno = '" + SLOTNUM + "'";
        Cursor cursor = DB.rawQuery(query, null);

       return cursor;
    }

    public Cursor getSlotBook()
    {



        SQLiteDatabase DB = this.getWritableDatabase();
        String query="SELECT slotplace,slotno FROM currentbooking";
        Cursor cursor = DB.rawQuery(query, null);


        return cursor;
    }

    public void acceptBook(String Bookemail, String Bookname, String Bookphone, String Bookplace, String Bookslotno, String Bookdate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("useremail", Bookemail);
        values.put("username", Bookname);
        values.put("userphone", Bookphone);
        values.put("userplace", Bookplace);
        values.put("userslotno", Bookslotno);
        values.put("userdate", Bookdate);

        db.insert("parkingaccepted", null, values);
        db.close();
    }

    public void declineBook(String Bookemail, String Bookname, String Bookphone, String Bookplace, String Bookslotno, String Bookdate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("useremail", Bookemail);
        values.put("username", Bookname);
        values.put("userphone", Bookphone);
        values.put("userplace", Bookplace);
        values.put("userslotno", Bookslotno);
        values.put("userdate", Bookdate);

        db.insert("parkingdeclined", null, values);
        db.close();
    }


    public Cursor getuserbookings(String Email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT slotplace, slotno,slotdate,slottime FROM currentbooking  WHERE slotemail = '"+Email+"'", null);

        return cursor;


    }

    public Cursor getAllBook() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT slotplace, slotno,slotdate,slottime FROM currentbooking",null);

        return cursor;


    }


    public void addQuery(String Email, String Username, String Phone,String Query) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("useremail",Email);
        values.put("username",Username);
        values.put("userphoneno",Phone);
        values.put("userquery",Query);


        db.insert("userquery", null, values);
        db.close();
    }
}


