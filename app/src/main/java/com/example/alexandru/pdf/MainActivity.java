package com.example.alexandru.pdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.alexandru.pdf.activities.TestSong;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.button_test);
    }

    public void next(View view){
        Intent intent = new Intent(MainActivity.this, TestSong.class);

        startActivity(intent);
    }
}
