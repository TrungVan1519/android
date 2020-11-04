package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.adapter.ImgAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        setDataForDataGridView();
    }

    private void setDataForDataGridView(){
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.ic_westeros);
        images.add(R.drawable.ic_exit);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.maxresdefault);
        images.add(R.drawable.min_nghi1);
        images.add(R.drawable.min_nghi5);
        images.add(R.drawable.ic_launcher_foreground);

        ImgAdapter adapter = new ImgAdapter(this,
                R.layout.layout_for_item_in_gridview,
                images);

        GridView grv = this.findViewById(R.id.grvImgage);
        grv.setAdapter(adapter);
    }
}
