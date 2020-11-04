package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.custom_adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    RecyclerView recyclerView;

    private void setControls() {
        recyclerView = this.findViewById(R.id.recyclerView);
        setDataForRecyclerView();
    }

    private void setDataForRecyclerView() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            strings.add(i + "");
        }
        ItemAdapter adapter = new ItemAdapter(this,
                R.layout.template_for_recyclerview, strings);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        ));
        recyclerView.setAdapter(adapter);
    }

    private void setEvents() {
//        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.template_fade_animation);

//        recyclerView.startAnimation(fadeAnimation);
    }
}
