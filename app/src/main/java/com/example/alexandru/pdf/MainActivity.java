package com.example.alexandru.pdf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alexandru.pdf.activities.SongsYouths;
import com.example.alexandru.pdf.dbpack.MyDatabase;
import com.example.alexandru.pdf.listener.ValueEventListenerForMainActivity;
import com.example.alexandru.pdf.model.Song;
import com.example.alexandru.pdf.utils.FireBaseDatabaseUtils;
import com.example.alexandru.pdf.utils.NetWorkUtils;
import com.google.firebase.database.DatabaseReference;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference myRef;
    private Button songButton;
    private List<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songButton = findViewById(R.id.button_song_tineri);

        boolean isNetwork = NetWorkUtils.isNetworkAvailable(getSystemService(Context.CONNECTIVITY_SERVICE));

        ValueEventListenerForMainActivity listener;
        if (isNetwork) {
            myRef = FireBaseDatabaseUtils.getDatabaseConn();

            songs = new LinkedList<>();
            MyDatabase myDatabase = new MyDatabase(getApplicationContext());

            listener = new ValueEventListenerForMainActivity(songs, myDatabase);
            myRef.addValueEventListener(listener);
        } else {

            Context context = getApplicationContext();
            CharSequence text = "Nu exista conexsiune la internet,\n cantarile nu sunt actualizate.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }


    }

    public void toSongYouths(View view){
        Intent intent = new Intent(MainActivity.this, SongsYouths.class);
        startActivity(intent);
    }

}
