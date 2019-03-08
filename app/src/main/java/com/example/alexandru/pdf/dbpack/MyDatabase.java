package com.example.alexandru.pdf.dbpack;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "songs.db";
    private static final int DATABASE_VERSION = 1;

    private static SQLiteDatabase db;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

    }

    public Cursor getSongs() {
        db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(SongsAppTables.SongsTable.TABLE_NAME);
        Cursor c = qb.query(db, null, null, null, null, null, null);

        c.moveToFirst();
        return c;
    }

    public Cursor getSongsNamesAndId(){
        db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {SongsAppTables.SongsTable.COLUMN_ID,
                               SongsAppTables.SongsTable.COLUMN_SONG_TITLE,
                               SongsAppTables.SongsTable.COLUMN_SONG_TITLE_NO_ROM};

        qb.setTables(SongsAppTables.SongsTable.TABLE_NAME);

        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
        c.moveToFirst();

        return c;
    }

    public Cursor getSong(int id){
        db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(SongsAppTables.SongsTable.TABLE_NAME);
        String selection = SongsAppTables.SongsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {id + ""};

        Cursor c = qb.query(db, null, selection, selectionArgs, null, null, null);
        c.moveToFirst();

        return c;

    }
}
