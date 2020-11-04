package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ImageButton_ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button__image_view);

        showImage();
        exitApp();
    }

    public void showImage(){
        final RadioButton radDefaultImage = findViewById(R.id.radDefaultImage);
        final RadioButton radWesterosImage = findViewById(R.id.radWesterosImage);
        final ImageView imgContent = findViewById(R.id.imgContent);

        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.getId() == radDefaultImage.getId() && isChecked){
                    imgContent.setImageResource(R.drawable.ic_launcher_foreground);
                }
                if(buttonView.getId() == radWesterosImage.getId() && isChecked){
                    imgContent.setImageResource(R.drawable.ic_westeros);
                }
            }
        };

        radDefaultImage.setOnCheckedChangeListener(onCheckedChangeListener);
        radWesterosImage.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void exitApp(){
        findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
