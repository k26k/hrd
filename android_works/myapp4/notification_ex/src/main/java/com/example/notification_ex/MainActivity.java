package com.example.notification_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.notification_ex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBigPicture.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            채널 생성
            String channelId = "one-channel";
            String channelName = "My Channel One";
            String description = "My Channel One Description";
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, manager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(description);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.rgb(255,255,255));
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100L, 200L, 300L});
            manager.createNotificationChannel(notificationChannel);

            builder = new NotificationCompat.Builder(this, channelId);
        }else{
            builder = new NotificationCompat.Builder(this);
        }

        Bitmap largePicture = BitmapFactory.decodeResource(getResources(), R.drawable.noti_large);

        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("")
                .setContentText("")
                .setAutoCancel(true)
                .setLargeIcon(largePicture);



        if(view == binding.btnBigPicture){
            Bitmap bigPicture = BitmapFactory.decodeResource(getResources(), R.drawable.noti_big);
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle(builder);
            bigPictureStyle.bigPicture(bigPicture);
            builder.setStyle(bigPictureStyle);
            Notification notification = builder.build();
            manager.notify(1, notification);
        }
    }
}