package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListView_DuLieuCoDinhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_dulieucodinh);
        getListView();
        setEventListView();
    }

    private String[] arrDate = null;
    private ListView lvResult = null;

    public void setEventListView(){
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView_DuLieuCoDinhActivity.this,
                            "Bạn chọn " + arrDate[position],
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getListView(){
        arrDate = getResources().getStringArray(R.array.date_of_week);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                                        android.R.layout.simple_list_item_1,
                                                        arrDate);
        lvResult = findViewById(R.id.lvResult);
        lvResult.setAdapter(adapter);

    }

    public void getResourcesData(){
        // Lay anh trong 2 folder res/drawable va res/mipmap
        Drawable imgFromFolderDrawable = getResources().getDrawable(R.drawable.ic_westeros);
        Drawable imgFromFolderMipmap = getResources().getDrawable(R.mipmap.ic_launcher);

        // Lay gia tri trong file res/values/colors.xml
        int color = getResources().getColor(R.color.colorAccent);
        int another = ContextCompat.getColor(this, R.color.colorAccent);

        // Lay gia tri trong file res/value/strings.xml
        String[] arrString = getResources().getStringArray(R.array.date_of_week);
        String varString = getResources().getString(R.string.app_name);

        int[] arrInt = getResources().getIntArray(R.array.arrInt);
        int varInt = getResources().getInteger(R.integer.varInt);
    }
}
