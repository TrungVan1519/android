package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    Animation rotateAnimation, fadeAnimation;
    Button btnRotateControls, btnRotateActivity, btnAffectForListView;

    private void setControls() {
        btnRotateControls = this.findViewById(R.id.btnRotateControls);
        btnRotateActivity = this.findViewById(R.id.btnRotateActivity);
        btnAffectForListView = this.findViewById(R.id.btnAffectForListView);

        setAnimation();
    }

    private void setAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.template_rotate_animation);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Start",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "End",
                        Toast.LENGTH_SHORT).show();
                // Khi animation ket thuc thi se thoat han App
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(MainActivity.this, "Repeat",
                        Toast.LENGTH_SHORT).show();
            }
        });

        fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.template_fade_animation);
    }

    private void setEvents() {
        btnRotateControls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRotateControls.startAnimation(rotateAnimation);
            }
        });

        btnRotateActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findViewById(R.id.layoutActivity);
                layout.startAnimation(rotateAnimation);
            }
        });
    }
}
