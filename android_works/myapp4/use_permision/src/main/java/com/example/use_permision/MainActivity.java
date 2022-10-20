package com.example.use_permision;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.view.View;

import com.example.use_permision.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnVibrate.setOnClickListener( view -> {
            Vibrator vibrator;
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                VibratorManager manager = (VibratorManager) getSystemService(this.VIBRATOR_MANAGER_SERVICE);
                vibrator = manager.getDefaultVibrator();
            }else{
                vibrator = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
            }

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                vibrator.vibrate(VibrationEffect.createOneShot(200L, 128));
            }else{
                vibrator.vibrate(10L);
            }
        });

        binding.btnBeep.setOnClickListener( view -> {
            Uri nofication = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone = RingtoneManager.getRingtone(this, nofication);
            ringtone.play();
        });
    }
}