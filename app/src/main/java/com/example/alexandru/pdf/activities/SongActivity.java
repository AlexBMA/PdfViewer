package com.example.alexandru.pdf.activities;

import android.content.Context;
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
import com.example.alexandru.pdf.utils.NetWorkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SongActivity extends AppCompatActivity {

    //private Button zoomPlus;
    private TextView textViewSongText;
    private TextView textViewSongTitle;

    public static final String SONG = "song";
    private FirebaseDatabase database;
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

        boolean isNetwork = NetWorkUtils.isNetworkAvailable(getSystemService(Context.CONNECTIVITY_SERVICE));

        if(isNetwork){
            // Read from the database
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference(SONG);
            withNetWorkCase(idSong);
        }else {

            withNoNetWorkCase(idSong);
        }

    }

    private void withNoNetWorkCase(int idSong) {
        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        Cursor c = myDatabase.getSong(idSong);

        int id = c.getInt(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
        String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
        String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));


        songTitle=id+" "+songTitle;
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

        String textSong = child.getValue(Song.class).getTextSong();
        String nameSong = child.getValue(Song.class).getNameSong();
        int id = child.getValue(Song.class).getId();

        nameSong = id+" "+nameSong;
        textViewSongTitle.setText(nameSong);
        textViewSongText.setText(textSong);
    }


}
