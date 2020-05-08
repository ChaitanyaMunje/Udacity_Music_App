package com.digitalmarketing.udacitymusicapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<MusicItem> {


    public MusicAdapter(Activity context, ArrayList<MusicItem> musicItems){
        super(context,0,musicItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if (listitemview==null){
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.music_item,parent,false);

        }
        final MusicItem musicitem=getItem(position);
        final TextView music_name=listitemview.findViewById(R.id.music_name_txt);
        TextView artist_name=listitemview.findViewById(R.id.artist_name_txt);
        ImageView img=listitemview.findViewById(R.id.music_img);
        ImageButton playbtn=listitemview.findViewById(R.id.playbtn);
        music_name.setText(musicitem.getMusicname());
        artist_name.setText(musicitem.getArtistname());
        img.setImageResource(musicitem.getImgId());

        listitemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),MusicPlayerActivity.class);
                i.putExtra("music_name",musicitem.getMusicname());
                i.putExtra("artist_name",musicitem.getArtistname());
                i.putExtra("music",musicitem.getMusicurl());
                getContext().startActivity(i);
            }
        });

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),MusicPlayerActivity.class);
                i.putExtra("music_name",musicitem.getMusicname());
                i.putExtra("artist_name",musicitem.getArtistname());
                i.putExtra("music",musicitem.getMusicurl());
                getContext().startActivity(i);
            }
        });

        return listitemview;
    }
}
