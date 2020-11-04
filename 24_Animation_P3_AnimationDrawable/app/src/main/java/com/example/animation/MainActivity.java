package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    AnimationDrawable animationDrawable;
    ImageView imgContent;

    private void setControls() {
        imgContent = this.findViewById(R.id.imgContent);
        setAnimation();
    }

    private void setAnimation() {
        imgContent.setBackgroundResource(R.drawable.template_drawable_animation);
        animationDrawable = (AnimationDrawable) imgContent.getBackground();
    }

    private void setEvents() {
        this.findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });

        this.findViewById(R.id.btnStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });
    }
}
