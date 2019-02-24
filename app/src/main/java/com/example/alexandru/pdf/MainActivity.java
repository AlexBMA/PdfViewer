package com.example.alexandru.pdf;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandru.pdf.activities.SongsYouths;
import com.example.alexandru.pdf.activities.TestSong;
import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
import com.example.alexandru.pdf.dbpack.MyDatabase;
import com.example.alexandru.pdf.model.Song;

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

        textView = findViewById(R.id.text_view_res_db);

        MyDatabase myDatabase = new MyDatabase(getApplicationContext());

        Cursor c = myDatabase.getEmployees();

        if(c!=null) {

            int index = c.getInt(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
            String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
            String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));
            String songCategory = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_song_category));

            Song song = new Song(index,songTitle, songText, songCategory);


            textView.setText(song.toString());
        }else{
            textView.setText("%%%");
        }


    }

    public void toSongTienri(View view){
        Intent intent = new Intent(MainActivity.this, SongsYouths.class);
        startActivity(intent);
    }

    public void next(View view){
        Intent intent = new Intent(MainActivity.this, TestSong.class);
        startActivity(intent);
    }
}
