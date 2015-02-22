package com.example.ethush.myapplication;

import android.graphics.drawable.Drawable;


/**
 * Created by walter on 15/11/14.
 */
public class ListItem {
    //Attributes for a list item
    private String header;
    private String subHeader;
    private Drawable imageUser;

    //Get and set methods for each attribute

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public Drawable getImageUser() {
        return imageUser;
    }

    public void setImageUser(Drawable imageUser) {
        this.imageUser = imageUser;
    }

}