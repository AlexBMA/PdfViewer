package com.example.alexandru.pdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alexandru.pdf.activities.SongActivity;
import com.example.alexandru.pdf.activities.SongsYouths;

public class MainActivity extends AppCompatActivity {

    //ImageView imageView;
    Button songButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageView = findViewById(R.id.button_test);
        songButton = findViewById(R.id.button_song_tineri);

        /*
        textView = findViewById(R.id.text_view_res_db);

        MyDatabase myDatabase = new MyDatabase(getApplicationContext());

        Cursor c = myDatabase.getSongs();

        if(c!=null) {

            int index = c.getInt(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
            String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
            String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));
            String songCategory = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_song_category));

            SongActivity song = new SongActivity(index,songTitle, songText, songCategory);
            // TODO make cursor that searches just id and name populate the list with the result and edit onclick for list item
            // TODO so that is show the right song full text


            textView.setText(song.toString());
        }else{
            textView.setText("%%%");
        }
        */

    }

    public void toSongYouths(View view){
        Intent intent = new Intent(MainActivity.this, SongsYouths.class);
        startActivity(intent);
    }

    public void next(View view){
        Intent intent = new Intent(MainActivity.this, SongActivity.class);
        startActivity(intent);
    }
}
