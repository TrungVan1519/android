package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    ListView lvItem;
    TextView txtDes;
    AssetManager assetManager;
    String[] fonts;
    String chosenFont;

    private void setControls() {
        txtDes = this.findViewById(R.id.txtDes);
        lvItem = this.findViewById(R.id.lvItem);
        try {
            setDataForListView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDataForListView() throws IOException {
        assetManager = this.getAssets();
        fonts = assetManager.list ("font");

        ArrayAdapter<String> fontList = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, fonts);

        lvItem.setAdapter(fontList);

        loadAppStatus();
    }

    private void setEvents(){
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Typeface typeface = Typeface.createFromAsset(getAssets(),
                        "font/" + fonts[position]);
                txtDes.setTypeface(typeface);

                chosenFont = "font/" + fonts[position];
            }
        });

        this.findViewById(R.id.btnSaveStatus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAppStatus();
            }
        });
    }

    private void saveAppStatus(){
        SharedPreferences preferences = this.getSharedPreferences("saving", MODE_PRIVATE);
        // > SharedPreferences tao ra File Save luu lai du lieu trong App
        //      + Neu File chua ton tai thi se duoc tao
        //      + Neu File da ton tai thi se bi ghi de
        // > "saving" la ten File Save: saving.xml
        // > Che do MODE_PRIVATE la chi su dung trong App

        // Luu du lieu vao File Save "saving.xml"
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("chosenFont", chosenFont);
        editor.commit();
        // > Editor viet lai tung du lieu muon luu trong App vao File Save da tao o tren
        // > editor.commit(); dung de xac nhan luu File Save

        Toast.makeText(MainActivity.this, "Successful",
                Toast.LENGTH_LONG).show();
    }

    private void loadAppStatus(){
        SharedPreferences preferences = this.getSharedPreferences("saving", MODE_PRIVATE);

        // Lay lai du lieu trong File Save "saving.xml"
        String chosenFont = preferences.getString("chosenFont", "notFound");

        if (chosenFont.compareToIgnoreCase("notFound") == 0){
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        } else {
            if (chosenFont.length() > 0){
                Typeface typeface = Typeface.createFromAsset(this.getAssets(), chosenFont);
                txtDes.setTypeface(typeface);
                Toast.makeText(this, chosenFont, Toast.LENGTH_LONG).show();
            }
        }
    }
}
