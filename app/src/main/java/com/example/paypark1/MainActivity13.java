package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity13 extends AppCompatActivity {

    Button LoadData,AcceptSlot,DeclineSlot;
    TextView Ref,Slotget,Slotfetch;
    private DBHelper dbHelper;
    AutoCompleteTextView SlotNum;
    List<String> Itemlist = new ArrayList<String>();

    ArrayList<String> SlotList = new ArrayList<String>();

    String USEREMAIL;
    String USERNAME;
    String USERPHONE;
    String USERPLACE;
    String USERSLOTNO;
    String USERSLOTDATE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        dbHelper = new DBHelper(this);

        Slotget = findViewById(R.id.adminbookedslots);

        Ref = findViewById(R.id.adminrfrshdata);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        Ref.startAnimation(anim);

        Ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dbHelper.getSlotBook();

                Ref.setVisibility(View.GONE);

                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity13.this, "No Slots Registered...", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (cursor.moveToFirst()) {
                    do {
                         String SlotNumbers=cursor.getString(1);
                        String SlotName=cursor.getString(0);


                        //Toast.makeText(MainActivity13.this,""+USEREMAIL+""+USERNAME+""+USERPHONE+""+USERPLACE+""+USERSLOTNO+""+USERSLOTDATE,Toast.LENGTH_SHORT).show();
                        Slotget.append(SlotNumbers+" - "+SlotName+"\n");

                        SlotList.add(SlotNumbers+"-"+SlotName+"\n");
                        //Toast.makeText(MainActivity13.this,""+SlotList,Toast.LENGTH_SHORT).show();

                        Itemlist.add(SlotNumbers);

                    } while (cursor.moveToNext());
                }
            }
        });


        SlotNum = findViewById(R.id.adminenterslot);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,Itemlist);
        SlotNum.setAdapter(adapter);
        SlotNum.setThreshold(1);

        Slotfetch = findViewById(R.id.adminfetchdata);

        LoadData = findViewById(R.id.adminloaddata);
        LoadData.setBackgroundColor(0xFFffc34d);

        LoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor cursor = dbHelper.getCurrentBook(SlotNum.getText().toString());
                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity13.this, "Error ...", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (cursor.moveToFirst()) {
                    do {
                        USEREMAIL = cursor.getString(0);
                        USERNAME = cursor.getString(1);
                        USERPHONE = cursor.getString(2);
                        USERPLACE=cursor.getString(3);
                        USERSLOTNO=cursor.getString(4);
                        USERSLOTDATE=cursor.getString(5);

                        //Toast.makeText(MainActivity13.this,""+USEREMAIL+""+USERNAME+""+USERPHONE+""+USERPLACE+""+USERSLOTNO+""+USERSLOTDATE,Toast.LENGTH_SHORT).show();
                        Slotfetch.setText(" EMAIL : "+USEREMAIL+"\n \n NAME : "+USERNAME+"\n \n PHONE : "+USERPHONE+"\n \n PLACE : "+USERPLACE+"\n \n SLOT NO : "+USERSLOTNO+"\n \n DATE : "+USERSLOTDATE);
                        AcceptSlot.setVisibility(View.VISIBLE);
                        DeclineSlot.setVisibility(View.VISIBLE);

                    } while (cursor.moveToNext());
                }

            }
        });



                AcceptSlot = findViewById(R.id.adminconfirmslot);
                DeclineSlot = findViewById(R.id.admindeclinelot);

                AcceptSlot.setBackgroundColor(0xFF00FF00);
                DeclineSlot.setBackgroundColor(0xFFFF0000);

                AcceptSlot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(getApplicationContext(),MainActivity13.class);

                       PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                        SmsManager sms=SmsManager.getDefault();
                        sms.sendTextMessage(""+USERPHONE, null, "Mr. "+USERNAME+" , Your Request from "+USEREMAIL+" to PARK your CAR at "+USERPLACE+" has been APPROVED...", pi,null);

                        dbHelper.acceptBook(USEREMAIL,USERNAME,USERPHONE,USERPLACE,USERSLOTNO,USERSLOTDATE);

                        Toast.makeText(MainActivity13.this,"SUCCESSFULLY APPROVED...",Toast.LENGTH_SHORT).show();
                    }
                });

        DeclineSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity13.class);

                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(""+USERPHONE, null, "Mr. "+USERNAME+" , Your Request from "+USEREMAIL+" to PARK your CAR at "+USERPLACE+" has been DECLINED...", pi,null);

                dbHelper.declineBook(USEREMAIL,USERNAME,USERPHONE,USERPLACE,USERSLOTNO,USERSLOTDATE);

                Toast.makeText(MainActivity13.this,"SUCCESSFULLY DECLINED...",Toast.LENGTH_SHORT).show();

            }
        });

    }
}