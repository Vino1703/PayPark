package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    EditText email,subject,desc;
    Button feesubbtn;
    private DBHelper dbHelper;
    ProgressDialog progressDialog;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        email=findViewById(R.id.feeemail);
        subject=findViewById(R.id.feesubject);
        desc=findViewById(R.id.feedes);
        feesubbtn=findViewById(R.id.feesubmitbtn);
        dbHelper = new DBHelper(MainActivity5.this);

        feesubbtn.setBackgroundColor(0xFFf522ee);

        feesubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Email = email.getText().toString();
                String Subject = subject.getText().toString();
                String Description = desc.getText().toString();
                if ((!Email.equals("") && Email != null) && (!Subject.equals("") && Subject !=null) && (!Description.equals("") && Description !=null) ){
                    validatefeedback(Email,Subject,Description);

                } else {
                    Toast.makeText(MainActivity5.this, "Please Enter All The Data..!", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private void validatefeedback(String Email,String Subject,String Description){
        dbHelper.addfeedback(Email, Subject, Description);
        progressDialog=new ProgressDialog(MainActivity5.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.feedloading);

        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        new CountDownTimer(4500,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                onBackpressed();
            }
        }.start();

    }

    public void onBackpressed()
    {
        progressDialog.dismiss();
        Toast.makeText(MainActivity5.this, "Feedback Added...", Toast.LENGTH_SHORT).show();
        email.setText("");
        subject.setText("");
        desc.setText("");

        Intent i = new Intent(MainActivity5.this, MainActivity4.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}