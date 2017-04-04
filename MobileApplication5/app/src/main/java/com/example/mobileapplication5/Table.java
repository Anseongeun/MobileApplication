package com.example.mobileapplication5;

import java.util.Date;

/**
 * Created by 박남주 on 2017-03-30.
 */

public class Table {

    String tablename;
    long time;
    int date, spaghetti, pizza, price, membership;

    public Table(String tablename,int spaghetti,int pizza, int membership){

        this.tablename = tablename;
        this.spaghetti = spaghetti;
        this.pizza = pizza;
        this.membership = membership;
        date = new Date().getDate();
        time = new Date().getTime();
        if(membership == 0){
            this.price = ((spaghetti*10000)+(pizza*12000)*90/100);
        }
        else{
            this.price = ((spaghetti*10000)+(pizza*12000)*70/100);
        }
    }
}
