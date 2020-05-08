package com.digitalmarketing.udacitymusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MusicPlayerActivity extends AppCompatActivity {
    TextView music_name,artist_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player2);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String musicname=getIntent().getStringExtra("music_name");
        String artist=getIntent().getStringExtra("artist_name");
        final String musicurl=getIntent().getStringExtra("music");
        music_name=findViewById(R.id.music_name);
        artist_name=findViewById(R.id.artist);
        music_name.setText(musicname);
        artist_name.setText(artist);
        ImageButton btnplay=findViewById(R.id.playbtn);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(musicurl)
                );
                Toast.makeText(MusicPlayerActivity.this, "Music is been played", Toast.LENGTH_SHORT).show();
                startActivity(i);

            }
        });
    }
}
