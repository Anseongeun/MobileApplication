package com.example.mobileapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity_first extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_first);
    }

    public void onclick(View v){
        if(v.getId() == R.id.button){
            Intent intent = new Intent(MainActivity_first.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(MainActivity_first.this, Main2Activity.class);
            startActivity(intent);
        }

    }
}
