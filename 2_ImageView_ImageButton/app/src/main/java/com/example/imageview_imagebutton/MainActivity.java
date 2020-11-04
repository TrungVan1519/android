package com.example.imageview_imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    RadioButton radDateImage, radTimeImage;
    ImageView imgView;

    private void setControls() {
        radDateImage = this.findViewById(R.id.radDateImage);
        radTimeImage = this.findViewById(R.id.radTimeImage);
        imgView = this.findViewById(R.id.imgView);
    }

    private void setEvents() {
        CompoundButton.OnCheckedChangeListener callBack = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.getId() == radDateImage.getId() && isChecked){
                    imgView.setImageResource(R.drawable.date);
                }
                else if (buttonView.getId() == radTimeImage.getId() && isChecked){
                    imgView.setImageResource(R.drawable.time);
                }
            }
        };

        radDateImage.setOnCheckedChangeListener(callBack);
        radTimeImage.setOnCheckedChangeListener(callBack);

        this.findViewById(R.id.btnImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }
}
