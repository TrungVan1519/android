package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TimePicker;

public class DatePicker_Time_PickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker__time__picker);

//        setUp();
    }

//    private void setUp() {
//        final CalendarView calendarView = this.findViewById(R.id.calendarView);
//        final DatePicker datePicker = this.findViewById(R.id.datePicker);
//        final TimePicker timePicker = this.findViewById(R.id.timePicker);
//
//        RadioButton radChooseCalendarView = this.findViewById(R.id.radChooseCalendarView);
//        RadioButton radChooseDatePicker = this.findViewById(R.id.radChooseDatePicker);
//        RadioButton radChooseTimePicker = this.findViewById(R.id.radChooseTimePicker);
//
//        radChooseCalendarView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    calendarView.setVisibility(View.VISIBLE);
//                    calendarView.setScaleX(500);
//                    calendarView.setScaleY(500);
////                    calendarView.getLayoutParams().width = 200;
////                    calendarView.getLayoutParams().height = 200;
//
//                    datePicker.setVisibility(View.INVISIBLE);
////                    datePicker.getLayoutParams().width = 1;
////                    datePicker.getLayoutParams().height = 1;
//
//                    timePicker.setVisibility(View.INVISIBLE);
////                    timePicker.getLayoutParams().width = 1;
////                    timePicker.getLayoutParams().height = 1;
//                }
//            }
//        });
//
//        radChooseDatePicker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    datePicker.setVisibility(View.VISIBLE);
////                    datePicker.getLayoutParams().width = 200;
////                    datePicker.getLayoutParams().height = 200;
//
//                    calendarView.setVisibility(View.INVISIBLE);
////                    calendarView.getLayoutParams().width = 1;
////                    calendarView.getLayoutParams().height = 1;
//
//                    timePicker.setVisibility(View.INVISIBLE);
////                    timePicker.getLayoutParams().width = 1;
////                    timePicker.getLayoutParams().height = 1;
//                }
//            }
//        });
//
//        radChooseTimePicker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    timePicker.setVisibility(View.VISIBLE);
////                    timePicker.getLayoutParams().width = 200;
////                    timePicker.getLayoutParams().height = 200;
//
//                    datePicker.setVisibility(View.INVISIBLE);
////                    datePicker.getLayoutParams().width = 1;
////                    datePicker.getLayoutParams().height = 1;
//
//                    calendarView.setVisibility(View.INVISIBLE);
////                    calendarView.getLayoutParams().width = 1;
////                    calendarView.getLayoutParams().height = 1;
//                }
//            }
//        });
//    }
}
