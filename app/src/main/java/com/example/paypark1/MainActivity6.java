package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity6 extends AppCompatActivity {
    private long pressedTime;
    TextView usernamedb,useremaildb,userplacedb,userphonenodb,uservalidbookdb;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        usernamedb=findViewById(R.id.usernamedb);
        useremaildb=findViewById(R.id.useremaildb);
        userplacedb=findViewById(R.id.userplacedb);
        userphonenodb=findViewById(R.id.userphonenodb);


        Intent intent = getIntent();
        String email = intent.getStringExtra("usemail");
        useremaildb.setText(email);
        String name = intent.getStringExtra("usname");
        usernamedb.setText(name);
        String place = intent.getStringExtra("usplace");
        userplacedb.setText(place);
        String phone = intent.getStringExtra("usphone");
        userphonenodb.setText(phone);


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