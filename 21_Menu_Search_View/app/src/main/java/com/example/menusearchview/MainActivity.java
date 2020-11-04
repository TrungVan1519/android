package com.example.menusearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
    }

    List<String> countries;
    ArrayAdapter<String> adapter;
    ListView lvCountry;
    private void setControls() {
        lvCountry = this.findViewById(R.id.lvCountry);
        setDataForListView();
    }

    private void setDataForListView() {
        countries = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            countries.add("Nation: " + i);
        }
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, countries);
        lvCountry.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.template_menu_search_view, menu);

        MenuItem menuSearch = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) menuSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Xay ra sau khi ta bam xac nhan tim kiem
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,
                        "Search: " + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            // Xay ra khi ta thay doi Text tim kiem
            @Override
            public boolean onQueryTextChange(String newText) {
                // Loc du lieu trong ArrayAdapter<T>
                adapter.getFilter().filter(newText);
                // > Do code trong ham nay nen ta se duoc:
                //      Tu dong loc de hien thi du lieu khi users nhap tim kiem
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
