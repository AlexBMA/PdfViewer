package com.example.alexandru.pdf.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.adapter.TestOnClick;

import java.util.stream.Stream;

public class SongsYouths extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_youths);
        simpleTestForListView();

    }

    private void simpleTestForListView() {
        // get the list view
        listView = findViewById(R.id.list_view_songs_youths);

        // define the values
        String[] values={"text1","text2","text3","text4","text5","text6","text7","text8","text9","text10"};

        // make the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // set the adapter
        listView.setAdapter(adapter);

        // set the listener
        listView.setOnItemClickListener(new TestOnClick(getApplicationContext(),listView));
    }


}
