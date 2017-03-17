package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("나이계산기");

        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);

        e1 = (EditText)findViewById(R.id.editText3);
        e2 = (EditText)findViewById(R.id.editText4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String year_ = e1.getText().toString();
                int year = Integer.parseInt(year_);

                Toast.makeText(getApplicationContext(),"Your age is "+ (2017-year+1), Toast.LENGTH_SHORT)
                        .show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age_ = e2.getText().toString();
                int age = Integer.parseInt(age_);

                Toast.makeText(getApplicationContext(),"Year that you born is "+(2017-age+1), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
