package com.example.mmh.myfragmenttrain.data_folder;

import android.net.Uri;
import android.net.UrlQuerySanitizer;

import java.io.InputStream;
import java.util.ArrayList;

public class contact_elem_data {
    private String id,name;
    private InputStream photo;
    private ArrayList<String>phonenum=new ArrayList<>();
    boolean love;

    public contact_elem_data() {

    }

    public void setLove(boolean love) {
        this.love = love;
    }

    public boolean isLove() {

        return love;
    }

    public contact_elem_data(String id, String name, InputStream  photo, ArrayList<String> phonenum) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.phonenum = phonenum;
        love=false;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public InputStream  getPhoto() {
        return photo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(InputStream  photo) {
        this.photo = photo;
    }

    public void setPhonenum(ArrayList<String> phonenum) {
        this.phonenum = phonenum;
    }

    public ArrayList<String> getPhonenum() {
        return phonenum;

    }


}
