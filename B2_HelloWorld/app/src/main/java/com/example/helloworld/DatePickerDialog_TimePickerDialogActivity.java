package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePickerDialog_TimePickerDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog_time_picker_dialog);

        setDateTime();
    }

    private void setDateTime(){
        final Calendar dateTime = Calendar.getInstance();
        final SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
        final SimpleDateFormat timeFormater = new SimpleDateFormat("HH:mm");

        final TextView txtDate = this.findViewById(R.id.txtDate);
        final TextView txtTime = this.findViewById(R.id.txtTime);
        txtDate.setText(dateFormater.format(dateTime.getTime()));
        txtTime.setText(timeFormater.format(dateTime.getTime()));

        ImageButton btnDate = this.findViewById(R.id.btnDate);
        ImageButton btnTime = this.findViewById(R.id.btnTime);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            excuteDate(dateTime, txtDate, dateFormater);
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            excuteTime(dateTime, txtTime, timeFormater);
            }
        });
    }

    private void excuteDate(final Calendar dateTime, final TextView txtDate, final SimpleDateFormat dateFormater){
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateTime.set(Calendar.YEAR, year);
                dateTime.set(Calendar.MONTH, month);
                dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                txtDate.setText(dateFormater.format(dateTime.getTime()));
            }
        };

        DatePickerDialog datePicker = new DatePickerDialog(DatePickerDialog_TimePickerDialogActivity.this,
                callBack,
                dateTime.get(Calendar.YEAR),
                dateTime.get(Calendar.MONTH),
                dateTime.get(Calendar.DAY_OF_MONTH));

        datePicker.show();
    }

    private void excuteTime(final Calendar dateTime, final TextView txtTime, final SimpleDateFormat timeFormater) {
        TimePickerDialog.OnTimeSetListener callBack = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateTime.set(Calendar.MINUTE, minute);

                txtTime.setText(timeFormater.format(dateTime.getTime()));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(DatePickerDialog_TimePickerDialogActivity.this,
                callBack,
                dateTime.get(Calendar.HOUR_OF_DAY),
                dateTime.get(Calendar.MINUTE),
                true);

        timePickerDialog.show();
    }
}
