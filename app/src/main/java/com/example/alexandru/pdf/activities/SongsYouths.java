package com.example.alexandru.pdf.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.adapter.SongAdapter;
import com.example.alexandru.pdf.adapter.TestOnClick;
import com.example.alexandru.pdf.model.Song;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

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

        createDummyData();

        //simpleTestForListView(listView);
        mediumTestForListView(listView);


        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        searchView = findViewById(R.id.search_view_youth);
        //searchView = (SearchView) searchMenuItem.getActionView();

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
                    List<Song> listSongFilter = new LinkedList<>();

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
                    List<Song> listSongFilter = new LinkedList<>();

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


    }

    public void createDummyData(){
        listSongs = new LinkedList<>();

        listSongs.add(new Song(1,"Maretul har","stext1","category1"));
        listSongs.add(new Song(2,"Victoria in Isus","stext2","category1"));
        listSongs.add(new Song(3,"Tata noi vrem ca slava Ta","stext3","category1"));
        listSongs.add(new Song(5,"Nu exista cruce fara iesle","stext3","category1"));
        listSongs.add(new Song(6,"Victoria in Isus 2","stext5","category1"));
        listSongs.add(new Song(7,"O noua zi","stext6","category1"));
    }

    public void mediumTestForListView(ListView listView){




        SongAdapter songAdapter = new SongAdapter(this,listSongs);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(SongsYouths.this,TestSong.class);
                startActivity(intent);
            }
        });

        listView.setAdapter(songAdapter);
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
