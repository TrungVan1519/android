package com.example.broadcastreceiver_in_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    EditText txtUsername, txtPassword;
    private void setControls() {
        txtUsername = this.findViewById(R.id.txtUserName);
        txtPassword = this.findViewById(R.id.txtPassword);
    }

    private void setEvents() {

    }

    BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

            if (connectivityManager.getActiveNetworkInfo() != null){
                MainActivity.this.findViewById(R.id.btnLogin).setVisibility(View.VISIBLE);
            }
            else {
                MainActivity.this.findViewById(R.id.btnLogin).setVisibility(View.INVISIBLE);
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        // Muon them tinh nang gi nhu lay tin nhan thi them o day
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (networkReceiver != null)
            unregisterReceiver(networkReceiver);
    }
}
