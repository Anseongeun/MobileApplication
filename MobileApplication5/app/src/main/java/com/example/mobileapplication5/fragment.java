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

public class fragment extends Fragment implements View.OnClickListener{

    Button bT1, bT2, bT3, bT4;
    TextView tablename, time, spaghetti, pizza, membership, price;
    TableLayout info;
    Table table1 = null, table2 = null, table3 = null, table4 = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_layout, null);



        bT1 = (Button) fragment.findViewById(R.id.bT1);
        bT2 = (Button) fragment.findViewById(R.id.bT2);
        bT3 = (Button) fragment.findViewById(R.id.bT3);
        bT4 = (Button) fragment.findViewById(R.id.bT4);
        tablename = (TextView) fragment.findViewById(R.id.tablename);
        time = (TextView) fragment.findViewById(R.id.time);
        info = (TableLayout) fragment.findViewById(R.id.info);

        return fragment;
    }

    public void tableinfo(int num) {

        switch (num){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;

        }
        info.setVisibility(View.VISIBLE);
        emptyToast();

    }

    public void emptyToast() {
        Toast.makeText(getActivity(), "비어있는 테이블입니다.", Toast.LENGTH_SHORT)
                .show();
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
        }
    }
}
