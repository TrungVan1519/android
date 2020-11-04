package com.example.problem_about_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.problem_about_activity.Model.Student;

public class TH1_Mo_1_Activity_Moi_Va_Truyen_Du_LieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th1__mo_1___moi__va__truyen__du__lieu);
    }

    public void xyLyMoManHinhMoiVaGuiDuLieu(View view) {
        Intent intent = new Intent(this,
                From_TH1_Mo_1_Activity_Moi_Va_Truyen_Du_LieuActivity.class);


        Student student = new Student("ABC", 1);
        boolean varBoolean = true;
        String varString = "Dau xanh rau muong";

        Bundle bundle = new Bundle();
        bundle.putString("varString", varString);
        bundle.putBoolean("varBoolean", varBoolean);
        bundle.putSerializable("student", student);

        intent.putExtra("myBundle", bundle);

        startActivity(intent);
    }
}
