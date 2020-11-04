package com.example.textview_edittext_autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    TextView txtTextView;
    EditText txtEditText;
    AutoCompleteTextView txtAutoCompleteTextView;

    private void setDataForAutoCompleteTextView(){
        String[] cityNames = this.getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                                            android.R.layout.simple_list_item_1,
                                                            cityNames);
        txtAutoCompleteTextView.setAdapter(adapter);
    }

    private void setControls() {
        txtTextView = this.findViewById(R.id.txtTextView);
        txtEditText = this.findViewById(R.id.txtEditText);
        txtAutoCompleteTextView = this.findViewById(R.id.txtAutoCompleteTextView);
        setDataForAutoCompleteTextView();
    }

    private void setEvents() {
        this.findViewById(R.id.btnExecute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = txtTextView.getText() + "\n"
                        + txtEditText.getText() + "\n"
                        + txtAutoCompleteTextView.getText();
                Toast.makeText(MainActivity.this,
                        info, Toast.LENGTH_LONG).show();
            }
        });
    }
}
