package com.example.moapp4;

import android.app.ActivityGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class Main2Activity extends ActivityGroup {
    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);//inflation

        tabhost = (TabHost)findViewById(R.id.tabhost);
        tabhost.setup();

        TabHost.TabSpec tab1 = tabhost.newTabSpec("A").setContent(R.id.tab1)
                .setIndicator("날짜선택");//Spec만들어주고
        tabhost.addTab(tab1);//추가
        TabHost.TabSpec tab2 = tabhost.newTabSpec("B").setContent(R.id.tab2)
                .setIndicator("시간선택");
        tabhost.addTab(tab2);
        TabHost.TabSpec tab3 = tabhost.newTabSpec("C").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                View view = View.inflate(Main2Activity.this, R.layout.tab3,null);// xml을 객체화 시키고! 그걸 사용

                Button btn = (Button)view.findViewById(R.id.button2);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
                return view;
            }
        })
                .setIndicator("레이팅바");
        tabhost.addTab(tab3);
    }


}
