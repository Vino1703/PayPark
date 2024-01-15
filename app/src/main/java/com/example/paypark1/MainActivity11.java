package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity11 extends AppCompatActivity {

    EditText cardno,cvvno,expdat,holdername;
    Button paybookbtn;
    private DBHelper dbHelper;


    String ADMINNUM = "6379300216";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        dbHelper=new DBHelper(this);

        Intent intent = getIntent();
        String email = intent.getStringExtra("usemail");
        String name = intent.getStringExtra("usname");
        String place = intent.getStringExtra("usplace");
        String phone = intent.getStringExtra("usphone");
        String slotname = intent.getStringExtra("slotname");
        String slotno = intent.getStringExtra("slotno");
        String slotdate = intent.getStringExtra("slotdate");
        String slottime = intent.getStringExtra("slottime");


        //Toast.makeText(this, ""+email, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+place, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+phone, Toast.LENGTH_SHORT).show();



        cardno=findViewById(R.id.cardno);
        cvvno=findViewById(R.id.cvv);
        expdat=findViewById(R.id.expdate);
        holdername=findViewById(R.id.holdername);
        paybookbtn=findViewById(R.id.paymentbookbtn);

        paybookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if((!cardno.getText().toString().equals("") && cardno.getText().toString() != null) && (!cvvno.getText().toString().equals("") && cvvno.getText().toString() != null) && (!expdat.getText().toString().equals("") && expdat.getText().toString() != null) && (!holdername.getText().toString().equals("") && holdername.getText().toString() != null))
               {


                   String slotcardno = cardno.getText().toString();
                   String slotcvvno = cvvno.getText().toString();
                   String slotexpdate = expdat.getText().toString();
                   String slotholdername = holdername.getText().toString();


                   dbHelper.addbookings(email, name, phone, slotname, slotno, slotdate, slottime, slotcardno, slotcvvno, slotexpdate, slotholdername);
                   dbHelper.slotbookings(email, name, phone, slotname, slotno, slotdate, slottime, slotcardno, slotcvvno, slotexpdate, slotholdername);

                   Intent intent=new Intent(getApplicationContext(),MainActivity4.class);
                   intent.putExtra("usemail",email);

                   PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                   SmsManager sms=SmsManager.getDefault();
                   sms.sendTextMessage(""+ADMINNUM, null, "Mr. "+name+" , Requested to PARK his/her CAR at, "+slotname+" Kindly APPROVE or DECLINE his Request...", pi,null);

                   Toast.makeText(getApplicationContext(), "Requset Sent successfully!",Toast.LENGTH_SHORT).show();
                   Toast.makeText(getApplicationContext(), "Soon You Will Receive A Confirmation Message !",Toast.LENGTH_SHORT).show();
                   Toast.makeText(getApplicationContext(), "Thank You!!!",Toast.LENGTH_SHORT).show();


               }
               else {
                   Toast.makeText(MainActivity11.this, "Please Enter All the Data...", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }

}