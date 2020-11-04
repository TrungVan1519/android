package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// setEventVariableAsListener();
//        findViewById(R.id.abc).setOnLongClickListener(this);

public class TextActivity extends AppCompatActivity implements View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        setEventOnClickOfButton();
    }

    @Override
    public boolean onLongClick(View v) {
        findViewById(R.id.linearLayout).setVisibility(View.INVISIBLE);
        return false;
    }

    public void setEventVariableAsListener(){
        View.OnClickListener forClicking = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnVariableAsListener1){
                    Toast.makeText(TextActivity.this,
                            "Được gọi bởi btnVariableAsListener1",
                            Toast.LENGTH_LONG).show();
                }
                if(v.getId() == R.id.btnVariableAsListener2){
                    Toast.makeText(TextActivity.this,
                            "Được gọi bởi btnVariableAsListener2",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        findViewById(R.id.btnVariableAsListener1).setOnClickListener(forClicking);
        findViewById(R.id.btnVariableAsListener2).setOnClickListener(forClicking);
    }

    public void setEventOnClickOfButton(){
        Button getInfo = findViewById(R.id.btnOnCLickOfButton);
        final EditText txtName = findViewById(R.id.txtName);
        final EditText txtPassword = findViewById(R.id.txtPassword);
        getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView txtInfo  = findViewById(R.id.txtInfo);
                txtInfo.setText("Username:" + txtName.getText()
                        + "\nPassword:" + txtPassword.getText());
            }
        });
    }

    public void showPassword(View view){
        EditText txtPassword = findViewById(R.id.txtPassword);
        Toast.makeText(TextActivity.this,
                "Password la:" +  txtPassword.getText(),
                Toast.LENGTH_LONG).show();
    }

    public void setEventOnClickEventOfXML(View view){
        EditText txtName = findViewById(R.id.txtName);
        EditText txtPassword = findViewById(R.id.txtPassword);

        TextView txtInfo  = findViewById(R.id.txtInfo);
        txtInfo.setText("Username:" + txtName.getText()
                + "\nPassword:" + txtPassword.getText());
    }
}
