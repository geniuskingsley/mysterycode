package com.example.simplemusicapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ServiceClass extends Service {
    /**
     * Media player
     */
    MediaPlayer mediaPlayer;

    /**
     * Our notification variable
     */
    Notification notification;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        notificationApp();
        startForeground(1, notification);
        playMusic();
        //pause_music();
         return START_NOT_STICKY;
    }

    public void playMusic(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                create_media_player();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

//    public  void pause_music(){
//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
//                pause();
//            }
//        };
//
//        Thread thread2 = new Thread(runnable2);
//        thread2.start();
//    }


    public void create_media_player()
    {
        /**
         *
         */
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.test_music);
        }

        /**
         *
         */
        if (mediaPlayer != null){
            mediaPlayer.start();
        }


    }

//    public void pause(){
//
//        if (mediaPlayer != null){
//            mediaPlayer.pause();
//        }
//    }

    /**
     * Notification.....
     */
    public void notificationApp(){

        final  String CHANEL_ID = "FirstChannel";
        final String NAME = "FirstName";

        /**
         * Notification Manager..
         */
        NotificationManager notificationManager =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        /**
         * If the android version is 9 and higher..
         */
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O)
        {
            /**
             * Notification channel...
             */
            NotificationChannel notificationChannel = new NotificationChannel
                    (CHANEL_ID, NAME, NotificationManager.IMPORTANCE_DEFAULT);

            /**
             * Creating notification channel using our notification manager..
             */
            notificationManager.createNotificationChannel(notificationChannel);
        }

        /**
         * Building our notification..
         */
        notification = new NotificationCompat.Builder
                (this, CHANEL_ID).setContentTitle("Counting")
                .setContentText("Music Is Playing").setSmallIcon(R.drawable.music_icon).build();
    }

}
