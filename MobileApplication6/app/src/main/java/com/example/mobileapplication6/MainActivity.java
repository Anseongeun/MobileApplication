package com.example.mobileapplication6;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int _REQ = 100;
    final int RESULT_STORE = 0;

    ListView lv;
    ArrayList<Store> data_store = new ArrayList<Store>();
    ArrayList<String> data_name = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListView();


    }
    public void setListView(){
       intent = new Intent(this, Main3Activity.class);
        lv = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data_name);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("store_main3", data_store.get(i));
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int num, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle("삭제확인")
                        .setIcon(R.drawable.plate)
                        .setMessage("선택한 맛집을 삭제 하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                data_name.remove(num);
                                data_store.remove(num);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(getApplicationContext(),"삭제되었습니다.",Toast.LENGTH_SHORT)
                                .show();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();

                return false;
            }
        });

    }



    public void onClick(View v){
        if(v.getId() == R.id.addStore){//맛집추가
            intent = new Intent(this, Main2Activity.class);
            startActivityForResult(intent, 100);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data_) {
        super.onActivityResult(requestCode, resultCode, data_);
        if(requestCode == _REQ){
            if(resultCode ==  RESULT_STORE){
                Store data_store_ = data_.getParcelableExtra("store");
                data_store.add(data_store_);
                data_name.add(data_store_.name);
                adapter.notifyDataSetChanged();
            }
        }
    }


}
