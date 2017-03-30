package com.example.mobileapplication5;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 박남주 on 2017-03-30.
 */

public class fragment extends Fragment{

    Button bT1,bT2,bT3,bT4;
    TextView tablename, time, spaghetti, pizza, membership, price;
    TableLayout info;
    Table table1,table2,table3,table4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_layout,null);


        table1 = new Table("테이블1",0,0,0,0);
        table2 = new Table("테이블1",0,0,0,0);
        table3 = new Table("테이블1",0,0,0,0);
        table4 = new Table("테이블1",0,0,0,0);

        bT1 = (Button)fragment.findViewById(R.id.bT1);
        bT2 = (Button)fragment.findViewById(R.id.bT2);
        bT3 = (Button)fragment.findViewById(R.id.bT3);
        bT4 = (Button)fragment.findViewById(R.id.bT4);
        tablename = (TextView)fragment.findViewById(R.id.tablename);
        info = (TableLayout)fragment.findViewById(R.id.info);

        bT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableinfo(0);
            }
        });
        bT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tableinfo(1);
            }
        });
        bT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableinfo(2);
            }
        });
        bT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableinfo(0);
            }
        });


        return fragment;
    }
    public void tableinfo(int num){

        info.setVisibility(View.VISIBLE);

        switch (num){
            case 0:
                tablename.setText(table1.tablename);
                if(table1.state == 0){

                    emptyTable();
                }

                break;
            case 1:
                tablename.setText("테이블2");
                if(table2.state == 0){
                    emptyTable();
                }
                break;
            case 2:
                tablename.setText("테이블3");
                if(table3.state == 0){
                    emptyTable();
                }
                break;
            case 3:
                tablename.setText("테이블4");
                if(table4.state == 0){
                    emptyTable();
                }
                break;

        }
    }

    public void emptyTable(){
        Toast.makeText(getActivity(),"비어있는 테이블입니다.", Toast.LENGTH_SHORT)
                .show();
    }

}
