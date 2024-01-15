package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    Button one,two,three,four,five,six,seven,eight,nine;
    TextView wlcome;
    String SlotName="";
    ProgressDialog progressDialog;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        Intent intent = getIntent();
        String email = intent.getStringExtra("usemail");
        String name = intent.getStringExtra("usname");
        String place = intent.getStringExtra("usplace");
        String phone = intent.getStringExtra("usphone");

        //Toast.makeText(this, ""+email, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+place, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+phone, Toast.LENGTH_SHORT).show();


        wlcome=findViewById(R.id.welcome);
        wlcome.append(""+name);

        one=findViewById(R.id.parkone);
        two=findViewById(R.id.parktwo);
        three=findViewById(R.id.parkthree);
        four=findViewById(R.id.parkfour);
        five=findViewById(R.id.parkfive);
        six=findViewById(R.id.parksix);
        seven=findViewById(R.id.parkseven);
        eight=findViewById(R.id.parkeight);
        nine=findViewById(R.id.parknine);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="SANGAM READYMATES";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="SRI MANJUNATHA SILKS";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="DUDES FASHION";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="MEENAKSHI THEATRE";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="AGS MALL";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="CKC THEATRE";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="BALAMURUGAN TVS SHOWROOM";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="AKSHAYA SUPERMARKET";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progressDialog=new ProgressDialog(MainActivity8.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.parkloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        SlotName="POONCHOLAI MEDICAL SHOP";
                        Intent i=new Intent(MainActivity8.this,MainActivity9.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        i.putExtra("slotname",SlotName);
                        startActivity(i);
                    }
                }.start();


            }
        });


    }
}