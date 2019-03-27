package com.example.alexandru.pdf.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.model.Song;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, List<Song> songs) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        // Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_song_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView textViewTitle = listItemView.findViewById(R.id.text_view_song_title_item);
        textViewTitle.setText(currentSong.getNameSong());


        TextView textViewIndex = listItemView.findViewById(R.id.text_view_song_id_item);
        //textViewIndex.setText("");
        textViewIndex.setText(Integer.toString(currentSong.getId()));

        return listItemView;
    }
}