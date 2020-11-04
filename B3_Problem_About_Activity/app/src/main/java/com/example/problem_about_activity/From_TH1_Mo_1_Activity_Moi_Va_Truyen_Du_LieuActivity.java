package com.example.problem_about_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.problem_about_activity.Model.Student;

public class From_TH1_Mo_1_Activity_Moi_Va_Truyen_Du_LieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from__th1__mo_1___moi__va__truyen__du__lieu);

        setupControls();
    }

    private void setupControls() {
        Intent intent = this.getIntent();

        Bundle bundle = intent.getBundleExtra("myBundle");
        Student student = (Student) bundle.getSerializable("student");
        boolean varBoolean = bundle.getBoolean("varBoolean");
        String varString = bundle.getString("varString");

        TextView txtResult = this.findViewById(R.id.txtResult);
        txtResult.setText("Student: " + student.toString()
                        + "\nvarBoolean: " + varBoolean
                        + "\nvarString: " + varString);
    }
}
