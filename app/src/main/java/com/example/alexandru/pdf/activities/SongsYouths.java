package com.example.alexandru.pdf.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.adapter.SongAdapter;
import com.example.alexandru.pdf.constant.AppConstant;
import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
import com.example.alexandru.pdf.dbpack.MyDatabase;
import com.example.alexandru.pdf.model.Song;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
import java.util.List;

public class SongsYouths extends AppCompatActivity {

    ListView listView;
    List<Song> listSongs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_youths);

        // get the list view
        listView = findViewById(R.id.list_view_songs_youths);

        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        Cursor cursor = myDatabase.getSongsNamesAndId();

        createDataFromCursor(cursor);

        //simpleTestForListView(listView);
        mediumTestForListView(listView);


        //Cursor allSongs = myDatabase.getSongs();
        //saveAllDataToFireBase(allSongs);

    }

    private void saveAllDataToFireBase(Cursor allSongs) {

        listSongs = new LinkedList<>();

        do{
            int index = allSongs.getInt(allSongs.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
            String songTitle = allSongs.getString(allSongs.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
            String songTitleNoRom = allSongs.getString(allSongs.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE_NO_ROM));
            String songText = allSongs.getString(allSongs.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));
            String songCategory = allSongs.getString(allSongs.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_CATEGORY));

            Song song = new Song(index, songTitle, songText, songCategory, songTitleNoRom);
            listSongs.add(song);
        }while (allSongs.moveToNext());

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("song");

        myRef.setValue(listSongs);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String song) {
                return searchSong(song);
            }

            @Override
            public boolean onQueryTextChange(String song) {
                return searchSong(song);
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

    private boolean searchSong(String song) {
        int size = listSongs.size();
        List<Integer> listIndex = new LinkedList<>();
        searchForSong(song, size, listIndex);

        if (!listIndex.isEmpty()) {
            return populateView(listIndex);
        }
        return false;
    }

    private void searchForSong(String song, int size, List<Integer> listIndex) {
        song = song.toLowerCase();
        for (int i = 0; i < size; i++) {
            String currentSongTitle = listSongs.get(i).getNameSongNoRom();
            if (currentSongTitle.contains(song)) {
                listIndex.add(i);
            }
        }
    }

    private boolean populateView(List<Integer> listIndex) {
        List<Song> listSongFilter = new LinkedList<>();

        for (Integer index : listIndex) {
            listSongFilter.add(listSongs.get(index));
        }

        SongAdapter songAdapter = new SongAdapter(SongsYouths.this, listSongFilter);
        listView.setAdapter(songAdapter);
        return true;
    }

    public void createDataFromCursor(Cursor c){
        listSongs = new LinkedList<>();

        do{
            int index = c.getInt(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
            String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
            String songTitleNoRom = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE_NO_ROM));
            //String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));
            //String songCategory = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_CATEGORY));

            Song song = new Song(index, songTitle, "", "", songTitleNoRom);
            listSongs.add(song);
        }while (c.moveToNext());

    }


    public void mediumTestForListView(final ListView listView){

        SongAdapter songAdapter = new SongAdapter(this,listSongs);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(SongsYouths.this, SongActivity.class);

                Song temp = (Song) listView.getItemAtPosition(position);
                //listItemModel.toString();

                intent.putExtra(AppConstant.ID_SONG,temp.getId());
                startActivity(intent);
            }
        });

        listView.setAdapter(songAdapter);
    }


}
