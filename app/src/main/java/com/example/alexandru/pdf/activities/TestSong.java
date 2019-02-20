package com.example.alexandru.pdf.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alexandru.pdf.R;

public class TestSong extends AppCompatActivity {

    private Button zoomPlus;
    private Button zoomMinus;
    private TextView songText;
    private TextView songTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_song);

        zoomMinus = findViewById(R.id.button_zoom_minus);
        zoomPlus = findViewById(R.id.button_zoom_plus);
        songText = findViewById(R.id.text_view_song);
        songTitle = findViewById(R.id.text_view_top);

        songTitle.setText("Măreţul har");

        String songTextString = "1. Măreţul har m-a mântuit\n" +
                "Pe mine din păcat.\n" +
                "Pierdut eram, dar m-a găsit,\n" +
                "De moarte m-a scăpat. \n";

        songTextString +="2. Măreţul har m-a învăţat\n" +
                "S-o rup cu orice rău.\n" +
                "Ce scump mi-e azi tot harul dat;\n" +
                "Trăiesc prin har mereu.\n \n";

        songTextString +="3. Dureri, batjocuri, prigoniri,\n" +
                "Adesea-m întâlnit;\n" +
                "Prin harul marii Lui Iubiri\n" +
                "Eu toate-am biruit. \n \n";

        songTextString +="4. Prin har ajunge-voi în cer\n" +
                "Cu slavă îmbrăcat,\n" +
                "Şi voi slăvi în veşnicii\n" +
                "Pe Cel ce har mi-a dat. \n ";

        songText.setText(songTextString);

    }

    public void increaseZoom(View view){
        float textSize = songText.getTextSize()-10;
        Log.e("FONT_SIZE_PLUS",  textSize+"");
        //songText.setTextSize(textSize+0.5f);
        songText.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize+0.5f);

        Log.e("FONT_SIZE_PLUS",  textSize+0.5f+"");
    }

    public void reduceZoom(View view) {
        float textSize = songText.getTextSize()-40;
        //textSize = textSize*-1;
        Log.e("FONT_SIZE_MINUS", textSize + "");
        songText.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        Log.e("FONT_SIZE_MINUS", textSize  + "");
    }
}
