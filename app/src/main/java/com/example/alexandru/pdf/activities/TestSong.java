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


        songText.setText(songTextStringBuilder.toString());

    }

    public void increaseZoom(View view){
        float textSize = songText.getTextSize();
        Log.e("FONT_SIZE_PLUS",  textSize+"");
        //songText.setTextSize(textSize+0.5f);
        songText.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize+0.1f);

        Log.e("FONT_SIZE_PLUS",  textSize+0.5f+"");
    }


}
