package com.digitalmarketing.udacitymusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import static java.security.AccessController.getContext;

public class Music extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);
        listView=findViewById(R.id.listview);
        //getmusic();
         ArrayList<MusicItem>musicItems=new ArrayList<MusicItem>();
        musicItems.add(new MusicItem("Aankh Mare","Mika, Neha Kakkar, Kumar Sanu",R.drawable.ic_music,"https://www.youtube.com/watch?v=_KhQT-LGb-4"));
        musicItems.add(new MusicItem("Bandeya Re Bandeya","Arjit Singh, Asees Kaur",R.drawable.ic_music,"https://www.youtube.com/watch?v=Wj8C_bpnkTY"));
        musicItems.add(new MusicItem("Tere Bin","Tanishk B, Asees K",R.drawable.ic_music,"https://www.youtube.com/watch?v=aeNq_hB9TXI"));
        musicItems.add(new MusicItem("Mera Wala Dance","Neha Kakkar, Nakash A",R.drawable.ic_music,"https://www.youtube.com/watch?v=37GPUFucjxE"));
        musicItems.add(new MusicItem("Hud Hud","Sajid Wajid, Divya K ",R.drawable.ic_music,"https://www.youtube.com/watch?v=D6AZzOIO7wE"));
        musicItems.add(new MusicItem("Awara","Sajid Wajid",R.drawable.ic_music,"https://www.youtube.com/watch?v=KM4Q0H3UTfc"));
        musicItems.add(new MusicItem("Yu Karke","Payal Yadav, Sajid Wajid ",R.drawable.ic_music,"https://www.youtube.com/watch?v=jWpGP8_aAVk"));
        MusicAdapter adapter=new MusicAdapter(this,musicItems);
        listView.setAdapter(adapter);


    }

    private void getmusic(){
        // to get songs from users device...
        ContentResolver contentResolver= Objects.requireNonNull(this.getContentResolver());
        Uri songuri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor=contentResolver.query(songuri,null,null,null,null);
        if (cursor !=null && cursor.moveToNext()){
            int songtitle=cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int artist=cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            //int pic=cursor.getColumnIndex(MediaStore.Audio.Media.VOLUME_NAME);
            ArrayList<MusicItem> list=new ArrayList<>();
            do {

                String currenttitle=cursor.getString(songtitle);
                String currartist=cursor.getString(artist);
//                String vol=cursor.getString(pic);

                list.add(new MusicItem(currenttitle,currartist,R.drawable.ic_music,"http://www.google.com"));
                MusicAdapter musicAdapter=new MusicAdapter(this,list);
                listView.setAdapter(musicAdapter);




            }
            while (cursor.moveToNext());
        }
    }


}
