package com.example.myapplication2;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText e1,e2;
    String num1_,num2_;
    int num1, num2;
    double num3,num4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setTitle("단순 계산기");

        b1 = (Button)findViewById(R.id.button7);
        b2 = (Button)findViewById(R.id.button8);
        b3 = (Button)findViewById(R.id.button9);
        b4 = (Button)findViewById(R.id.button10);
        e1 = (EditText)findViewById(R.id.editText10);
        e2 = (EditText)findViewById(R.id.editText11);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minus();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mul();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                div();
            }
        });
    }

    private void plus() {
        num1_ = e1.getText().toString();
        num2_ = e2.getText().toString();
        if(num1_ .equals("")) {
            e1.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else if(num2_.equals("")){
            e2.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            num1 = Integer.parseInt(num1_);
            num2 = Integer.parseInt(num2_);
            Toast.makeText(getApplicationContext(),"더하기 계산 결과는 "+ (num1+num2) +" 입니다.",Toast.LENGTH_SHORT)
                    .show();
        }
    }
    private void minus() {
        num1_ = e1.getText().toString();
        num2_ = e2.getText().toString();
        if(num1_ .equals("")) {
            e1.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else if(num2_.equals("")){
            e2.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            num1 = Integer.parseInt(num1_);
            num2 = Integer.parseInt(num2_);
            Toast.makeText(getApplicationContext(),"빼기 계산 결과는 "+ (num1-num2) +" 입니다.",Toast.LENGTH_SHORT)
                    .show();
        }
    }
    private void mul() {
        num1_ = e1.getText().toString();
        num2_ = e2.getText().toString();
        if(num1_ .equals("")) {
            e1.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else if(num2_.equals("")){
            e2.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            num1 = Integer.parseInt(num1_);
            num2 = Integer.parseInt(num2_);
            Toast.makeText(getApplicationContext(),"곱하기 계산 결과는 "+ (num1*num2) +" 입니다.",Toast.LENGTH_SHORT)
                    .show();
        }
    }
    private void div() {
        int result;

        num1_ = e1.getText().toString();
        num2_ = e2.getText().toString();

        if(num1_ .equals("")) {
            e1.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else if(num2_.equals("")){
            e2.requestFocus();
            Toast.makeText(getApplicationContext(),"값을 입력하세요",Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            num3 = Double.parseDouble(num1_);
            num4 = Double.parseDouble(num2_);
            result = (int) (num3/num4);
            Toast.makeText(getApplicationContext(),"나누기 계산 결과는 "+ result +" 입니다.",Toast.LENGTH_SHORT)
                    .show();
        }
    }

}
