package com.example.mobileapplication6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Intent.ACTION_DIAL;

public class Main3Activity extends AppCompatActivity {

    TextView txtname, tvmenu1,tvmenu2, tvmenu3, tvtel, tvURL, tvRegdate;
    ImageView imgno, imgURL, imgCall;
    Intent intent;
    Store store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setting();
        intent = getIntent();
        Store store = intent.getParcelableExtra("store_main3");
        setInfo(store);

    }

    private void setting() {
        txtname = (TextView)findViewById(R.id.txtname);
        tvmenu1 = (TextView)findViewById(R.id.tvmenu1);
        tvmenu2 = (TextView)findViewById(R.id.tvmenu2);
        tvmenu3 = (TextView)findViewById(R.id.tvmenu3);
        tvtel = (TextView)findViewById(R.id.tvtel);
        tvURL = (TextView)findViewById(R.id.tvURL);
        tvRegdate = (TextView)findViewById(R.id.tvRegdate);
        imgno = (ImageView)findViewById(R.id.imgno);
        imgCall =(ImageView)findViewById(R.id.imgCall);
        imgURL =(ImageView)findViewById(R.id.imgURL);
    }

    private void setInfo(Store store) {

        txtname.setText(store.name);
        tvmenu1.setText(store.menu[0]);
        tvmenu2.setText(store.menu[1]);
        tvmenu3.setText(store.menu[2]);
        tvtel.setText(store.tel);
        tvURL.setText(store.homepage);
        tvRegdate.setText(store.date_regist);

        switch (store.num_category){
            case 1:
                imgno.setImageResource(R.drawable.food1);
                break;
            case 2:
                imgno.setImageResource(R.drawable.pizza);
                break;
            case 3:
                imgno.setImageResource(R.drawable.hamburger);
                break;
        }
    }

    public void onClick(View v){

        intent = getIntent();
        Store store = intent.getParcelableExtra("store_main3");

        switch (v.getId()){
            case R.id.imgCall:
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/" + store.tel));
                startActivity(intent2);
                break;
            case R.id.imgURL:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(store.homepage));
                startActivity(intent3);
                break;
            case R.id.btnback:
                finish();
                break;
        }
    }
}
