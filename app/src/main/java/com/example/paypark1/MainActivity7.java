package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    Button near,pincode;
    ProgressDialog progressDialog;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        Intent intent = getIntent();
        String email = intent.getStringExtra("usemail");
        String name = intent.getStringExtra("usname");
        String place = intent.getStringExtra("usplace");
        String phone = intent.getStringExtra("usphone");

        near=findViewById(R.id.nearplot);
        pincode=findViewById(R.id.pincode);

        near.setBackgroundColor(0xFFf8faa5);
        pincode.setBackgroundColor(0xFFf786f5);

        //Toast.makeText(this, ""+email, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+place, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+phone, Toast.LENGTH_SHORT).show();

        near.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(MainActivity7.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.searchloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(2000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        Intent i=new Intent(MainActivity7.this,MainActivity8.class);
                        i.putExtra("usemail",email);
                        i.putExtra("usname",name);
                        i.putExtra("usphone",phone);
                        i.putExtra("usplace",place);
                        startActivity(i);

                    }
                }.start();


            }
        });
        pincode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(MainActivity7.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.searchloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(2000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();

                        Intent i=new Intent(MainActivity7.this,MainActivity12.class);
                        startActivity(i);
                    }
                }.start();



            }
        });




    }


}