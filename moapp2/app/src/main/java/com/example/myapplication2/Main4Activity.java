package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setTitle("온도 계산기");

        b1 = (Button)findViewById(R.id.button5);
        b2 = (Button)findViewById(R.id.button6);

        e1 = (EditText)findViewById(R.id.editText5);
        e2 = (EditText)findViewById(R.id.editText6);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String cel_ = e1.getText().toString();
               double cel = Double.parseDouble(cel_);

               Toast.makeText(getApplicationContext(),"Fahrenheit temperature is "+ ((cel*1.8) +32), Toast.LENGTH_SHORT)
                       .show();
           }
       });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fah_ = e2.getText().toString();
                Double fah = Double.parseDouble(fah_);

                Toast.makeText(getApplicationContext(),"Celsius temperature is "+ ((fah-32)/1.8), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}