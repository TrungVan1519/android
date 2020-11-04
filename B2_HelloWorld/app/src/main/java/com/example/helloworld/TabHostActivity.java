package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TabHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        getControls();
//        setupTabHost();
    }

    TabHost tabHost;
    EditText txtFirstNum, txtSecondNum;
    Button btnExecute;
    ListView lvHistory;

    private void setupTabHost() {
        getControls();
        getEvents();
    }

    private void getEvents() {
    }

    private void getControls() {
        tabHost = this.findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setIndicator("1.Phép cộng");
        tab1.setIndicator("", this.getResources().getDrawable(R.drawable.date));
        // => Hien thi hinh cho Tab
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("2.Lịch sử");
        // => Hien thi chu cho Tab
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        txtFirstNum = this.findViewById(R.id.txtFirstNum);
        txtSecondNum = this.findViewById(R.id.txtSecondNum);
        btnExecute = this.findViewById(R.id.btnExecute);
        lvHistory = this.findViewById(R.id.lvHistory);

        final List<String> history = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, history);
        lvHistory.setAdapter(adapter);

        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNum = Integer.parseInt(txtFirstNum.getText().toString());
                int secondNum = Integer.parseInt(txtSecondNum.getText().toString());

                String result = (firstNum + secondNum) + "";

                history.add(result);
                adapter.notifyDataSetChanged();
            }
        });
    }


}
