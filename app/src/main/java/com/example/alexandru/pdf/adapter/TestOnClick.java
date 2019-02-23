package com.example.alexandru.pdf.adapter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TestOnClick  implements AdapterView.OnItemClickListener {

    Context context;
    ListView listView;

    public TestOnClick(Context context,ListView listView){
        this.context = context;
        this.listView = listView;
    }

    //getApplicationContext()

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        // ListView Clicked item index
        int itemPosition = position;

        // ListView Clicked item value
        String  itemValue    = (String) listView.getItemAtPosition(position);

        // Show Alert
        Toast.makeText(context, "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();

        }

}
