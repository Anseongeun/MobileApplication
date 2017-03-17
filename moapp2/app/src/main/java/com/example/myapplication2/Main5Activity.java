package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3;
    CheckBox c1;
    TextView price,num;
    int total_price, total_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setTitle("레스토랑 주문");

        b1 = (Button)findViewById(R.id.button4);
        e1 = (EditText)findViewById(R.id.editText7);
        e2 = (EditText)findViewById(R.id.editText9);
        e3 = (EditText)findViewById(R.id.editText8);
        c1 = (CheckBox)findViewById(R.id.checkBox);
        price = (TextView)findViewById(R.id.textView13);
        num = (TextView)findViewById(R.id.textView11);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });

    }
    public void init(){
        int pizza, spa, salad;

        String pizza_ = e1.getText().toString();
        if(pizza_.equals(""))
            pizza = 0;
        else pizza = Integer.parseInt(pizza_);

        String spa_ = e2.getText().toString();
        if(spa_.equals(""))
            spa = 0;
        else spa = Integer.parseInt(spa_);

        String salad_ = e3.getText().toString();
        if(salad_.equals(""))
            salad = 0;
        else salad = Integer.parseInt(salad_);

        total_num = pizza+spa+salad;
        total_price = (15000*pizza)+(13000*spa)+(9000*salad);

        if(c1.isChecked()){
            total_price = (total_price *90 ) / 100;
        }

        num.setText(total_num+"개");
        price.setText(total_price+"원");


    }
}
