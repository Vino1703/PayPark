package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity10 extends AppCompatActivity {

    EditText slotdate,slottime;
    Button booksubbtn;
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    String date1 = sdf1.format(new Date());
    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
    String date2 = sdf2.format(new Date());
    Spinner slotdur;

    String SlotDate="",SlotTime="",SlotDur="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Intent intent = getIntent();
        String email = intent.getStringExtra("usemail");
        String name = intent.getStringExtra("usname");
        String place = intent.getStringExtra("usplace");
        String phone = intent.getStringExtra("usphone");
        String slotname = intent.getStringExtra("slotname");
        String slotno = intent.getStringExtra("slotno");

        //Toast.makeText(this, ""+email, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+place, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+phone, Toast.LENGTH_SHORT).show();

        booksubbtn = findViewById(R.id.booksubbbtn);
        slotdate=findViewById(R.id.slotdate);
        slottime=findViewById(R.id.slottime);
        slotdur=findViewById(R.id.slotdur);
        String[] items = new String[]{"1 hrs", "2 hrs", "3 hrs","5 hrs", "7 hrs", "9 hrs"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        slotdur.setAdapter(adapter);


        slotdate.setText(date1);
        slottime.setText(date2);

        booksubbtn.setBackgroundColor(0xFFffb31a);

        booksubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SlotDate=slotdate.getText().toString();
                SlotTime=slottime.getText().toString();

                Intent i=new Intent(MainActivity10.this,MainActivity11.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",slotno);
                i.putExtra("slotdate",SlotDate);
                i.putExtra("slottime",SlotTime);
                startActivity(i);
            }
        });



    }
}