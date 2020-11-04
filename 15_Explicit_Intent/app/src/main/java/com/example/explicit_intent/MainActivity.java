package com.example.explicit_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setEvents();
    }

    private void setEvents() {
        this.findViewById(R.id.btnOpenActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        this.findViewById(R.id.btnPassValue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent chi co the gui di cac value co kieu primitive, kieu String va
                //      kieu Object cua ta khi implements inteface Serializable

                // B1: Tao Intent
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                // B2: Tao du lieu nguon va truyen vao Intent
                // Cach 1: Them value truc tiep vao Intent
                Student student = new Student(123, "ABC");
                String varString = "Dau xanh rau muong";
                char varChar = 'F';
                int varNum = 1519;
                boolean varBoolean = true;
                intent.putExtra("student", student);
                intent.putExtra("varString", varString);
                intent.putExtra("varChar", varChar);
                intent.putExtra("varNum", varNum);
                intent.putExtra("varBoolean", varBoolean);

                // Cach 2: Boxing cac value lai trong kieu Bundle roi moi them vao Intent
                Bundle box = new Bundle();
                box.putSerializable("student", student);
                box.putString("varString", varString);
                box.putChar("varChar", varChar);
                box.putInt("varNum", varNum);
                box.putBoolean("varBoolean", varBoolean);
                intent.putExtra("box", box);
                // B3: Chay Intent
                startActivity(intent);
            }
        });

        this.findViewById(R.id.btnPassAndGetValue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent chi co the gui di cac value co kieu primitive, kieu String va
                //      kieu Object cua ta khi implements inteface Serializable

                // B1: Tao Intent
                Intent intent = new Intent(MainActivity.this, FourthActivity.class);
                // B2: Tao du lieu nguon
                List<Student> students = new ArrayList<>();
                for (int i = 1; i < 4; i++){
                    students.add(new Student(i, "Student " + i));
                }
                // B3: Dong goi
                Bundle box = new Bundle();
                for (int i = 0; i < 3; i++){
                    box.putSerializable("student" + i, students.get(i));
                }
                // B4: Truyen vao Intent
                intent.putExtra("box", box);
                // B5: Chay Intent
                startActivityForResult(intent, 1519);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Override lai ham nay de nhan gia tri gui ve tu cac Activity dich neu co
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1519 && resultCode == 1000){
            int result = data.getIntExtra("retrievementValue", -1);
            Toast.makeText(MainActivity.this,
                    "So luong student co: " + result,
                    Toast.LENGTH_LONG).show();
        }
    }
}
