package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView alreadyuser;
    Button signin;
    EditText email,username,password,cpassword,phoneno,place;
    private DBHelper dbHelper;
    ProgressDialog progressDialog;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        email=findViewById(R.id.email);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        phoneno=findViewById(R.id.phoneno);
        place=findViewById(R.id.place);
        alreadyuser=findViewById(R.id.alreadyuser);
        signin=findViewById(R.id.signbtn);

        signin.setBackgroundColor(0xFFf5ee8c);

        dbHelper = new DBHelper(MainActivity3.this);


        alreadyuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity3.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.defload);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(2000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        onBackpressed1();
                    }
                }.start();

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString();
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                String Cpassword = cpassword.getText().toString();
                String Phoneno = phoneno.getText().toString();
                String Place = place.getText().toString();

                if ((!Email.equals("") && Email != null) && (!Username.equals("") && Username !=null) && (!Password.equals("") && Password !=null) && (!Cpassword.equals("") && Cpassword !=null) && (!Phoneno.equals("") && Phoneno !=null) && (!Place.equals("") && Place !=null)){
                    validatesignin(Email,Username,Password,Cpassword,Phoneno,Place);

                } else {
                    Toast.makeText(MainActivity3.this, "Please Enter All The Data..!", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    private boolean validatepassword(String Password)
    {
        if(Password.length() < 8){
            return false;

        }
        return true;
    }

    private void validatesignin(String Email,String Username,String Password,String Cpassword,String Phoneno,String Place){

        if(Password.equals(Cpassword))
        {
                if(validatepassword(Password))
                {
                    if(dbHelper.checkuser(Email)){
                    dbHelper.addnewuser(Email, Username, Password, Phoneno, Place);
                    progressDialog=new ProgressDialog(MainActivity3.this);
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.registersuccess);

                    progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                    new CountDownTimer(2000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }
                        @Override
                        public void onFinish() {
                            onBackpressed();
                        }
                    }.start();

                }}
                else {
                    Toast.makeText(MainActivity3.this, "Password must be of 8 characters..!", Toast.LENGTH_SHORT).show();
                }

        }
        else
        {
            Toast.makeText(MainActivity3.this, "Password doesn't matches..!", Toast.LENGTH_SHORT).show();
        }

    }
    public void onBackpressed()
    {
        progressDialog.dismiss();
        Toast.makeText(MainActivity3.this, "Successfully registered.", Toast.LENGTH_SHORT).show();
        email.setText("");
        username.setText("");
        password.setText("");
        cpassword.setText("");

        Intent i = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(i);
    }
    public void onBackpressed1()
    {
        progressDialog.dismiss();
        Intent i = new Intent(MainActivity3.this, MainActivity2.class);
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