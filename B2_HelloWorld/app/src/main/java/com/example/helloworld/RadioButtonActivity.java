package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        rate();
        changeMode();
    }

    public void rate(){
        final RadioButton radExcellent = findViewById(R.id.radExcellent);
        final RadioButton radGood = findViewById(R.id.radGood);
        final RadioButton radBad = findViewById(R.id.radBad);

        radExcellent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    radExcellent.setTextColor(Color.GREEN);
                    Toast.makeText(RadioButtonActivity.this,
                            "Nhà hàng của bạn rất tuyệt vời",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                radExcellent.setTextColor(Color.BLACK);
            }
        });
        radGood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    radGood.setTextColor(Color.GREEN);
                    Toast.makeText(RadioButtonActivity.this,
                            "Nhà hàng của bạn tốt",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                radGood.setTextColor(Color.BLACK);
            }
        });
        radBad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    radBad.setTextColor(Color.GREEN);
                    Toast.makeText(RadioButtonActivity.this,
                            "Nhà hàng của bạn khá tệ",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                radBad.setTextColor(Color.BLACK);
            }
        });
    }

    public void changeMode(){
        Button changingMode = findViewById(R.id.btnChangingMode);
        changingMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup group = findViewById(R.id.radGroup);


                if(group.getOrientation() == RadioGroup.VERTICAL){
                    group.setOrientation(RadioGroup.HORIZONTAL);
                    return;
                }

                group.setOrientation(RadioGroup.VERTICAL);
            }
        });
    }
}
