package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        setConfirm();
    }

    public void setConfirm(){
        Button btnConfirm = findViewById(R.id.btnConfirm);
        final CheckBox chkPython = findViewById(R.id.chkPython);
        final CheckBox chkJava = findViewById(R.id.chkJava);
        final CheckBox chkJS = findViewById(R.id.chkJS);
        final CheckBox chkCPlus = findViewById(R.id.chkCPlus);
        final CheckBox chkCSharp = findViewById(R.id.chkCSharp);
        final CheckBox chkAll = findViewById(R.id.chkAll);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Danh sách ngôn ngữ đã chọn";
                int count = 0;

                if(chkAll.isChecked()){
                    chkPython.setChecked(true);
                    chkJava.setChecked(true);
                    chkJS.setChecked(true);
                    chkCPlus.setChecked(true);
                    chkCSharp.setChecked(true);
                }
                if(chkPython.isChecked()){
                    count++;
                    result += "\n" + chkPython.getText();
                }
                if(chkJava.isChecked()){
                    count++;
                    result += "\n" + chkJava.getText();
                }
                if(chkJS.isChecked()){
                    count++;
                    result += "\n" + chkJS.getText();
                }
                if(chkCPlus.isChecked()){
                    count++;
                    result += "\n" + chkCPlus.getText();
                }
                if(chkCSharp.isChecked()){
                    count++;
                    result += "\n" + chkCSharp.getText();
                }

                TextView content = findViewById(R.id.txtContent);
                content.setText(result);

                Toast.makeText(CheckboxActivity.this, "Số ngôn ngữ đã chọn: " + count, Toast.LENGTH_LONG).show();
            }
        });
    }
}
