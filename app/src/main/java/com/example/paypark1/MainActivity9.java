package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {

    Button slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8;
    String SlotNo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        Intent intent = getIntent();
        String email = intent.getStringExtra("usemail");
        String name = intent.getStringExtra("usname");
        String place = intent.getStringExtra("usplace");
        String phone = intent.getStringExtra("usphone");
        String slotname = intent.getStringExtra("slotname");

        //Toast.makeText(this, ""+email, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+place, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+phone, Toast.LENGTH_SHORT).show();

        slot1=findViewById(R.id.slot1);
        slot2=findViewById(R.id.slot2);
        slot3=findViewById(R.id.slot3);
        slot4=findViewById(R.id.slot4);
        slot5=findViewById(R.id.slot5);
        slot6=findViewById(R.id.slot6);
        slot7=findViewById(R.id.slot7);
        slot8=findViewById(R.id.slot8);

        slot1.setBackgroundColor(0xFFf7b5ab);
        slot2.setBackgroundColor(0xFFf7b5ab);
        slot3.setBackgroundColor(0xFFf7b5ab);
        slot4.setBackgroundColor(0xFFf7b5ab);
        slot5.setBackgroundColor(0xFFf7b5ab);
        slot6.setBackgroundColor(0xFFf7b5ab);
        slot7.setBackgroundColor(0xFFf7b5ab);
        slot8.setBackgroundColor(0xFFf7b5ab);

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot1.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 1";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });

        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot2.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 2";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });

        slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot3.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 3";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });

        slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot4.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 4";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });
        slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot5.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 5";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });
        slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot6.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 6";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });
        slot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot7.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 7";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });
        slot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot8.setBackgroundColor(0xFFa8faa2);
                SlotNo="SLOT 8";
                Intent i=new Intent(MainActivity9.this,MainActivity10.class);
                i.putExtra("usemail",email);
                i.putExtra("usname",name);
                i.putExtra("usphone",phone);
                i.putExtra("usplace",place);
                i.putExtra("slotname",slotname);
                i.putExtra("slotno",SlotNo);
                startActivity(i);

            }
        });



    }
}