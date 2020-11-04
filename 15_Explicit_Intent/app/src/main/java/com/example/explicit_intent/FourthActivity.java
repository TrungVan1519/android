package com.example.explicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.model.Student;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        getData();
        setEvents();
    }

    List<Student> students = new ArrayList<>();

    private void getData(){
        Intent intent = this.getIntent();
        String result ="";

        Bundle box = intent.getBundleExtra("box");
        for (int i = 0; i < 3; i++){
            students.add((Student) box.getSerializable("student" + i));
            result += students.get(i).getName() + "\n";
        }
        Toast.makeText(FourthActivity.this, result, Toast.LENGTH_LONG).show();
    }

    private void setEvents() {
        this.findViewById(R.id.btnRetrieveValue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FourthActivity.this.getIntent();

                // B1: Lay gia tri muon gui ve
                int retrievementValue = students.size();
                // B2: Truyen vao Intent
                intent.putExtra("retrievementValue", retrievementValue);
                // B3: Phai set responeCode va intent
                setResult(1000, intent);
                // B4: Phai dong Activity nay lai
                FourthActivity.this.finish();
            }
        });
    }
}
