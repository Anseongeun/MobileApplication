package com.example.mobileapplication6;


import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 박남주 on 2017-04-06.
 */

public class Store implements Parcelable{
    String name;
    String tel;
    String [] menu;
    String homepage;
    int date_regist;
    int num_category;

    public Store(String name, String tel, String menu1, String menu2, String menu3, String homepage){
        menu = new String[3];
        this.name = name;
        this.tel = tel;
        this.menu[0] = menu1;
        this.menu[1] = menu2;
        this.menu[2] = menu3;
        this.homepage = homepage;
        this.date_regist = 0;
        this.num_category = 0;
    }

    protected Store(Parcel in) {
        name = in.readString();
        tel = in.readString();
        menu = in.createStringArray();
        homepage = in.readString();
        date_regist = in.readInt();
        num_category = in.readInt();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(tel);
        parcel.writeString(homepage);
        parcel.writeInt(date_regist);
        parcel.writeInt(num_category);
        parcel.writeStringArray(menu);
    }
}
