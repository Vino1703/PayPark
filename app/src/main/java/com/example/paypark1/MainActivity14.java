package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity14 extends AppCompatActivity {

    TextView GetBook, DisplayBook;
    String EMAIL="";
    private DBHelper dbHelper;
    ArrayList<String> Bookings = new ArrayList<String>();

    Integer rowid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);


        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        EMAIL = intent.getStringExtra("usemail");


        GetBook = findViewById(R.id.bookingget);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(800);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        GetBook.startAnimation(anim);


        GetBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dbHelper.getuserbookings(EMAIL);

                GetBook.setVisibility(View.GONE);

                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity14.this, "No Slots Registered...", Toast.LENGTH_SHORT).show();
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
                        Bookings.add(""+ROWS+" - "+SPLACE+" - "+SNO+" - "+SDATE+" - "+STIME+"");

                       // Toast.makeText(MainActivity14.this,""+Bookings,Toast.LENGTH_SHORT).show();

                        //for (String details : Bookings)
                        //{
                           // DisplayBook.setText(details);
                        //}

                        DisplayBook.setText("");

                        for (int i=0;i < Bookings.size();i++)
                        {
                            String Books = Bookings.get(i);
                            DisplayBook.append("\n \n"+Books);

                            //Toast.makeText(MainActivity14.this,""+Bookings.get(i),Toast.LENGTH_SHORT).show();
                        }



                    } while (cursor.moveToNext());
                }

            }
        });

        //Toast.makeText(MainActivity14.this,""+Bookings,Toast.LENGTH_SHORT).show();

        DisplayBook = findViewById(R.id.disbooks);




    }
}