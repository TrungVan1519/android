package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.custom_adapter.CityAdapter;
import com.example.model.City;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rcv = findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//
//        ArrayList<City> cities = new ArrayList<>();
//        cities.add(new City("1 ",R.drawable.america));
//        cities.add(new City("1 ",R.drawable.america));
//        cities.add(new City("1 ",R.drawable.america));
//        CityAdapter adapter = new CityAdapter(this,cities);
//        rcv.setLayoutManager(layoutManager);
//        rcv.setAdapter(adapter);
        setControls();
        setEvents();
    }


    private void setDataForRecyclerView() {
        // Lay ra tu res/values/strings.xml
        String[] cityNames = this.getResources().getStringArray(R.array.cities);
        // Lay anh tu res/drawable
        List<Integer> idImages = new ArrayList<>();
        idImages.add(R.drawable.america);
        idImages.add(R.drawable.china);
        idImages.add(R.drawable.vietnam);
        // Merge thanh du lieu nguon
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < idImages.size(); i++){
            cities.add(new City(cityNames[i], idImages.get(i)));
        }

        CityAdapter adapter = new CityAdapter(this,
                R.layout.template_item_recycleview,
                cities);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                                                            LinearLayoutManager.VERTICAL,
                                                            false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setControls() {
        recyclerView = this.findViewById(R.id.recyclerView);

        setDataForRecyclerView();
    }

    private void setEvents() {
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Blah blah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
