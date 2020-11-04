package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setEvents();
    }

    NotificationManager notificationManager;
    NotificationChannel notificationChannel;
    Notification notification;
    String channelId = "my_channel_01";
    int notificationId = 001;

    private void setEvents() {
        this.findViewById(R.id.btnCreateNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });

        this.findViewById(R.id.btnCloseNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(notificationId);
            }
        });
    }

    private void createNotification() {
        // B1: Tao NotificationManager
        notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        // B2: Tao NotificationChannel
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "Notification Channel Name";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            notificationChannel = new NotificationChannel(channelId, name, importance);
            // Thiet lap mieu ta
            notificationChannel.setDescription("This is description");
            notificationChannel.enableLights(true);
            // Thiet lap mau
            notificationChannel.setLightColor(Color.RED);
            // Thiet lap do rung khi nhan thong bao
            notificationChannel.enableVibration(true);
            // Thiet lap kieu rung
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager.createNotificationChannel(notificationChannel);
        }

        // B3: Tao Notification
        // B3.1: Tao Builder (No co tac dung tao ra Notification thong qua ham build())
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Có thông báo")
                .setContentText("Mời bạn nhấn để cập nhật version");
        // Tao am thanh cho Notification
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);

        // B3.2: Tao Notification
        notification = builder.build();

        // B4: Tao PendungIntent de khi bam vao Notification ta se duoc chuyen den 1 Activity
        Intent resultIntent = new Intent(this, UpdateActivity.class);
        resultIntent.putExtra("content", "Blah Blah");
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                this,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(resultPendingIntent);

        // B5: Kich hoat Notification thong qua NotificationManager
        // Builds the notification and issues it.
        notificationManager.notify(notificationId, builder.build());
    }
}
