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
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 박남주 on 2017-03-30.
 */

public class fragment extends Fragment implements View.OnClickListener{

    Button bT1, bT2, bT3, bT4,bNew,bChange,bInit;
    TextView tablename, time, spaghetti, pizza, membership, price;
    TableLayout layout_info;
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
        time = (TextView) fragment.findViewById(R.id.time);
        spaghetti = (TextView) fragment.findViewById(R.id.spaghetti);
        pizza = (TextView) fragment.findViewById(R.id.pizza);
        price = (TextView) fragment.findViewById(R.id.price);
        membership = (TextView) fragment.findViewById(R.id.membership);
        layout_info = (TableLayout) fragment.findViewById(R.id.info);

        bT1.setOnClickListener(this);
        bT2.setOnClickListener(this);
        bT3.setOnClickListener(this);
        bT4.setOnClickListener(this);

        bNew.setOnClickListener(this);
        bChange.setOnClickListener(this);
        bInit.setOnClickListener(this);

        return fragment;
    }

    public void tableinfo(int num) {
        switch (num){
            case 1:
                if(table1 == null) {
                    table1 = new Table("테이블1", 0, 0, 0, 0);
                    initInfo(1);
                }
                else{

                }
                break;
            case 2:
                if(table2 == null) {
                    table2 = new Table("테이블2", 0, 0, 0, 0);
                    initInfo(2);
                }
                else{

                }

                break;
            case 3:
                if(table3 == null) {
                    table3 = new Table("테이블3", 0, 0, 0, 0);
                    initInfo(3);
                }
                else{

                }

                break;
            case 4:
                if(table4 == null) {
                    table4 = new Table("테이블4", 0, 0, 0, 0);
                    initInfo(4);
                }
                else{

                }
                break;
        }
        layout_info.setVisibility(View.VISIBLE);
    }

    private void initInfo(int i) {
        switch(i){
            case 1:
                tablename.setText(table1.tablename);
                break;
            case 2:
                tablename.setText(table2.tablename);
                break;
            case 3:
                tablename.setText(table3.tablename);
                break;
            case 4:
                tablename.setText(table4.tablename);
                break;
        }
        pizza.setText("");
        spaghetti.setText("");
        membership.setText("");
        price.setText("0원");
        emptyToast();
    }

    public void emptyToast() {
        Toast.makeText(getActivity(), "비어있는 테이블입니다.", Toast.LENGTH_SHORT)
                .show();
    }

    public void newOrder(final View v){

        dlgView = View.inflate(v.getContext(),R.layout.dialog,null);

        final EditText ePizza = (EditText)dlgView.findViewById(R.id.ePizza);
        final EditText eSpaghetti = (EditText)dlgView.findViewById(R.id.eSpaghetti);
        final RadioButton basic = (RadioButton) dlgView.findViewById(R.id.basic);
        final RadioButton vip = (RadioButton) dlgView.findViewById(R.id.vip);

        dlg = new AlertDialog.Builder(v.getContext());
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i){
                Snackbar.make(v,"정보가 입력되었습니다.",Snackbar.LENGTH_SHORT)
                        .show();
                if(tablename.getText().toString().contains("테이블1")){

                    table1.pizza = Integer.parseInt(ePizza.getText().toString());
                    table1.spaghetti = Integer.parseInt(eSpaghetti.getText().toString());

                    if(basic.isChecked()){
                        table1.membership = 0;
                    }
                    else if(vip.isChecked()){
                        table1.membership = 1;
                    }
                    setInfo(1);
                }
                else if(tablename.getText().toString().contains("테이블2")){
                    table2.pizza = Integer.parseInt(ePizza.getText().toString());
                    table2.spaghetti = Integer.parseInt(eSpaghetti.getText().toString());
                    if(basic.isChecked()){
                        table2.membership = 0;
                    }
                    else if(vip.isChecked()){
                        table2.membership = 1;
                    }
                    setInfo(2);
                }
                else if(tablename.getText().toString().contains("테이블3")){
                    table3.pizza = Integer.parseInt(ePizza.getText().toString());
                    table3.spaghetti = Integer.parseInt(eSpaghetti.getText().toString());
                    if(basic.isChecked()){
                        table3.membership = 0;
                    }
                    else if(vip.isChecked()){
                        table3.membership = 1;
                    }
                    setInfo(3);
                }
                else if(tablename.getText().toString().contains("테이블4")){
                    table4.pizza = Integer.parseInt(ePizza.getText().toString());
                    table4.spaghetti = Integer.parseInt(eSpaghetti.getText().toString());
                    if(basic.isChecked()){
                        table4.membership = 0;
                    }
                    else if(vip.isChecked()){
                        table4.membership = 1;

                    }
                    setInfo(4);
                }
            }
        });
        dlg.setNegativeButton("취소", null);
        dlg.setTitle("정보를 입력해 주세요");
        dlg.setView(dlgView);
        dlg.show();

    }

    public void setInfo(int num){//해당 테이블에 맞게 정보 저장하기
        int total = 0;
        Log.d("Tag","남주3");
        switch (num){
            case 1:
                tablename.setText(table1.tablename);
                spaghetti.setText(table1.spaghetti+"");
                pizza.setText(table1.pizza+"");
                total =((table1.pizza *10000)+(table1.spaghetti*12000));
                if(table1.membership == 0) {
                    membership.setText("기본 멤버십");
                    total = (total*90)/100;
                }
                else{
                    membership.setText("VIP 멤버십");
                    total = (total*70)/100;
                }
                price.setText(total+"");
                Log.d("Tag","남주3-1");
                break;
            case 2:
                tablename.setText(table2.tablename);
                spaghetti.setText(table2.spaghetti);
                pizza.setText(table2.pizza);
                total =((table2.pizza *10000)+(table3.spaghetti*12000));
                if(table2.membership == 0) {
                    membership.setText("기본 멤버십");
                    total = (total*90)/100;
                }
                else {
                    membership.setText("VIP 멤버십");
                    total = (total*70)/100;
                }
                price.setText(total);
                break;
            case 3:
                tablename.setText(table3.tablename);
                spaghetti.setText(table3.spaghetti);
                pizza.setText(table3.pizza);

                total =((table3.pizza *10000)+(table3.spaghetti*12000));
                if(table3.membership == 0) {
                    membership.setText("기본 멤버십");
                    total = (total*90)/100;
                }
                else {
                    membership.setText("VIP 멤버십");
                    total = (total*70)/100;
                }
                price.setText(total);
                break;
            case 4:
                tablename.setText(table4.tablename);
                spaghetti.setText(table4.spaghetti);
                pizza.setText(table4.pizza);

                total =((table4.pizza *10000)+(table4.spaghetti*12000));
                if(table4.membership == 0) {
                    membership.setText("기본 멤버십");
                    total = (total*90)/100;
                }
                else {
                    membership.setText("VIP 멤버십");
                    total = (total*70)/100;
                }
                price.setText(total);

                price.setText((table4.pizza *10000)+(table4.spaghetti*12000));
                break;
        }
    }


    public boolean isEmpty(TextView tablename){
        if(tablename == null) return true;
        else return false;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bT1:
                tableinfo(1);
                break;
            case R.id.bT2:
                tableinfo(2);
                break;
            case R.id.bT3:
                tableinfo(3);
                break;
            case R.id.bT4:
                tableinfo(4);
                break;
            case R.id.bNew:
                newOrder(view);
                break;
            case R.id.bChange:

                break;
        }
    }


}
