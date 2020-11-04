package com.example.checkbox_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    CheckBox chkPython, chkJava, chkAll;
    RadioButton radBoy, radGirl;

    private void setControls() {
        chkPython = this.findViewById(R.id.chkPython);
        chkJava = this.findViewById(R.id.chkJava);
        chkAll = this.findViewById(R.id.chkAll);

        radBoy = this.findViewById(R.id.radBoy);
        radGirl = this.findViewById(R.id.radGirl);
    }

    private void setEvents() {
        chkAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                   /* if (!chkJava.isChecked())  */ chkJava.setChecked(true);
                    /*if(!chkPython.isChecked()) */ chkPython.setChecked(true);
                } else {
                    chkJava.setChecked(false);
                    chkPython.setChecked(false);
                }
            }
        });

        radBoy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    radBoy.setTextColor(Color.GREEN);
                    radGirl.setTextColor(Color.BLACK);
                }
            }
        });

        radGirl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    radGirl.setTextColor(Color.GREEN);
                    radBoy.setTextColor(Color.BLACK);
                }
            }
        });

        this.findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "";
                if(chkAll.isChecked()){
                    info += chkJava.getText() + "\n" + chkPython.getText() + "\n";
                }
                else {
                    if (chkJava.isChecked()){
                        info += chkJava.getText() + "\n";
                    }
                    if (chkPython.isChecked()){
                        info += chkPython.getText() + "\n";
                    }
                }

                info += radBoy.isChecked() ? radBoy.getText() + "" : radGirl.getText() + "";
                Toast.makeText(MainActivity.this,
                        info, Toast.LENGTH_LONG).show();
            }
        });
    }
}
