package com.example.alexandru.pdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.alexandru.pdf.activities.SongsYouths;
import com.example.alexandru.pdf.activities.TestSong;

public class MainActivity extends AppCompatActivity {

    //ImageView imageView;
    Button songButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageView = findViewById(R.id.button_test);
        songButton = findViewById(R.id.button_song_tineri);


    }

    public void toSongTienri(View view){
        Intent intent = new Intent(MainActivity.this, SongsYouths.class);
        startActivity(intent);
    }

    public void next(View view){
        Intent intent = new Intent(MainActivity.this, TestSong.class);
        startActivity(intent);
    }
}
