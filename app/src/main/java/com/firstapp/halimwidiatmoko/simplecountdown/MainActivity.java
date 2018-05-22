package com.firstapp.halimwidiatmoko.simplecountdown;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtCountdownTimer;
    private Button btnCoundown;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilisecond = 600000;// 10 menit
    private boolean timeIsRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCountdownTimer = (TextView) findViewById(R.id.txt_countdown);
        btnCoundown = (Button) findViewById(R.id.btn_start);

        btnCoundown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("tab this ","start countdown");
                startStop();
            }
        });
        updateTimer();
    }

    private void startStop() {
        if (timeIsRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilisecond, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilisecond = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        btnCoundown.setText("pause");
        timeIsRunning = true;
    }

    private void updateTimer() {
        int minutes = (int) timeLeftInMilisecond / 60000;
        int seconds = (int) timeLeftInMilisecond % 60000 / 1000;

        String timeLeft;
        timeLeft = " " + minutes;
        timeLeft += ":";
        if (seconds < 10) timeLeft += "0";
        timeLeft += seconds;

        txtCountdownTimer.setText(timeLeft);


    }

    private void stopTimer() {
        countDownTimer.cancel();
        btnCoundown.setText("start");
        timeIsRunning = false;
    }

}
