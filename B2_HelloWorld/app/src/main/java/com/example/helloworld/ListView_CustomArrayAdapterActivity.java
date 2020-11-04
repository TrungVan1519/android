package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.UsersAdapter;
import com.example.model.User;

import java.util.ArrayList;

public class ListView_CustomArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__custom_array_adapter);

        setDataForListView();

    }

    private void setDataForListView() {
//        // Tao du lieu nguon
//        ArrayList<DanhBa> danhBaList = new ArrayList<>();
//        for (int i = 0; i < 5; i++){
//            danhBaList.add(new DanhBa(i, "Người thứ " + i, i));
//        }
//
//        // Su dung CustomAdapter thay vi su dung ArrayAdapter<T> cua he thong
//        DanhBaAdapter adapter = new DanhBaAdapter(this,
////                                        R.layout.list_view_with_custom_arrayadapter,
//                                        danhBaList);
//
//        // Truyen du lieu tu CustomAdapter cho ListView
//        ListView lvResult = this.findViewById(R.id.lvDanhBa);
//        lvResult.setAdapter(adapter);
        // Construct the data source
        ArrayList<User> arrayOfUsers = new ArrayList<User>();
        for (int i = 0; i < 5; i++){
            arrayOfUsers.add(new User("abc", "123"));
        }


// Create the adapter to convert the array to views
        UsersAdapter adapter = new UsersAdapter(this, R.layout.list_view_with_custom_arrayadapter, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = findViewById(R.id.lvDanhBa);
        listView.setAdapter(adapter);
    }
}
