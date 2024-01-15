package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView newuser;
    EditText loginid,loginpass;
    Button login;
    private DBHelper dbHelper;
    ProgressDialog progressDialog;
    private long pressedTime;

    NotificationManager mNotificationManager;

     String usemail="";
     String usname="";
     String uspass="";
     String usphone="";
     String usplace="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        newuser=findViewById(R.id.newuser);
        loginid=findViewById(R.id.loginid);
        loginpass=findViewById(R.id.loginpass);
        login=findViewById(R.id.loginbtn);
        dbHelper = new DBHelper(MainActivity2.this);


        login.setBackgroundColor(0xFFf5ee8c);




        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(MainActivity2.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.logloading);

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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = loginid.getText().toString();
                String Password = loginpass.getText().toString();

                if ((!Username.equals("") && Username !=null) && (!Password.equals("") && Password !=null))
                {
                    String uname="",upass="";

                    Cursor cursor=dbHelper.getuserlogincrct(loginid.getText().toString());
                    if (cursor.getCount() == 0) {
                        Toast.makeText(MainActivity2.this, "Username OR Password Incorrect...", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (cursor.moveToFirst()) {
                        do {
                            String email=cursor.getString(0);
                            String username = cursor.getString(1);
                            String password = cursor.getString(2);
                            String phone=cursor.getString(3);
                            String plac=cursor.getString(4);

                             uname=username;
                             upass=password;

                             usemail=email;
                             usname=username;
                             uspass=password;
                             usphone=phone;
                             usplace=plac;

                            //Toast.makeText(MainActivity2.this, ""+uname, Toast.LENGTH_SHORT).show();
                           //Toast.makeText(MainActivity2.this, ""+upass, Toast.LENGTH_SHORT).show();
                            //Toast.makeText(MainActivity2.this, ""+usemail, Toast.LENGTH_SHORT).show();
                           // Toast.makeText(MainActivity2.this, ""+usname, Toast.LENGTH_SHORT).show();
                           // Toast.makeText(MainActivity2.this, ""+uspass, Toast.LENGTH_SHORT).show();
                           // Toast.makeText(MainActivity2.this, ""+usphone, Toast.LENGTH_SHORT).show();
                           // Toast.makeText(MainActivity2.this, ""+usplace, Toast.LENGTH_SHORT).show();
                        } while (cursor.moveToNext());
                    }

                    if((loginid.getText().toString().equals("ADMIN")) && (loginpass.getText().toString().equals("admin0811")))
                    {
                        loginid.setText("");
                        loginpass.setText("");

                        calladminpage();
                    }
                    else if(Username.equals(uname) && (Password.equals(upass)))
                    {

                        progressDialog=new ProgressDialog(MainActivity2.this);
                        progressDialog.show();
                        progressDialog.setContentView(R.layout.helloloading);

                        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                        new CountDownTimer(5000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }
                            @Override
                            public void onFinish() {
                                loginid.setText("");
                                loginpass.setText("");
                                onBackpressed();
                                passusdata(usemail,usname,uspass,usphone,usplace);
                            }
                        }.start();

                    }
                    else
                    {
                        Toast.makeText(MainActivity2.this, "Invalid Login Details...", Toast.LENGTH_SHORT).show();
                    }



                }
                else {
                    Toast.makeText(MainActivity2.this, "Please Enter All The Data..!", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
    public void onBackpressed()
    {
        progressDialog.dismiss();
        Toast.makeText(MainActivity2.this, "Login Successfull...", Toast.LENGTH_SHORT).show();

    }
    public void passusdata(String usemail,String usname,String uspass,String usphone,String usplace)
    {
        Intent i = new Intent(MainActivity2.this, MainActivity4.class);
        i.putExtra("usemail",usemail);
        i.putExtra("usname",usname);
        i.putExtra("uspass",uspass);
        i.putExtra("usphone",usphone);
        i.putExtra("usplace",usplace);
        startActivity(i);

        addNotification();
    }

    public void onBackpressed1()
    {
        loginid.setText("");
        loginpass.setText("");
        progressDialog.dismiss();
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
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

    public void calladminpage()
    {
        Intent i = new Intent(MainActivity2.this, Adminhome.class);

        startActivity(i);


        addNotification();
    }


    public void addNotification()
    {



       NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getApplicationContext(), "notify_001");
        Intent ii = new Intent(getApplicationContext(), About.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, ii, 0);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle("Welcome ");
        bigText.setSummaryText("Click here to view");

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentText("For exiting parking places...");
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);

        mNotificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

// === Removed some obsoletes
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        mNotificationManager.notify(0, mBuilder.build());


    }


}


