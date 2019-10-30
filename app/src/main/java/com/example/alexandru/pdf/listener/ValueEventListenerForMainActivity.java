package com.example.alexandru.pdf.listener;

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
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
        long childrenCount = dataSnapshot.getChildrenCount() - 1;
        DataSnapshot child = dataSnapshot.child("/" + childrenCount);

        Song lastSongFromFireBase = child.getValue(Song.class);
        int idLastSongFireBase = lastSongFromFireBase.getId();

        Cursor lastSongInDB = myDatabase.getSong((int) childrenCount);
        int idColumnIndex = lastSongInDB.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID);
        int idLastSongLocalDatabase = lastSongInDB.getInt(idColumnIndex);

        if (idLastSongFireBase != idLastSongLocalDatabase) {
            updateLocalDatabaseWithFireBaseData(dataSnapshot);
        }

    }

    private void updateLocalDatabaseWithFireBaseData(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot ds: dataSnapshot.getChildren()){
            Song valueFromDatabase = ds.getValue(Song.class);
            listSongs.add(valueFromDatabase);
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
