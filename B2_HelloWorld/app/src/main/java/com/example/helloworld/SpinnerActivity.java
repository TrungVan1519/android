package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.LinkedList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        setDataForSpinner();
    }

    private void setDataForSpinner() {
        List<String> dateOfWeek = new LinkedList<>();
        for (int i = 2; i <= 7; i++){
            dateOfWeek.add("Thứ " + i);
        }
        dateOfWeek.add("Chủ nhật");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                                    android.R.layout.simple_spinner_item,
                                                    dateOfWeek);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spDate = this.findViewById(R.id.spDate);
        spDate.setAdapter(adapter);
    }
}
