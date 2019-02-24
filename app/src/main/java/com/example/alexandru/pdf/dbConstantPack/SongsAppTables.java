package com.example.alexandru.pdf.dbConstantPack;

import android.provider.BaseColumns;

public final class SongsAppTables {

    public abstract class SongsTable implements BaseColumns {

        public static final String COLUMN_ID = "Id";
        public static final String COLUMN_SONG_TITLE = "song_title";
        public static final String COLUMN_SONG_TEXT = "song_text";
        public static final String COLUMN_song_category = "song_category";
    }
}
