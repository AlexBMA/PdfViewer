package com.example.alexandru.pdf.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.model.Song;

import java.util.List;

public class SongOnItemClickListener implements AdapterView.OnItemClickListener {

    //List<Song> list;

    ListView listView;

    public SongOnItemClickListener(ListView listView){
        this.listView = listView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {


        int positionInList = (int)listView.getItemAtPosition(position);

        Intent intent = new Intent();

        //startActivity(intent);



    }
}
