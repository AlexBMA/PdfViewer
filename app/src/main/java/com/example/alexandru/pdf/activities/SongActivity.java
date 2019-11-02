package com.example.alexandru.pdf.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.constant.AppConstant;
import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
import com.example.alexandru.pdf.dbpack.MyDatabase;
import com.example.alexandru.pdf.model.Song;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class SongActivity extends AppCompatActivity {

    //private Button zoomPlus;
    private TextView textViewSongText;
    private TextView textViewSongTitle;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        //zoomPlus = findViewById(R.id.button_zoom_plus);
        textViewSongText = findViewById(R.id.text_view_song);
        textViewSongTitle = findViewById(R.id.text_view_top);

        Intent intent = getIntent();

        final int idSong = intent.getIntExtra(AppConstant.ID_SONG, -1);

        withNoNetWorkCase(idSong);

    }

    private void withNoNetWorkCase(int idSong) {
        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        Cursor cursorSong = myDatabase.getSong(idSong);

        int columnIndexId = cursorSong.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID);
        int columnIndexTitle = cursorSong.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE);
        int columnIndexSongText = cursorSong.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT);

        int id = cursorSong.getInt(columnIndexId);
        String songTitle = cursorSong.getString(columnIndexTitle);
        String songText = cursorSong.getString(columnIndexSongText);

        setTheView(id, songTitle, songText);
    }

    private void setTheView(int id, String songTitle, String songText) {
        songTitle = id + " " + songTitle;
        textViewSongTitle.setText(songTitle);
        textViewSongText.setText(songText);
    }

    private void withNetWorkCase(final int idSong) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getDataAndSetTheView(dataSnapshot, idSong);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getDataAndSetTheView(@NonNull DataSnapshot dataSnapshot, int idSong) {
        String path = String.valueOf(idSong - 1);
        DataSnapshot child = dataSnapshot.child(path);

        Song songFromFireBase = child.getValue(Song.class);

        if (songFromFireBase != null) {

            String textSong = songFromFireBase.getTextSong();
            String nameSong = songFromFireBase.getNameSong();
            int id = songFromFireBase.getId();

            setTheView(id, nameSong, textSong);
        }
    }


}
