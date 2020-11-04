package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.custom_adapter.MyAdapter;
import com.example.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    Spinner spCities;

    private void setDataForSpinner(){
        // Lay String trong res/values/strings.xml
        String[] cities = this.getResources().getStringArray(R.array.cities);
        // Lay id anh trong res/drawable
        List<Integer> idImage = new ArrayList<>();
        idImage.add(R.drawable.america);
        idImage.add(R.drawable.china);
        idImage.add(R.drawable.vietnam);
        // Merge 2 cai tren thanh 1 List<Item>
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < cities.length; i++){
            items.add(new Item(cities[i], idImage.get(i)));
        }

        MyAdapter adapter = new MyAdapter(this,
                                        R.layout.template_spinner,
                                        items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCities.setAdapter(adapter);
    }

    private void setControls() {
        spCities = this.findViewById(R.id.spCities);
        setDataForSpinner();
    }

    private void setEvents() {
        spCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        getResources().getStringArray(R.array.cities)[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
