package com.example.paypark1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity12 extends AppCompatActivity {

    EditText pincode;
    Button pincodesrch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        pincode=findViewById(R.id.pincode);
        pincodesrch=findViewById(R.id.pincodesrch);

        pincodesrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pincode.getText().length() > 6)
                {
                    pincode.setText("");
                    Toast.makeText(MainActivity12.this,"Enter a Valid Pincode...",Toast.LENGTH_SHORT).show();
                }

                else if (pincode.getText().toString().equals("635601"))
                {
                    pincode.setText("");
                    Intent i=new Intent(MainActivity12.this,MainActivity8.class);
                    startActivity(i);
                }

                else
                {
                    pincode.setText("");
                    Toast.makeText(MainActivity12.this,"Enter a Valid Pincode...",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}