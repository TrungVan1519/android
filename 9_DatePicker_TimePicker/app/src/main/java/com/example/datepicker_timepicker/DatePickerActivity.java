package com.example.datepicker_timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        setControls();
        setEvents();
    }

    DatePicker datePicker;

    private void setControls() {
        datePicker = this.findViewById(R.id.dpDate);
        datePicker.setSpinnersShown(false);
    }

    private void setEvents() {
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int getDay = datePicker.getDayOfMonth();
                int getMonth = datePicker.getMonth();
                int getYear = datePicker.getYear();

                Toast.makeText(DatePickerActivity.this,
                        "Day " + getDay + "\t" + dayOfMonth
                        + "\nMonth:" + getMonth + "\t" + getMonth
                        + "\nYear:" + getYear + "\t" + year,
                        Toast.LENGTH_SHORT).show();
            }
        });

        this.findViewById(R.id.btnForward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatePickerActivity.this,
                        TimePickerActivity.class);
                startActivity(intent);
            }
        });
    }
}
