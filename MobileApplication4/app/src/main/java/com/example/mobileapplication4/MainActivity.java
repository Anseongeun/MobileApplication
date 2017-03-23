package com.example.mobileapplication4;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imege;
    TextView title;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴를 눌러보세요");

        imege = (ImageView)findViewById(R.id.imageView);
        title = (TextView)findViewById(R.id.textView);
        layout = (RelativeLayout)findViewById(R.id.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mnubackgroundRed:
                layout.setBackgroundColor(Color.rgb(100,0,0));
                break;
            case R.id.mnubackgroundBlue:
                layout.setBackgroundColor(Color.rgb(0,0,100));
                break;
            case R.id.mnubackgroundYellow:
                layout.setBackgroundColor(Color.rgb(100,100,100));
                break;
            case R.id.mnupicRotate:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                    //추가하기
                }

                break;
            case R.id.mnushowTitle:
                if(item.isChecked()){
                    item.setChecked(false);
                    title.setVisibility(View.INVISIBLE);
                }
                else{
                    item.setChecked(true);
                    title.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.mnuExpention:
                if(item.isChecked()){
                    item.setChecked(false);
                    imege.setScaleX(1);
                    imege.setScaleY(1);
                }
                else{
                    item.setChecked(true);
                    imege.setScaleX(2);
                    imege.setScaleY(2);
                }
                break;
            case  R.id.mnuChicken:
                setchicken();
                item.setChecked(true);
                break;
            case  R.id.mnuSpaghetti:
                item.setChecked(true);
                setspa();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setspa() {
        imege.setImageResource(R.drawable.spaghetti);
        title.setText("스파게티~ 맛있어요!!");
    }

    private void setchicken() {
        imege.setImageResource(R.drawable.chicken);
        title.setText("치킨~ 맛있어요!!");
    }
}
