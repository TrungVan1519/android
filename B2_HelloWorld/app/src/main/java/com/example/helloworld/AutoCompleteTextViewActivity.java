package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class AutoCompleteTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        setDataForAutoCompleteTextView();
    }

    private void setButtonConfirm(final TextView txtCity) {
        final TextView txtResult = this.findViewById(R.id.txtResult);
        this.findViewById(R.id.btnConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtCity.getText());
            }
        });
    }

    private void setDataForAutoCompleteTextView() {
        AutoCompleteTextView txtCity = this.findViewById(R.id.txtCity);

        // Nap du lieu nguon cho AutoCompleteTextView
        String[] cityNames = this.getResources().getStringArray(R.array.tinh_thanh);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                        android.R.layout.simple_spinner_item,
                                        cityNames);
        txtCity.setAdapter(adapter);
        // Goi su kien click cua Button
        setButtonConfirm(txtCity);
    }
}
