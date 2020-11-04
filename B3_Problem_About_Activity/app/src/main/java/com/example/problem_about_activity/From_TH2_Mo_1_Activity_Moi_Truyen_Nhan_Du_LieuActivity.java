package com.example.problem_about_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class From_TH2_Mo_1_Activity_Moi_Truyen_Nhan_Du_LieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from__th2__mo_1___moi__truyen__nhan__du__lieu);

        setupControls();
    }

    private void setupControls() {
        TextView txtSoA = this.findViewById(R.id.txtSoA);
        TextView txtSoB = this.findViewById(R.id.txtSoB);
        TextView txtResult = this.findViewById(R.id.txtResult);

        final int ketQua = getData(txtSoA, txtSoB, txtResult);

        this.findViewById(R.id.btnRetrieve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                i.putExtra("result", ketQua);
                setResult(1000, i);

                finish();
            }
        });
    }

    private int getData(TextView txtSoA, TextView txtSoB, TextView txtResult) {
        Intent i = this.getIntent();

        Bundle pack = i.getBundleExtra("pack");
        int soA = pack.getInt("soA");
        int soB = pack.getInt("soB");

        txtSoA.setText("Số A: " + soA);
        txtSoB.setText("Số B: " + soB);
        txtResult.setText("Tổng: " + (soA + soB));

        return (soA + soB);
    }
}
