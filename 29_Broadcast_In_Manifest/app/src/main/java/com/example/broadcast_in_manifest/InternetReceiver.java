package com.example.broadcast_in_manifest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class InternetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null){
            createNotification(context);
        } else {

            Toast.makeText(context, "Internet is disconected", Toast.LENGTH_SHORT).show();
        }
    }

    NotificationManager notificationManager;
    NotificationChannel notificationChannel;
    Notification notification;
    String channelId = "my_channel_02";
    int notificationId = 1;

    private void createNotification(Context context) {
        // B1: Tao NotificationManager
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setContentTitle("Notification")
                .setContentText("Broadcast in manifest");
        // Tao am thanh cho Notification
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);

        // B3.2: Tao Notification
        notification = builder.build();

        // B4: Tao PendungIntent de khi bam vao Notification ta se duoc chuyen den 1 Activity
        Intent resultIntent = new Intent(context, MainActivity.class);
        resultIntent.putExtra("content", "Blah Blah");
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                context,
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
