package com.example.paypark1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Adminhome extends AppCompatActivity {

    Button cbook,apro,arep,alog;

    Button SS;
    private DBHelper dbHelper;

    private static final int REQUEST_EXTERNAL_STORAGe = 1;
    private static String[] permissionstorage = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);



        dbHelper = new DBHelper(this);

        cbook=findViewById(R.id.admincurrentbookings);
        arep=findViewById(R.id.adminreport);
        alog=findViewById(R.id.adminlogout);


        cbook.setBackgroundColor(0xFF71f3f5);
        arep.setBackgroundColor(0xFFf8faa5);
        alog.setBackgroundColor(0xFFf5c27a);

        alog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Adminhome.this,MainActivity2.class);
                startActivity(i);
            }
        });



        cbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Adminhome.this,MainActivity13.class);
                startActivity(i);
            }
        });


        arep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Cursor res = dbHelper.getAllBook();
                        if(res.getCount() == 0){
                            Toast.makeText(Adminhome.this, "No Details Exists", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){

                            buffer.append("SLOT . No                 : "+res.getString(1)+"\n");
                            buffer.append("PLACE          : "+res.getString(0)+"\n");
                            buffer.append("DATE     : "+res.getString(2)+"\n");
                            buffer.append("TIME  : "+res.getString(3)+"\n");
                            buffer.append("_________________________________________ "+"\n\n");
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(Adminhome.this);
                        builder.setCancelable(true);
                        builder.setTitle("Booking details");
                        builder.setMessage(buffer.toString());
                        builder.show();

                    }
                });



    }
}