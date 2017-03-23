package com.example.mobileapplication4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class Main2Activity extends AppCompatActivity {
    TabHost tabhost;
    Button tab1_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");

        init();

        tab1_btn = (Button)findViewById(R.id.button);
        tab1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void init() {
        tabhost = (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();

        tabhost.addTab(tabhost.newTabSpec("A").setContent(R.id.tab1).setIndicator("BMI 계산기"));

        tabhost.addTab(tabhost.newTabSpec("B").setContent(R.id.tab2).setIndicator("면적 계산기"));
    }
}
