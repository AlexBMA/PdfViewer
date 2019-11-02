package com.example.alexandru.pdf.listener;

import android.support.annotation.NonNull;

import com.example.alexandru.pdf.adapter.SongAdapter;
import com.example.alexandru.pdf.model.Song;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ValueEventListenerForSongsYouthActivity implements ValueEventListener {
    private  List<Song> listSongs;
    private SongAdapter songAdapter;

    public ValueEventListenerForSongsYouthActivity(List<Song> listSongs, SongAdapter songAdapter) {
        this.listSongs = listSongs;
        this.songAdapter = songAdapter;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        getDataFromFireBase(dataSnapshot,songAdapter);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    private void getDataFromFireBase(@NonNull DataSnapshot dataSnapshot, SongAdapter songAdapter) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Song songFromFireBase = ds.getValue(Song.class);
            listSongs.add(songFromFireBase);
            songAdapter.add(songFromFireBase);
        }

    }
}
