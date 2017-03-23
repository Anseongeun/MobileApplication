package com.example.moapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class menuActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textView = (TextView)findViewById(R.id.textView);

        //registerForContextMenu();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if( v == textView){
            //getMenuInflater().inflater(R.menu.menu1, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backgroundBlue:
               // textView.setBackground();
        }
        return super.onContextItemSelected(item);

    }

       @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        menu.add(0,100,0,"배경색");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.backgroundYellow){}
        else if(item.getItemId() == R.id.backgroundBlue){}
        else if(item.getItemId() == R.id.mnuFontSize20){
            textView.setTextSize(20);
            item.setChecked(true);
        }
        else if(item.getItemId() == R.id.mnuFontSize40){
            textView.setTextSize(40);
            item.setChecked(true);
        }

        return super.onOptionsItemSelected(item);
    }
}
