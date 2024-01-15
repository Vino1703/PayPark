package com.example.paypark1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {


    Button userdetails,newbook,viewbook,logout,feedback;
    ProgressDialog progressDialog;
    private long pressedTime;

    String usemail="";
    String usname="";
    String uspass="";
    String usphone="";
    String usplace="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        newbook=findViewById(R.id.newbook);
        viewbook=findViewById(R.id.viewbook);
        feedback=findViewById(R.id.feedback);
        logout=findViewById(R.id.logout);


        newbook.setBackgroundColor(0xFFf786f5);
        viewbook.setBackgroundColor(0xFFf8faa5);
        feedback.setBackgroundColor(0xFF9afa98);
        logout.setBackgroundColor(0xFFfa9ba4);

        Intent intent = getIntent();
        String email = intent.getStringExtra("usemail");
        usemail=email;
        String name = intent.getStringExtra("usname");
        usname=name;
        String place = intent.getStringExtra("usplace");
        usplace=place;
        String phone = intent.getStringExtra("usphone");
        usphone=phone;




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity4.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.loadinglogin);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        onBackpressed();
                    }
                }.start();

            }

        });

        newbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity4.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.searchloading);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        onBackpressed3();
                    }
                }.start();

            }

        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(MainActivity4.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.feeload);

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(3000,1000) {
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


        viewbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog=new ProgressDialog(MainActivity4.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.searchloading);



                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        onBackpressed4();
                    }
                }.start();

            }

        });


    }
    public void onBackpressed()
    {
        progressDialog.dismiss();
        Toast.makeText(MainActivity4.this, "Logout Successfull...", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity4.this, MainActivity2.class);
        startActivity(i);
    }
    public void onBackpressed1()
    {
        progressDialog.dismiss();
        Intent i = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(i);
    }
    public void onBackpressed2()
    {
        progressDialog.dismiss();
        Intent i = new Intent(MainActivity4.this, MainActivity6.class);
        startActivity(i);
    }
    public void passusdatatomydet(String usemail,String usname,String usphone,String usplace)
    {
        Intent i = new Intent(MainActivity4.this, MainActivity6.class);
        i.putExtra("usemail",usemail);
        i.putExtra("usname",usname);
        i.putExtra("uspass",uspass);
        i.putExtra("usphone",usphone);
        i.putExtra("usplace",usplace);
        startActivity(i);
    }

    public void onBackpressed3()
    {
        progressDialog.dismiss();
        Intent i = new Intent(MainActivity4.this, MainActivity7.class);
        i.putExtra("usemail",usemail);
        i.putExtra("usname",usname);
        i.putExtra("uspass",uspass);
        i.putExtra("usphone",usphone);
        i.putExtra("usplace",usplace);
        startActivity(i);
    }
    public void onBackpressed4()
    {
        progressDialog.dismiss();
        Intent i = new Intent(MainActivity4.this,MainActivity14.class);
        i.putExtra("usemail",usemail);
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

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {


            case R.id.about:


                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity4.this);
                final View customLayout = getLayoutInflater().inflate(R.layout.activity_about, null);
                dialog.setView(customLayout);

                AlertDialog alertDialog1=dialog.create();
                alertDialog1.show();


                return (true);

            case R.id.contact:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity4.this);
                alertDialog.setTitle("ENTER YOUR QUERY?");
                final EditText input = new EditText(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setIcon(R.drawable.mmessage);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {

                                Intent email = new Intent(Intent.ACTION_SEND);
                                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ usemail});
                                email.putExtra(Intent.EXTRA_SUBJECT, "Query regarding PAY PARK");
                                email.putExtra(Intent.EXTRA_TEXT, "I am Mr/Mrs . "+usname+" from "+usplace+" . My query is of following : "+input.getText());

                                email.setType("message/rfc822");

                                startActivity(Intent.createChooser(email, "Choose an Email client :"));


                                Toast.makeText(getApplicationContext(),"Query Requested Successfully...", Toast.LENGTH_SHORT).show();

                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });

                alertDialog.show();

                return (true);

            case R.id.lgoutt:

                Intent intent = new Intent(MainActivity4.this,MainActivity.class);
                startActivity(intent);

                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }



}

