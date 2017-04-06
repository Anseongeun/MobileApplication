package com.example.mobileapplication6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    final int RESULT_STORE = 0;

    EditText etname, ettel, etmenu1, etmenu2, etmenu3, ethomepage;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etname = (EditText)findViewById(R.id.etname);
        ettel = (EditText)findViewById(R.id.ettel);
        etmenu1 = (EditText)findViewById(R.id.etmenu1);
        etmenu2 = (EditText)findViewById(R.id.etmenu2);
        etmenu3 = (EditText)findViewById(R.id.etmenu3);
        ethomepage = (EditText)findViewById(R.id.ethomepage);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            add();
        }
    }
    private void add() {
        intent = new Intent(this, MainActivity.class);
        Store store = new Store(etname.getText().toString(), ettel.getText().toString()
                ,etmenu1.getText().toString(),etmenu2.getText().toString()
                ,etmenu3.getText().toString(), ethomepage.getText().toString());
        intent.putExtra("store", store);
        setResult(RESULT_STORE,intent);
        finish();
    }
}
