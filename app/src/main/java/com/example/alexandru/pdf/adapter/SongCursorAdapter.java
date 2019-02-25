package com.example.alexandru.pdf.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import com.example.alexandru.pdf.R;

public class SongCursorAdapter extends CursorAdapter {

    public SongCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_song_item, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


    }
}
