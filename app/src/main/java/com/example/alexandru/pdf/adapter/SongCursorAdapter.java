package com.example.alexandru.pdf.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;

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


        int id = cursor.getInt(cursor.getColumnIndex(SongsAppTables.SongsTable.COLUMN_ID));
        TextView textViewIndex = view.findViewById(R.id.text_view_song_id_item);
        textViewIndex.setText(id);

        String name = cursor.getString(cursor.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
        TextView textViewTitle = view.findViewById(R.id.text_view_song_title_item);
        textViewTitle.setText(name);

    }
}
