package com.example.animator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();

        Toast.makeText(this, "Vẫn lỗi", Toast.LENGTH_LONG).show();
    }

    int score = 0;
    TextView txtscore;
    ViewGroup.LayoutParams params;
    LinearLayout layoutBubble;
    ImageView img;

    private void setControls() {
        txtscore = this.findViewById(R.id.txtScore);
        layoutBubble = this.findViewById(R.id.layoutBubble);
        params = new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        img = new ImageView(this);
    }

    private void setEvents() {
        this.findViewById(R.id.btnCreateBubble).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                for (int i = 0; i <= new Random().nextInt(2); i++) {
                    setAnimator();
                }
            }
        });

    }

    private void setAnimator() {
        img.setBackground(getDrawable());
        img.setX(new Random().nextInt(500));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutBubble.removeView(v);
                txtscore.setText("Score : "+(score+=1));
            }
        });

        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(
                MainActivity.this,
                R.animator.template_animator
        );
        objectAnimator.setDuration(new Random().nextInt(1000) + 2000);
        objectAnimator.setTarget(img);

        layoutBubble.addView(img, params);

        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                layoutBubble.removeView((View)
                        ((ObjectAnimator)animation).getTarget());
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();
    }

    public Drawable getDrawable() {
        Drawable draw;
        int i = new Random().nextInt(2);
        switch (i) {
            case 0:
                draw = getResources().getDrawable(R.drawable.blue_bubble);
                break;
            case 1:
                draw = getResources().getDrawable(R.drawable.green_bubble);
                break;
            default:
                draw = getResources().getDrawable(R.drawable.blue_bubble);
                break;
        }
        return draw;
    }

}
