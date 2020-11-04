package com.example.datepicker_timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        setControls();
        setEvents();
    }

    TimePicker timePicker;
    EditText txtHour, txtMinute;

    private void setControls() {
        timePicker = this.findViewById(R.id.tpTime);
        txtHour = this.findViewById(R.id.txtHour);
        txtMinute = this.findViewById(R.id.txtMinute);
    }

    private void setEvents() {
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String now = hourOfDay + ":" + minute;
                Toast.makeText(TimePickerActivity.this,
                        "Now is: " + now,
                        Toast.LENGTH_SHORT).show();
            }
        });

        this.findViewById(R.id.btnGetCurrentHourMinute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String now = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                Toast.makeText(TimePickerActivity.this,
                        "Now is: " + now,
                        Toast.LENGTH_SHORT).show();
            }
        });

        this.findViewById(R.id.btnSetCurrentHourMinute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = Integer.parseInt(txtHour.getText().toString());
                timePicker.setCurrentHour(hour);

                int minute = Integer.parseInt(txtMinute.getText().toString());
                timePicker.setCurrentMinute(minute);
            }
        });

        this.findViewById(R.id.btn24h).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timePicker.is24HourView()){
                    timePicker.setIs24HourView(false);
                    txtHour.setHint("Nhập từ 0 đến 12");
                }
                else {
                    timePicker.setIs24HourView(true);
                    txtHour.setHint("Nhập từ 0 đến 24");
                }
            }
        });

        this.findViewById(R.id.btnBackward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimePickerActivity.this,
                        DatePickerActivity.class);
                startActivity(intent);
            }
        });
    }
}
