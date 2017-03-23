package com.example.mobileapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    TextView t1,t2;
    ImageView iv;
    int korean, math, english;
    int total,average;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
                cal();

                t1.setText(total+"점");
                t2.setText(average+"점");

                if(average > 89){
                    iv.setImageResource(R.drawable.a_red);
                }
                else if(average > 79){
                    iv.setImageResource(R.drawable.b_red);
                }
                else{
                    iv.setImageResource(R.drawable.c_red);
                }
                iv.setVisibility(View.VISIBLE);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.INVISIBLE);
                t1.setText("0점");
                t2.setText("0점");
                e1.setText(null);
                e2.setText(null);
                e3.setText(null);
                Toast.makeText(getApplicationContext(),"초기화되었습니다",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init() {

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        t1 = (TextView)findViewById(R.id.textView_grade2);
        t2 = (TextView)findViewById(R.id.textView_average2);
        iv = (ImageView)findViewById(R.id.imageView);

        String str1 = e1.getText().toString();
        String str2 = e2.getText().toString();
        String str3 = e3.getText().toString();


        if(str1.equals("") || str2.equals("") || str3.equals("")){//0이면 0으로!
            if(str1.equals("")){
                e1.setText("0");
            }
            if(str2.equals("")){
                e2.setText("0");
            }
            if(str3.equals("")){
                e3.setText("0");
            }
        }
    }
    private void cal() {
        korean = Integer.parseInt(e1.getText().toString());
        math = Integer.parseInt(e2.getText().toString());
        english =  Integer.parseInt(e3.getText().toString());

        total = korean+math+english;
        average = total/3;
    }
}
