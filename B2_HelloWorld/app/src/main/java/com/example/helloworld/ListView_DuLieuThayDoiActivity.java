package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ListView_DuLieuThayDoiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__du_lieu_thay_doi);

        setDataToListView();
    }
    private void setDataToListView(){
        // Tao du lieu nguon
        final List<String> names = new LinkedList<>();
        // Them du lieu nguon vao ArrayAdapter<T>
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                        android.R.layout.simple_expandable_list_item_1,
                                        names);
        // Truyen ArrayAdapter<T> vao ListView
        ListView lvResult = findViewById(R.id.lvResult);
        lvResult.setAdapter(adapter);

        // Moi lan bam nut btnAdd thi du lieu tu txtName se tu dong them vao ListView
        final EditText txtName = findViewById(R.id.txtName);
        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cach 1: Them du lieu cho LinkedList roi update cho adapter
                names.add(txtName.getText().toString());
                adapter.notifyDataSetChanged();

                // Cach 2: Them du lieu luon cho adapter
                adapter.add(txtName.getText().toString());
            }
        });
    }
}
