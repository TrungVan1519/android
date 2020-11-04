package com.example.getresources_getassets;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getResourcesFromRes();
        getResourcesFromAssets();
    }

    private void getResourcesFromRes() {
        // 1.Lay ra anh trong res/drawable
        // 1.1.Lay ra 1 anh
        Drawable image = this.getResources().getDrawable(R.drawable.america);
        // 1.2.Lay toan bo danh sach anh
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.america);
        images.add(R.drawable.canada);
        images.add(R.drawable.china);
        images.add(R.drawable.england);
        images.add(R.drawable.spain);
        images.add(R.drawable.vietnam);

        // 2.Lay ra cac gia tri trong res/values
        // 2.1.Lay ra tu res/values/colors.xml
        int color1 = this.getResources().getColor(R.color.colorAccent);
        int color2 = ContextCompat.getColor(this, R.color.colorPrimary);
        // 2.2.Lay ra tu res/values/strings.xml
        // 2.2.1.Lay ra string
        String appName = this.getResources().getString(R.string.app_name);
        // 2.2.2.Lay ra int
        int number = this.getResources().getInteger(R.integer.number);
        // 2.2.3.Lay ra mang
        String[] season = this.getResources().getStringArray(R.array.season);
        int[] randomNum = this.getResources().getIntArray(R.array.random_number);

        // 3.Lay ra Layout tu res/layout: Xem ArrayAdapter<T> trong Spinner, ListView
        // 4.Lay ra cac Controls trong Layout_Activity: findViewById(R.id.tenControls)
    }

    private void getResourcesFromAssets() {
        AssetManager assetManager = this.getAssets();
        try {
            String[] fontList = assetManager.list("font");
            String[] audioList = assetManager.list("audio");
            String[] videoList = assetManager.list("video");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
