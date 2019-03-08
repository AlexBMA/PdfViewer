package com.example.alexandru.pdf.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.constant.AppConstant;
import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
import com.example.alexandru.pdf.dbpack.MyDatabase;

public class SongActivity extends AppCompatActivity {


    //private Button zoomPlus;
    private TextView textViewSongText;
    private TextView textViewSongTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);


        //zoomPlus = findViewById(R.id.button_zoom_plus);
        textViewSongText = findViewById(R.id.text_view_song);
        textViewSongTitle = findViewById(R.id.text_view_top);

        //StringBuilder songTextStringBuilder = justATest();
        //textViewSongText.setText(songTextStringBuilder.toString());

        Intent intent = getIntent();

        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        //Log.e("Value from intent: ",intent.getIntExtra(AppConstant.ID_SONG,0)+"");
        Cursor c = myDatabase.getSong(intent.getIntExtra(AppConstant.ID_SONG,0));

        int id = c.getInt(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
        String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
        String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));


        songTitle=id+" "+songTitle;
        textViewSongTitle.setText(songTitle);
        textViewSongText.setText(songText);

    }


}
