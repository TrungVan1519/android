package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControls();
        getEvents();
    }

    EditText txtUsername, txtPassword;
    CheckBox chkIsSave;
    String savingFileName = "log_in";

    private void getControls() {
        txtUsername = this.findViewById(R.id.txtUserName);
        txtPassword = this.findViewById(R.id.txtPassword);
        chkIsSave = this.findViewById(R.id.chkIsSave);
    }

    private void getEvents() {
        this.findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.findViewById(R.id.btnConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_LONG);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();

        // Luu trang thai App
        SharedPreferences sharedPreferences = this.getSharedPreferences(savingFileName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", txtUsername.getText().toString());
        editor.putString("password", txtPassword.getText().toString());
        editor.putBoolean("isSave", chkIsSave.isChecked());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Load trang thai App
        SharedPreferences sharedPreferences = this.getSharedPreferences(savingFileName, MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        boolean isSave = sharedPreferences.getBoolean("isSave", false);
        chkIsSave.setChecked(isSave);
        if(chkIsSave.isChecked()){
            txtUsername.setText(username);
            txtPassword.setText(password);
        }
    }
}
