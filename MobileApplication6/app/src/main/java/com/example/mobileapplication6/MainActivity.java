package com.example.mobileapplication6;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int _REQ = 100;
    final int RESULT_STORE = 0;

    ListView lv;
    ArrayList<Store> data_store = new ArrayList<Store>();
    ArrayList<String> data_name = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListView();


    }
    public void setListView(){
        lv = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data_name);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                setTitle("삭제를 원하십니까?");
                se

                return false;
            }
        });

    }

    public void onClick(View v){
        if(v.getId() == R.id.addStore){//맛집추가
            Intent intent = new Intent(this, Main2Activity.class);
            startActivityForResult(intent, 100);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data_) {
        super.onActivityResult(requestCode, resultCode, data_);
        if(requestCode == _REQ){
            if(resultCode ==  RESULT_STORE){
                Store data_store_ = data_.getParcelableExtra("store");
                data_name.add(data_store_.name);
                adapter.notifyDataSetChanged();
            }
        }
    }


}
