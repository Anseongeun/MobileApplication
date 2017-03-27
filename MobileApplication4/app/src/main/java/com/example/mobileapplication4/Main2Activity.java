package com.example.mobileapplication4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TabHost tabhost;
    EditText eWeight, eHeighgt;
    TextView tResult;
    int weight;
    float height,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");

        init();

    }

    private void init() {
        tabhost = (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();

        tabhost.addTab(tabhost.newTabSpec("A").setContent(R.id.tab1).setIndicator("BMI 계산기"));

        tabhost.addTab(tabhost.newTabSpec("B").setContent(R.id.tab2).setIndicator("면적 계산기"));
    }

    public void onMyClick(View v){
        if(v.getId() == R.id.bResultBMI){
            eWeight = (EditText)findViewById(R.id.eWeight);
            eHeighgt = (EditText)findViewById(R.id.eHeight);
            tResult = (TextView)findViewById(R.id.tResult);

            weight = Integer.parseInt(eWeight.getText().toString());
            height = Float.parseFloat(eHeighgt.getText().toString());

            bmi = weight/(height*height/10000);

           if(bmi < 18.5){
               tResult.setText("체중부족입니다.");
           }
            else if(bmi >= 18.5 && bmi <= 22.9){
                tResult.setText("정상입니다.");
           }
            else if(bmi >= 23.0 && bmi <= 24.9){
               tResult.setText("과체중입니다.");
           }
            else{
               tResult.setText("비만입니다.");
           }

        }
        else if(v.getId() == R.id.bTrans1){

        }
        else if(v.getId() == R.id.bTrans2){

        }
    }
}
