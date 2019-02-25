package com.example.alexandru.pdf.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.alexandru.pdf.R;
import com.example.alexandru.pdf.constant.AppConstant;
import com.example.alexandru.pdf.dbConstantPack.SongsAppTables;
import com.example.alexandru.pdf.dbpack.MyDatabase;

public class SongActivity extends AppCompatActivity {


    //private Button zoomPlus;
    private TextView textViewSongText;
    private TextView textViewSongTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);


        //zoomPlus = findViewById(R.id.button_zoom_plus);
        textViewSongText = findViewById(R.id.text_view_song);
        textViewSongTitle = findViewById(R.id.text_view_top);

        //StringBuilder songTextStringBuilder = justATest();
        //textViewSongText.setText(songTextStringBuilder.toString());

        Intent intent = getIntent();

        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        //Log.e("Value from intent: ",intent.getIntExtra(AppConstant.ID_SONG,0)+"");
        Cursor c = myDatabase.getSong(intent.getIntExtra(AppConstant.ID_SONG,0));

        String songTitle = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TITLE));
        String songText = c.getString(c.getColumnIndex(SongsAppTables.SongsTable.COLUMN_SONG_TEXT));

        //Log.e("Title:",  songTitle);
        //Log.e("SongActivity:",songText);

        textViewSongTitle.setText(songTitle);
        textViewSongText.setText(songText);

    }
    /*
    private StringBuilder justATest() {
        textViewSongTitle.setText("Măreţul har");

        StringBuilder songTextStringBuilder = new StringBuilder();
        songTextStringBuilder.append("\"1. Măreţul har m-a mântuit \n \"").
                              append("Pe mine din păcat.\n").
                              append("Pierdut eram, dar m-a găsit,\n").
                              append( "De moarte m-a scăpat. \n \n").
                              append("2. Măreţul har m-a învăţat\n\"").
                              append( "S-o rup cu orice rău.\n").
                              append("Ce scump mi-e azi tot harul dat;\n").
                              append("Trăiesc prin har mereu.\n \n").
                              append("3. Dureri, batjocuri, prigoniri,\n").
                              append("S-o rup cu orice rău.\n").
                              append("Ce scump mi-e azi tot harul dat;\n").
                              append("Trăiesc prin har mereu.\n \n").
                              append("3. Dureri, batjocuri, prigoniri,\n").
                              append("Adesea-m întâlnit;\n").
                              append("Prin harul marii Lui Iubiri\n").
                              append("Eu toate-am biruit. \n \n").
                              append("4. Prin har ajunge-voi în cer\n").
                              append("Cu slavă îmbrăcat,\n").
                              append("Şi voi slăvi în veşnicii\n").
                              append("Pe Cel ce har mi-a dat. \n");
        return songTextStringBuilder;
    }
    */
    /*
    public void increaseZoom(View view){
        float textSize = textViewSongText.getTextSize()-30;
        Log.e("FONT_SIZE_PLUS",  textSize+"");
        //textViewSongText.setTextSize(textSize+0.5f);
        textViewSongText.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize+ ZOOM_INCREASE);

        Log.e("FONT_SIZE_PLUS",  textSize+ZOOM_INCREASE+"");
    }
    */

}
