package com.example.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

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

    TabHost tabHost;
    EditText txtFirstNumber, txtSecondNumber;
    ListView lvHistory;
    List<String> history;
    ArrayAdapter<String> adapter;

    private void setControls() {
        setTabHost();
        setListView();
        txtFirstNumber = this.findViewById(R.id.txtFirstNumber);
        txtSecondNumber = this.findViewById(R.id.txtSecondNumber);
    }

    private void setTabHost(){
        tabHost = this.findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("1. Sum");
        // > Chi them noi dung cho tieu de tab
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("", this.getResources().getDrawable(R.drawable.date));
        // > Chi them anh cho tieu de tab
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);
    }

    private void setListView(){
        history = new ArrayList<>();

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, history);

        lvHistory = this.findViewById(R.id.lvHistory);
        lvHistory.setAdapter(adapter);
    }

    private void setEvents() {
        this.findViewById(R.id.btnSum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(txtFirstNumber.getText().toString());
                int secondNumber = Integer.parseInt(txtSecondNumber.getText().toString());
                int result = firstNumber + secondNumber;

                Toast.makeText(MainActivity.this,
                        "Result: " + result, Toast.LENGTH_SHORT).show();

                history.add(result + "");
                adapter.notifyDataSetChanged();
            }
        });
    }
}
