package com.example.calendarview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    CalendarView calendarView;

    private void setControls() {
        calendarView = this.findViewById(R.id.calendarView);
        // set the red color for the dates of  focused month
        calendarView.setFocusedMonthDateColor(Color.GREEN);
        // set the yellow color for the dates of an unfocused month
        calendarView.setUnfocusedMonthDateColor(Color.RED);
        // Thiết lập màu đỏ cho các tuần, Từ API 23 trở lên mới hỗ trợ
        calendarView.setSelectedWeekBackgroundColor(Color.RED);
        // Thiết lập cho đường khoảng cách giữa các tuần là màu xanh
        calendarView.setWeekSeparatorLineColor(Color.BLACK);
    }

    private void setEvents() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),
                        dayOfMonth + "/" + month + "/" + year,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
