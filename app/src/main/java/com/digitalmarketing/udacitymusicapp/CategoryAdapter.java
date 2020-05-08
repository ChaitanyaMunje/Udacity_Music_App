package com.digitalmarketing.udacitymusicapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {

public CategoryAdapter(Activity context, ArrayList<Category> categories){
    super(context,0,categories);
}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if (listitemview==null){
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.music_category,parent,false);

        }
        final Category category=getItem(position);
        TextView categorytxt=listitemview.findViewById(R.id.category_txt);
        categorytxt.setText(category.getMusiccategory());

        ImageView img=listitemview.findViewById(R.id.music_category_img);
        listitemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),Music.class);
                getContext().startActivity(i);

            }
        });
        img.setImageResource(category.getImageid());
        listitemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),Music.class);
                getContext().startActivity(i);

            }
        });
        return listitemview;

    }
}
