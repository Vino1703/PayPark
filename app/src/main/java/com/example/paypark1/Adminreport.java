package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adminreport extends AppCompatActivity {

    TextView GetBooks, DisplayBooks;
    private DBHelper dbHelper;
    ArrayList<String> ABookings = new ArrayList<String>();

    Integer rowid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminreport);


        dbHelper = new DBHelper(this);


        GetBooks = findViewById(R.id.adminbookingget);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(800);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        GetBooks.startAnimation(anim);


        GetBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dbHelper.getAllBook();

                GetBooks.setVisibility(View.GONE);

                if (cursor.getCount() == 0) {
                    Toast.makeText(Adminreport.this, "No Slots Registered...", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (cursor.moveToFirst()) {
                    do {
                        String SPLACE=cursor.getString(0);
                        String SNO=cursor.getString(1);
                        String SDATE=cursor.getString(2);
                        String STIME=cursor.getString(3);

                        Integer ROW = rowid+=1;
                        String ROWS = ROW.toString();
                        ABookings.add(""+ROWS+" - "+SPLACE+" - "+SNO+" - "+SDATE+" - "+STIME+"");

                        // Toast.makeText(MainActivity14.this,""+Bookings,Toast.LENGTH_SHORT).show();

                        //for (String details : Bookings)
                        //{
                        // DisplayBook.setText(details);
                        //}

                        DisplayBooks.setText("");

                        for (int i=0;i < ABookings.size();i++)
                        {
                            String Books = ABookings.get(i);
                            DisplayBooks.append("\n \n"+Books);

                            //Toast.makeText(MainActivity14.this,""+Bookings.get(i),Toast.LENGTH_SHORT).show();
                        }



                    } while (cursor.moveToNext());
                }

            }
        });

        //Toast.makeText(MainActivity14.this,""+Bookings,Toast.LENGTH_SHORT).show();

        DisplayBooks = findViewById(R.id.admindisbooks);




    }
}