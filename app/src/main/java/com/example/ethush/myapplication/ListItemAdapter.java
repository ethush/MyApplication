package com.example.ethush.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by walter on 15/11/14.
 */

public class ListItemAdapter extends BaseAdapter{

    //global variables to be obtained on the constructor
    private Context mContext;
    private ArrayList<ListItem> mArrayList;
    private LayoutInflater mLayoutInflater;

    //custom constructor for the adapter receiving context and array list
    public ListItemAdapter(Context context,ArrayList<ListItem> arrayList){
        //set obtained values to global variables
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList = arrayList;
    }
    @Override
    public int getCount() {
        //get list's size
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        //get list's item
        return mArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        //dummy id
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //This method is called for each row on the list view letting you
        //get the references from the xml and assign the corresponding values
        //of the current list item.

        Holder holder;

        //assign to new view
        View v = view;
        //check if the view is null, meaning there is no previous view used.
        if (v == null) {
            //new holder instance
            holder = new Holder();
            //inflate the view with custom list item view
            v = mLayoutInflater.inflate(R.layout.list_item, null);
            //get xml references on holder variables

            holder.imageUser = (ImageView)v.findViewById(R.id.image_user);
            holder.txtHeader = (TextView)v.findViewById(R.id.txt_header);
            holder.txtSubHeader = (TextView)v.findViewById(R.id.txt_subheader);
            //set view tag
            v.setTag(holder);
        }else {
            //get view tag to avoid referencing again
            holder = (Holder) v.getTag();
        }

        //set values to each view inside the item according to the array list current view
        holder.imageUser.setImageDrawable(mArrayList.get(position).getImageUser());
        holder.txtHeader.setText(mArrayList.get(position).getHeader());
        holder.txtSubHeader.setText(mArrayList.get(position).getSubHeader());

        //Finally return the custom view
        return v;
    }

    //static class called holder used to recycle the view elements on each row.
    static class Holder {
        ImageView imageUser;
        TextView txtHeader;
        TextView txtSubHeader;
    }
}
