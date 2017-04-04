package com.example.mobileapplication5;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by 박남주 on 2017-03-30.
 */

public class fragment extends Fragment implements View.OnClickListener{

    Button bT1, bT2, bT3, bT4,bNew,bChange,bInit;
    TextView tablename, date, spaghetti, pizza, membership, price;
    TableLayout layout_info;
    LinearLayout layout_func;
    Table table1 = null, table2 = null, table3 = null, table4 = null;
    AlertDialog.Builder dlg;
    View dlgView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_layout, null);

        bT1 = (Button) fragment.findViewById(R.id.bT1);
        bT2 = (Button) fragment.findViewById(R.id.bT2);
        bT3 = (Button) fragment.findViewById(R.id.bT3);
        bT4 = (Button) fragment.findViewById(R.id.bT4);
        bNew = (Button) fragment.findViewById(R.id.bNew);
        bChange = (Button)fragment.findViewById(R.id.bChange);
        bInit = (Button)fragment.findViewById(R.id.bInit);
        tablename = (TextView) fragment.findViewById(R.id.table);
        date = (TextView)fragment.findViewById(R.id.date);
        spaghetti = (TextView) fragment.findViewById(R.id.spaghetti);
        pizza = (TextView) fragment.findViewById(R.id.pizza);
        price = (TextView) fragment.findViewById(R.id.price);
        membership = (TextView) fragment.findViewById(R.id.membership);
        layout_info = (TableLayout) fragment.findViewById(R.id.info);
        layout_func = (LinearLayout)fragment.findViewById(R.id.layoutFunc);

        bT1.setOnClickListener(this);
        bT2.setOnClickListener(this);
        bT3.setOnClickListener(this);
        bT4.setOnClickListener(this);

        bNew.setOnClickListener(this);
        bChange.setOnClickListener(this);
        bInit.setOnClickListener(this);


        return fragment;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bT1:
                initInfo(1);
                break;
            case R.id.bT2:
                initInfo(2);
                break;
            case R.id.bT3:
                initInfo(3);
                break;
            case R.id.bT4:
                initInfo(4);
                break;
            case R.id.bNew:
                newOrder(view);
                break;
            case R.id.bChange:
                change(view);
                break;
            case R.id.bInit:
                initall();
                break;
        }
    }

    public void initInfo(int num) {
        //테이블 버튼 눌렀을 때
        switch (num){
            case 1:
                if(table1 == null) {
                    tablename.setText("테이블1");
                    empty();
                }
                else setInfo(table1);
                break;
            case 2:
                if(table2 == null) {
                    tablename.setText("테이블2");
                    empty();
                }
                else setInfo(table2);
                break;
            case 3:
                if(table3 == null) {
                    tablename.setText("테이블3");
                    empty();
                }
                else setInfo(table3);
                break;
            case 4:
                if(table4 == null) {
                    tablename.setText("테이블4");
                    empty();
                }
                else setInfo(table4);
                break;
        }
        layout_info.setVisibility(View.VISIBLE);
        layout_func.setVisibility(View.VISIBLE);
    }


    public void setInfo(Table table){
        if (table != null) {
            tablename.setText(table.tablename);
            spaghetti.setText(table.spaghetti+"");
            pizza.setText(table.pizza+"");
            if(membership == null) membership.setText("");
            else membership.setText(table.membership);
            price.setText(table.price+"");
            date.setText(table.date);
            bNew.setEnabled(false);
            bChange.setEnabled(true);

        }
    }
    public void empty(){
        date.setText("");
        spaghetti.setText("");
        pizza.setText("");
        membership.setText("");
        price.setText("");
        Toast.makeText(getActivity(), "비어있는 테이블입니다.", Toast.LENGTH_SHORT)
                .show();
        bNew.setEnabled(true);
        bChange.setEnabled(false);
    }

    public void newOrder(final View v){

        dlgView = View.inflate(v.getContext(),R.layout.dialog,null);

        final EditText ePizza = (EditText)dlgView.findViewById(R.id.ePizza);
        final EditText eSpaghetti = (EditText)dlgView.findViewById(R.id.eSpaghetti);
        final RadioButton basic = (RadioButton) dlgView.findViewById(R.id.basic);
        final RadioButton vip = (RadioButton) dlgView.findViewById(R.id.vip);

        dlg = new AlertDialog.Builder(v.getContext());

        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void foo(Table table, Button bt){
                table.pizza = Integer.parseInt(ePizza.getText().toString());
                table.spaghetti = Integer.parseInt(eSpaghetti.getText().toString());
                if(basic.isChecked()){
                    table.membership = "기본멤버십";
                    table.price =  ((table.spaghetti*10000)+(table.pizza*12000)*90/100);
                }
                else if(vip.isChecked()){
                    table.membership = "VIP멤버십";
                    table.price = ((table.spaghetti*10000)+(table.pizza*12000)*70/100);
                }
                table.date = date();
                bt.setText(table.tablename);
                setInfo(table);
            }
            @Override public void onClick(DialogInterface dialogInterface, int i){
                Snackbar.make(v,"정보가 입력되었습니다.",Snackbar.LENGTH_SHORT)
                        .show();
                if(tablename.getText().toString().contains("테이블1")){
                    table1 = new Table("테이블1", 0, 0);
                    foo(table1, bT1);
                }
                else if(tablename.getText().toString().contains("테이블2")){
                    table2 = new Table("테이블2", 0, 0);
                    foo(table2, bT2);
                }
                else if(tablename.getText().toString().contains("테이블3")){
                    table3 = new Table("테이블3", 0, 0);
                   foo(table3, bT3);
                }
                else if(tablename.getText().toString().contains("테이블4")){
                    table4 = new Table("테이블4", 0, 0);
                    foo(table4 ,bT4);
                }
            }
        });
        dlg.setNegativeButton("취소", null);
        dlg.setTitle("정보를 입력해 주세요");
        dlg.setView(dlgView);
        dlg.show();

    }

    public void change(View v){

        dlgView = View.inflate(v.getContext(),R.layout.dialog,null);

        final EditText ePizza = (EditText)dlgView.findViewById(R.id.ePizza);
        final EditText eSpaghetti = (EditText)dlgView.findViewById(R.id.eSpaghetti);
        final RadioButton basic = (RadioButton) dlgView.findViewById(R.id.basic);
        final RadioButton vip = (RadioButton) dlgView.findViewById(R.id.vip);

        dlg = new AlertDialog.Builder(v.getContext());

        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void foo(Table table){
                table.pizza = Integer.parseInt(ePizza.getText().toString());
                table.spaghetti = Integer.parseInt(eSpaghetti.getText().toString());
                if(basic.isChecked()){
                    table.membership = "기본멤버십";
                    table.price =  ((table.spaghetti*10000)+(table.pizza*12000)*90/100);
                }
                else if(vip.isChecked()){
                    table.membership = "VIP멤버십";
                    table.price = ((table.spaghetti*10000)+(table.pizza*12000)*70/100);
                };
                setInfo(table);
            }
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(tablename.getText().toString().contains("테이블1")){
                    foo(table1);
                }
                else if(tablename.getText().toString().contains("테이블2")){
                    foo(table2);
                }
                else if(tablename.getText().toString().contains("테이블3")){
                    foo(table3);
                }
                else if(tablename.getText().toString().contains("테이블4")){
                    foo(table4);
                }
            }
        });
        dlg.setTitle("정보를 수정해 주세요");
        dlg.setView(dlgView);
        dlg.show();
    }

    private void initall() {

        bT1.setText("테이블1(EMPTY)");
        bT2.setText("테이블2(EMPTY)");
        bT3.setText("테이블3(EMPTY)");
        bT4.setText("테이블4(EMPTY)");
        layout_info.setVisibility(View.INVISIBLE);
        tablename.setText("");
        pizza.setText("");
        spaghetti.setText("");
        membership.setText("");
        price.setText("");
        date.setText("");
        table1 = null;
        table2 = null;
        table3 = null;
        table4 = null;
    }

    private String date(){
        long now = System.currentTimeMillis();
        Date date_ = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formatDate = sdfNow.format(date_);

        return  formatDate;
    }






}
