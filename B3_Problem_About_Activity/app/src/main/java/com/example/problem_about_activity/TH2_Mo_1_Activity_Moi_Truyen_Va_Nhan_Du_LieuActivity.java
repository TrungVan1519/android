package com.example.problem_about_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TH2_Mo_1_Activity_Moi_Truyen_Va_Nhan_Du_LieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th2__mo_1___moi__truyen__va__nhan__du__lieu);

        setupControls();
    }

    private void setupControls() {
        final EditText txtSoA = this.findViewById(R.id.txtSoA);
        final EditText txtSoB = this.findViewById(R.id.txtSoB);

        this.findViewById(R.id.btnExecute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TH2_Mo_1_Activity_Moi_Truyen_Va_Nhan_Du_LieuActivity.this,
                        From_TH2_Mo_1_Activity_Moi_Truyen_Nhan_Du_LieuActivity.class);

                int soA = Integer.parseInt(txtSoA.getText().toString());
                int soB = Integer.parseInt(txtSoB.getText().toString());
                Bundle pack = new Bundle();
                pack.putInt("soA", soA);
                pack.putInt("soB", soB);

                i.putExtra("pack", pack);

//                startActivityForResult(i, 1519, pack);
                startActivityForResult(i, 1519);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(1519, 1000, data);
        if (requestCode == 1519 && resultCode == 1000){
            TextView txtResult = this.findViewById(R.id.txtResult);
            txtResult.setText("Kết quả: " + data.getIntExtra("result", -1));
        }
    }
}
