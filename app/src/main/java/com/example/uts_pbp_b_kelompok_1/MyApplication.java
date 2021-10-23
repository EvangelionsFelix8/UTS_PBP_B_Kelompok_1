package com.example.uts_pbp_b_kelompok_1;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.google.firebase.messaging.FirebaseMessaging;

// NOTIFICATION DARI FIREBASE

public class MyApplication extends Application {
    public static final String CHANNEL_1_ID = "channel1";

    @Override
    public void onCreate(){
        super.onCreate();
        FirebaseMessaging.getInstance().subscribeToTopic("promotional_notification");

        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");

            /*NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 2"); */

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            //manager.createNotificationChannel(channel2);
        }
    }
}
