package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.databinding.ActivityLayoutEx3Binding;

public class LayoutEx3 extends AppCompatActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    ActivityLayoutEx3Binding binding;
    boolean[] alarmStatus = new boolean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLayoutEx3Binding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bellName.setOnClickListener(this::onClick);
        binding.onoff.setOnCheckedChangeListener(this::onCheckedChanged);
        binding.repeatCheck.setOnCheckedChangeListener(this::onCheckedChanged);
        binding.vibrateCheck.setOnCheckedChangeListener(this::onCheckedChanged);
    }

//    touch event(터치 -> 좌표 표시) 추가
    float x, y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            x = event.getX();
            y = event.getY();

        }else if(event.getAction() == MotionEvent.ACTION_UP){
            float moveX = event.getX() - x;
            float moveY = y - event.getY();
            float moveAdd = (float) Math.sqrt(Math.pow(moveX, 2) + Math.pow(moveY, 2));

            String textFirst = String.format("x 이동거리: %.2f, y 이동거리: %.2f",moveX, moveY);

            int mode = 0;

            float deg = (float) Math.atan2(moveY, moveX);

            if(moveAdd > 30) {

                float absX = Math.abs(moveX);
                float absY = Math.abs(moveY);

                if(absX > absY * 2.75){
                    mode += moveX > 0 ? 0B0001:0B0010;
                }else if(absY > absX * 2.75){
                    mode += moveY > 0 ? 0B0100:0B1000;
                }else{
                    mode += moveX > 0 ? 0B0001:0B0010;
                    mode += moveY > 0 ? 0B0100:0B1000;
                }

//                if (moveX > 30) {
//                    mode += 0B0001;
//                } else if (moveX < -30) {
//                    mode += 0B0010;
//                }
//                if (moveY > 30) {
//                    mode += 0B0100;
//                } else if (moveY < -30) {
//                    mode += 0B1000;
//                }
            }
//
//            switch(mode){
//                case 0B0101:
//                    if(moveX > moveY * 2.414){
//                        mode = 0B0001;
//                    }else if(moveY > moveX * 2.414){
//                        mode = 0B0100;
//                    }
//                    break;
//
//                case 0B0110:
//                    if((-moveX) > moveY * 2.414){
//                        mode = 0B0010;
//                    }else if(moveY > (-moveX) * 2.414){
//                        mode = 0B0100;
//                    }
//                    break;
//
//                case 0B1001:
//                    if(moveX > (-moveY) * 2.414){
//                        mode = 0B0001;
//                    }else if((-moveY) > moveX * 2.414){
//                        mode = 0B1000;
//                    }
//                    break;
//
//                case 0B1010:
//                    if((-moveX) > (-moveY) * 2.414){
//                        mode = 0B0010;
//                    }else if((-moveY) > (-moveX) * 2.414){
//                        mode = 0B1000;
//                    }
//                    break;
//            }

            String textSecond = "";

            switch (mode){
                case 0B0001:
                    textSecond = "동쪽으로 밀었습니다.";
                    break;

                case 0B0010:
                    textSecond = "서쪽으로 밀었습니다.";
                    break;

                case 0B0100:
                    textSecond = "북쪽으로 밀었습니다.";
                    break;

                case 0B0101:
                    textSecond = "북동쪽으로 밀었습니다.";
                    break;

                case 0B0110:
                    textSecond = "북서쪽으로 밀었습니다.";
                    break;

                case 0B1000:
                    textSecond = "남쪽으로 밀었습니다.";
                    break;

                case 0B1001:
                    textSecond = "남동쪽으로 밀었습니다.";
                    break;

                case 0B1010:
                    textSecond = "남서쪽으로 밀었습니다.";
                   break;

                default:
                    textSecond = "터치했습니다.";
                    break;
            }
            textSecond += " "+deg;
            String textThird = String.format(" 총 이동거리: %.1f", Math.sqrt(Math.pow(moveX, 2) + Math.pow(moveY, 2)));

            Toast.makeText(this, textFirst+"\n"+textSecond+"\n"+textThird, Toast.LENGTH_SHORT).show();

        }

        return super.onTouchEvent(event);
    }


//    key event(뒤로가기 -> 종료) 추가
    long initTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
//        Toast.makeText(this, keyCode+" "+event.toString(), Toast.LENGTH_LONG).show();
        if(keyCode == KeyEvent.KEYCODE_BACK){
            long timeNow = System.currentTimeMillis();
            if(timeNow - initTime < 3000){
                Toast.makeText(this, "어플리케이션 종료", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                initTime = timeNow;
                Toast.makeText(this, "종료하시려면 다시 뒤로가주세요", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void showBellName(TextView textView){
        String text = textView.getText().toString();
        Toast.makeText( this, "alarm name is "+text+".", Toast.LENGTH_SHORT).show();
    }
    private void showBellEnableStatus(){
        String text = "alarm status: "+(alarmStatus[0]==true ? "enable and "
                +(alarmStatus[1]==true?"repeat":"non repeat")+", "
                +(alarmStatus[2]==true?"vibrate on":"vibrate off."):"disable.");
        Toast.makeText( this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if(view == binding.bellName){
            showBellName(binding.bellName);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(compoundButton == binding.onoff){
            alarmStatus[0] = isChecked;
        }
        if(compoundButton == binding.repeatCheck){
            alarmStatus[1] = isChecked;
        }
        if(compoundButton == binding.vibrateCheck){
            alarmStatus[2] = isChecked;
        }
        showBellEnableStatus();
    }

}