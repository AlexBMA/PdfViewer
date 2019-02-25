package com.example.alexandru.pdf.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.adapter.SongAdapter;
import com.example.alexandru.pdf.adapter.TestOnClick;
import com.example.alexandru.pdf.constant.AppConstant;
import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
import com.example.alexandru.pdf.dbpack.MyDatabase;
import com.example.alexandru.pdf.model.Song;

import java.util.LinkedList;
import java.util.List;

public class SongsYouths extends AppCompatActivity {

    ListView listView;
    SearchManager searchManager;
    SearchView searchView;
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

        /*
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = findViewById(R.id.search_view_youth);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                int size = listSongs.size();
                List<Integer> listIndex = new LinkedList<>();

                s = s.toLowerCase();
                for(int i=0;i<size;i++) {
                    String currentSongTitle = listSongs.get(i).getNameSong().toLowerCase();
                    if(s.contains(currentSongTitle)){
                        listIndex.add(i);
                    }
                }

                if(!listIndex.isEmpty()){
                    List<com.example.alexandru.pdf.model.Song> listSongFilter = new LinkedList<>();

                    for(Integer index : listIndex){
                        listSongFilter.add(listSongs.get(index));
                    }

                    SongAdapter songAdapter = new SongAdapter(SongsYouths.this,listSongFilter);
                    listView.setAdapter(songAdapter);
                    return true;
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                //TODO
                // You can optimize more with make all the song names lower case and make a new field in the song class
                int size = listSongs.size();
                //int index =-1;
                List<Integer> listIndex = new LinkedList<>();
                s = s.toLowerCase();
                for(int i=0;i<size;i++){
                    String currentSongTitle = listSongs.get(i).getNameSong().toLowerCase();

                    if(currentSongTitle.contains(s)){
                        //index = i;
                        listIndex.add(i);
                    }

                }

                if(!listIndex.isEmpty()){
                    List<com.example.alexandru.pdf.model.Song> listSongFilter = new LinkedList<>();

                    for(Integer index : listIndex){
                        listSongFilter.add(listSongs.get(index));
                    }

                    SongAdapter songAdapter = new SongAdapter(SongsYouths.this,listSongFilter);
                    listView.setAdapter(songAdapter);
                    return true;
                }


                return false;
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                int size = listSongs.size();
                List<Integer> listIndex = new LinkedList<>();

                s = s.toLowerCase();
                for(int i=0;i<size;i++) {
                    String currentSongTitle = listSongs.get(i).getNameSong().toLowerCase();
                    if(s.contains(currentSongTitle)){
                        listIndex.add(i);
                    }
                }

                if(!listIndex.isEmpty()){
                    List<com.example.alexandru.pdf.model.Song> listSongFilter = new LinkedList<>();

                    for(Integer index : listIndex){
                        listSongFilter.add(listSongs.get(index));
                    }

                    SongAdapter songAdapter = new SongAdapter(SongsYouths.this,listSongFilter);
                    listView.setAdapter(songAdapter);
                    return true;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //TODO
                // You can optimize more with make all the song names lower case and make a new field in the song class
                int size = listSongs.size();
                //int index =-1;
                List<Integer> listIndex = new LinkedList<>();
                s = s.toLowerCase();
                for(int i=0;i<size;i++){
                    String currentSongTitle = listSongs.get(i).getNameSong().toLowerCase();

                    if(currentSongTitle.contains(s)){
                        //index = i;
                        listIndex.add(i);
                    }

                }

                if(!listIndex.isEmpty()){
                    List<com.example.alexandru.pdf.model.Song> listSongFilter = new LinkedList<>();

                    for(Integer index : listIndex){
                        listSongFilter.add(listSongs.get(index));
                    }

                    SongAdapter songAdapter = new SongAdapter(SongsYouths.this,listSongFilter);
                    listView.setAdapter(songAdapter);
                    return true;
                }
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

    public void createDataFromCursor(Cursor c){
        listSongs = new LinkedList<>();
        //int i=1;

        do{
            int index = c.getInt(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
            String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
            //String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));
            //String songCategory = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_song_category));

            listSongs.add(new com.example.alexandru.pdf.model.Song(index,songTitle,"",""));
        }while (c.moveToNext());

        /*
        while (c.moveToNext()){
            int index = c.getInt(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
            String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
            //String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));
            //String songCategory = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_song_category));

            listSongs.add(new com.example.alexandru.pdf.model.SongActivity(index,songTitle,"",""));
            //i++;
        }
        */

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


    public void createDummyData(){
        listSongs = new LinkedList<>();

        listSongs.add(new com.example.alexandru.pdf.model.Song(1,"Maretul har","stext1","category1"));
        listSongs.add(new com.example.alexandru.pdf.model.Song(2,"Victoria in Isus","stext2","category1"));
        listSongs.add(new com.example.alexandru.pdf.model.Song(3,"Tata noi vrem ca slava Ta","stext3","category1"));
        listSongs.add(new com.example.alexandru.pdf.model.Song(5,"Nu exista cruce fara iesle","stext3","category1"));
        listSongs.add(new com.example.alexandru.pdf.model.Song(6,"Victoria in Isus 2","stext5","category1"));
        listSongs.add(new com.example.alexandru.pdf.model.Song(7,"O noua zi","stext6","category1"));
    }

    private void simpleTestForListView(ListView listView) {
        // define the values
        String[] values={"text1","text2","text3","text4","text5","text6","text7","text8","text9","text10"};

        // make the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // set the adapter
        listView.setAdapter(adapter);

        // set the listener
        listView.setOnItemClickListener(new TestOnClick(getApplicationContext(),listView));
    }


}
