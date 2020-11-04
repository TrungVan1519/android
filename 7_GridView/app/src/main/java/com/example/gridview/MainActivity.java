package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.custom_adapter.CountryAdapter;
import com.example.model.Country;

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

    List<Country> countries;
    CountryAdapter adapter;
    GridView gridCountry;

    private void setDataForGridView(){
        countries = new ArrayList<>();
        countries.add(new Country("America", R.drawable.america));
        countries.add(new Country("Brazil", R.drawable.brazil));
        countries.add(new Country("Canada", R.drawable.canada));
        countries.add(new Country("China", R.drawable.china));
        countries.add(new Country("England", R.drawable.england));
        countries.add(new Country("Germany", R.drawable.germany));
        countries.add(new Country("India", R.drawable.india));
        countries.add(new Country("Indo", R.drawable.indo));
        countries.add(new Country("Japan", R.drawable.japan));
        countries.add(new Country("Korea", R.drawable.korea));
        countries.add(new Country("North Korea", R.drawable.north_korea));
        countries.add(new Country("Portugal", R.drawable.portugal));
        countries.add(new Country("Spain", R.drawable.spain));
        countries.add(new Country("VietNam", R.drawable.vietnam));
        countries.add(new Country("Thailand", R.drawable.thailand));
        countries.add(new Country("Greek", R.drawable.greek));
        countries.add(new Country("Laos", R.drawable.laos));

        adapter = new CountryAdapter(this,
                R.layout.template_item_gridview, countries);

        gridCountry.setAdapter(adapter);
    }

    private void setControls(){
        gridCountry = this.findViewById(R.id.gridCountry);
        setDataForGridView();
    }

    private void setEvents() {
        gridCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = countries.get(position);

                Toast.makeText(MainActivity.this,
                        "you add " + country.toString(),
                        Toast.LENGTH_SHORT).show();

                countries.add(new Country(country.toString(), country.getIdImage()));

                adapter.notifyDataSetChanged();
            }
        });
    }
}
