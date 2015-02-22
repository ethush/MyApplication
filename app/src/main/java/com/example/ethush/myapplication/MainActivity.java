package com.example.ethush.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends Activity {

    //global variable holding the list.
    public ArrayList<ListItem> mArrayList = new ArrayList<ListItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get xml references
        ListView listTest =(ListView)findViewById(R.id.list_test);
        Button btnUpdate = (Button)findViewById(R.id.btn_update_list);

        //create new array list object

        //create new list item instance with pre-fill values
        ListItem listItem = new ListItem();
        listItem.setHeader("Benjamin Gil");
        listItem.setSubHeader("Manager");
        listItem.setImageUser(getResources().getDrawable(R.drawable.tomateros));
        //add list item to list
        mArrayList.add(listItem);

        //create new list item instance and pre-fill values
        listItem = new ListItem();
        listItem.setHeader("Rico Noel");
        listItem.setSubHeader("Fielder Central");
        listItem.setImageUser(getResources().getDrawable(R.drawable.tomateros));
        //add list item to list
        mArrayList.add(listItem);

        //create adapter instance providing context and array list
        final ListItemAdapter listItemAdapter = new ListItemAdapter(getBaseContext(),mArrayList);
        //set list adapter
        listTest.setAdapter(listItemAdapter);

        //set on click listeners
        listTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //show header of the item clicked on a toast
                Toast.makeText(getBaseContext(),mArrayList.get(i).getHeader()+" pressed",Toast.LENGTH_SHORT).show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //create new list item instance and pre-fill values
                ListItem listItem = new ListItem();
                listItem.setHeader("Santiago Dolores");
                listItem.setSubHeader("Catcher");
                listItem.setImageUser(getResources().getDrawable(R.drawable.tomateros));
                //add item to array list
                mArrayList.add(listItem);

                //create new list item instance and pre-fill values
                /*
                listItem = new ListItem();
                listItem.setHeader("Item " + (mArrayList.size()+1));
                listItem.setSubHeader("SubItem " + (mArrayList.size()+1));
                listItem.setImageUser(getResources().getDrawable(R.drawable.image_user));
                //add item to array list
                mArrayList.add(listItem);
                */

                //notify the adapter the list has changed with new data.
                listItemAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}