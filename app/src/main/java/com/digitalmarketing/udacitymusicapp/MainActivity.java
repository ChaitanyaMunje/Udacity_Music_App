package com.digitalmarketing.udacitymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);
        ArrayList<Category> categories=new ArrayList<Category>();
        categories.add(new Category("Hindi Songs",R.drawable.ic_balalaika));
        categories.add(new Category("English Songs",R.drawable.ic_drum));
        categories.add(new Category("Punjabi Songs",R.drawable.ic_guitar));
        categories.add(new Category("Marathi Songs",R.drawable.ic_headphones));
        categories.add(new Category("Bengali Songs",R.drawable.ic_piano));
        categories.add(new Category("Marwadi Songs",R.drawable.ic_speaker));
        categories.add(new Category("Gujrathi Songs",R.drawable.ic_trumpet));
        categories.add(new Category("Artists",R.drawable.ic_turntable));
        categories.add(new Category("Bollywood Hits",R.drawable.ic_violin));
        categories.add(new Category("Hip Hop",R.drawable.ic_xylophone));
        CategoryAdapter categoryAdapter=new CategoryAdapter(this,categories);

        gridView.setAdapter(categoryAdapter);



    }
}
