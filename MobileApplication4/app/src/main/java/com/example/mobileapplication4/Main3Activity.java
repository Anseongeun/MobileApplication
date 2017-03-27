package com.example.mobileapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }
    public void onMyclick(View v){
        if(v.getId() == R.id.bfirActivity){
            Intent intent = new Intent(Main3Activity.this, MainActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.bsecActivity){
            Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
