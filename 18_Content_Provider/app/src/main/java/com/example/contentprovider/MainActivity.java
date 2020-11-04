package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    List<String> data;
    ArrayAdapter<String> adapter;
    ListView lvContact;

    private void setControls() {
        lvContact = this.findViewById(R.id.lvContact);
        setDataForListView();
    }

    private void setDataForListView() {
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, data);
        lvContact.setAdapter(adapter);
    }

    private void setEvents() {
        this.findViewById(R.id.btnDocDanhBa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readAllContactsFromPhone();
            }
        });

        this.findViewById(R.id.btnDocTinNhan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readAllSmsFromPhone(MainActivity.this);
            }
        });
    }

    private void readAllContactsFromPhone() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(getApplicationContext().checkSelfPermission( Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED )
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        }

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,
                null,null,null,null);
        data.clear();

        while(cursor.moveToNext())
        {
            // Tạo cột tên:
            String idName = ContactsContract.Contacts.DISPLAY_NAME;
            int colNameIndex = cursor.getColumnIndex(idName);
            String name = cursor.getString(colNameIndex);

            String idPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int colPhoneIndex = cursor.getColumnIndex(idPhone);
            String phone = cursor.getString(colPhoneIndex);

            String contact = "Name: " + name + "\nPhone: " + phone;
            data.add(contact);
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    public void readAllSmsFromPhone(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(getApplicationContext().checkSelfPermission( Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED )
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, 1);
        }

        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(
                Uri.parse("content://sms/inbox"),
                null, null, null, null);
        data.clear();

        int indexPhoneNumber = cursor.getColumnIndex("address");
        int indexTimeStamp = cursor.getColumnIndex("date");
        int indexBody = cursor.getColumnIndex("body");

        if (indexBody < 0 || !cursor.moveToFirst())     return;
        while(cursor.moveToNext()){
            String phonenumber = cursor.getString(indexPhoneNumber);
            String timeStamp = cursor.getString(indexTimeStamp);
            String body = cursor.getString(indexBody);

            String sms = "Phone: " + phonenumber + "\nTime: " + timeStamp + "\nBody: " + body;
            data.add(sms);
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }
}

