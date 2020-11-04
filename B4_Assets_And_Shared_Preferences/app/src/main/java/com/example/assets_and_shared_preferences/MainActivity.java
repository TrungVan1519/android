package com.example.assets_and_shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupControls();
    }

    final String tenFileLuuTru = "TrangThaiFont";
    TextView txtSample;
    Spinner spinnerFont;
    ListView lvFont;
    private void setupControls() {
//        spinnerFont = this.findViewById(R.id.spinnerFont);
        txtSample = this.findViewById(R.id.txtSample);
        lvFont = this.findViewById(R.id.lvFont);

        // Lay du lieu trong Folder assets/font
        final List<String> data = new ArrayList<>();
        try {
            AssetManager assetManager = getAssets();
            String[] listFontName = assetManager.list("font");

            if (listFontName != null) {
                data.addAll(Arrays.asList(listFontName));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    data);

//            spinnerFont.setAdapter(adapter);
            lvFont.setAdapter(adapter);

            // Load lai trang thai da luu tru
            loadAppStatus(tenFileLuuTru);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        spinnerFont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Typeface typeface = Typeface.createFromAsset(MainActivity.this.getAssets(),
//                        "font/" + spinnerFont.getSelectedItem().toString());
//                // Neu su dung ListView thi se phai code nhu sau:
//                /*Typeface typeface = Typeface.createFromAsset(MainActivity.this.getAssets(),
//                        "font/" + varListView.get(position));*/
//                txtSample.setTypeface(typeface);
//
//                // Luu trang thai lai
//                saveAppStatus(tenFileLuuTru, "font/" + spinnerFont.getSelectedItem().toString());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

        lvFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Typeface typeface = Typeface.createFromAsset(MainActivity.this.getAssets(),
                        "font/" + data.get(position));
                txtSample.setTypeface(typeface);

                // Luu trang thai App
                saveAppStatus(tenFileLuuTru, "font/" + data.get(position));
            }
        });
    }

    private void saveAppStatus(String tenFileLuuTru, String chosenFont){
        SharedPreferences sharedPreferences = this.getSharedPreferences(tenFileLuuTru, MODE_PRIVATE);
        // > Khi luu trang thai cua App thi SharedPreferences se luu duoi dang 1 File *.xml, neu
        //      File da ton tai thi se bi ghi de, con chua ton tai thi se duoc khoi tao moi
        // > Ten File luu tru nay se lay theo cach sau:
        //      + Neu nhu khong truyen vao 1 String thi no se lay theo ten cua ham chua
        //          no (o day ta code trong MainActivity.java thi no se lay theo ten la MainActivity)
        //      + Neu truyen vao 1 String nhu TH nay thi File luu tru se lay ten do lam ten File
        //      (VD la "TrangThaiFont" thi ten File luu tru se la TrangThaiFont.xml)
        // > MODE_PRIVATE co ta dung chi su dung che do luu tru nay cho Activity nay thoi

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FONTCHU", chosenFont);
        editor.commit();
        // > Editor dung de viet lai du lieu cho File luu trang thai *.xml
        // > Cac du lieu se duoc luu lai duoi cac KeyWord, VD nhu ta luu lai 1 String font duoi dang
        //      KeyWord la "FONTCHU"
    }

    private void loadAppStatus(String tenFileLuuTru){
        SharedPreferences sharedPreferences = this.getSharedPreferences(tenFileLuuTru, MODE_PRIVATE);
        // > Khi luu trang thai bang File *.xml nao thi phai lay ra dung ten File luu trang thai do

        String choosenFont = sharedPreferences.getString("FONTCHU", "");
        // > Do Editor khi luu du lai se su dung cac KeyWord nen muon lay thu gi ra ta phai goi dung
        //      KeyWord do

        if (choosenFont.length() > 0){
            Typeface typeface = Typeface.createFromAsset(getAssets(), choosenFont);
            txtSample.setTypeface(typeface);
            Toast.makeText(this, choosenFont, Toast.LENGTH_LONG).show();
        }
    }
}
