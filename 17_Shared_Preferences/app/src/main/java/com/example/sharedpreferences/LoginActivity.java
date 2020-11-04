package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setControls();
        setEvents();
    }

    EditText txtUsername, txtPassword;
    CheckBox chkSaving;

    private void setControls() {
        txtUsername = this.findViewById(R.id.txtUsername);
        txtPassword = this.findViewById(R.id.txtPassword);
        chkSaving = this.findViewById(R.id.chkSave);
    }

    private void setEvents() {
        this.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsername.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this,
                            "Your account info is not enough",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        chkSaving.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkSaving.setChecked(isChecked);
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        saveAppStatus();
    }

    private void saveAppStatus() {
        SharedPreferences preferences = this.getSharedPreferences("saving", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("chkSave_status", chkSaving.isChecked());
        editor.putString("txtUsername_status", txtUsername.getText().toString());
        editor.putString("txtPassword_status", txtPassword.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadAppStatus();
    }

    private void loadAppStatus() {
        SharedPreferences preferences = this.getSharedPreferences("saving", MODE_PRIVATE);

        boolean isSaving = preferences.getBoolean("chkSave_status", false);
        if (isSaving){
            chkSaving.setChecked(isSaving);
            String username = preferences.getString("txtUsername_status", "notFound");
            txtUsername.setText(username);
            String password = preferences.getString("txtPassword_status", "notFound");
            txtPassword.setText(password);
        }
    }
}
