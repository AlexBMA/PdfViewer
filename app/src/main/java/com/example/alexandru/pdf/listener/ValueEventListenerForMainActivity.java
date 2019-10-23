package com.example.alexandru.pdf.listener;

import android.support.annotation.NonNull;

import com.example.alexandru.pdf.dbpack.MyDatabase;
import com.example.alexandru.pdf.model.Song;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ValueEventListenerForMainActivity implements ValueEventListener {

    private List<Song> listSongs;
    private MyDatabase myDatabase;


    public ValueEventListenerForMainActivity(List<Song> listSongs, MyDatabase myDatabase) {
        this.listSongs = listSongs;
        this.myDatabase = myDatabase;
    }

    public ValueEventListenerForMainActivity(List<Song> listSongs) {
        this.listSongs = listSongs;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot ds: dataSnapshot.getChildren()){
            Song song = new Song();
            song.setId(ds.getValue(Song.class).getId());
            song.setNameSong(ds.getValue(Song.class).getNameSong());
            song.setNameSongNoRom(ds.getValue(Song.class).getNameSongNoRom());
            song.setTextSong(ds.getValue(Song.class).getTextSong());
            song.setCategorySong(ds.getValue(Song.class).getCategorySong());
            listSongs.add(song);
        }
        myDatabase.deleteDataAndUpdateDatabase(listSongs);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    public List<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(List<Song> listSongs) {
        this.listSongs = listSongs;
    }
}
