package com.example.explicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.model.Student;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getValue();
    }

    private void getValue() {
        Intent intent = this.getIntent();

        Student student = (Student) intent.getSerializableExtra("student");
        String varString = intent.getStringExtra("varString");
        Character varChar = intent.getCharExtra("varChar", '/');
        int varNum = intent.getIntExtra("varNum", -1);
        boolean varBoolean = intent.getBooleanExtra("varBoolean", false);

        Bundle box = intent.getBundleExtra("box");
        String result = box.getSerializable("student") + "\n" + box.getString("varString")
                + "\n" + box.getChar("varChar", '\\') + "\n"
                + box.getInt("varNum",-1) + "\n"
                + box.getBoolean("varBoolean", false);

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
