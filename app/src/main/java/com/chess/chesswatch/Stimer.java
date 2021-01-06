package com.chess.chesswatch;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class Stimer extends AppCompatActivity {

    TextView receive, receive2,moveb2,moveb3;
    AlertDialog.Builder builder;
    private static long start_time_in_millis=3600000;
    private static long start_time_in_millis2=3600000;
    private TextView Countdown_Timer;
    private TextView Countdown_Timer2;
    private ImageButton ButtonSetting;
    private ImageButton ButtonStart;
    private ImageButton ButtonReset;
    private ImageButton ButtonPause;
    private ImageButton Buttonrestart;
    private CountDownTimer mCountDownTimer;
    private CountDownTimer mCountDownTimer2;
    private boolean mTimerRunning;
    private boolean mTimerRunning2;
    private long mTimeLeftInMillis = start_time_in_millis;
    private long mTimeLeftInMillis2 = start_time_in_millis2;
    private boolean color = true;
    private Toast toast;
    private int k;
    int count2 = 0;
    int count3 = 0;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stimer);

        context=this;
        builder = new AlertDialog.Builder(this);
        Countdown_Timer= findViewById(R.id.countdown);
        ButtonSetting=findViewById(R.id.setting);
        ButtonStart=findViewById(R.id.start);
        ButtonReset=findViewById(R.id.reset);
        ButtonPause=findViewById(R.id.button);
        Buttonrestart=findViewById(R.id.restart);
        Countdown_Timer2= findViewById(R.id.countdown2);
        moveb2 = (TextView) findViewById(R.id.moveb2);
        moveb3 = (TextView) findViewById(R.id.moveb3);

        receive = (TextView) findViewById(R.id.wp1);
        receive2 = (TextView) findViewById(R.id.bp2);
        receive.setText(getIntent().getStringExtra("EdiTtEXTvALUE"));
        receive2.setText(getIntent().getStringExtra("EdiTtEXTvALUE2"));



        ButtonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting=new Intent(context,Setting.class);
                context.startActivity(setting);

            }
        });


        Countdown_Timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mTimerRunning2) {
                    updateCountDownText2();
                    pauseTimer2();
                    k=0;
                    startTimer();
                    count2++;
                    moveb2.setText(String.valueOf(count2));
                }
                if (mTimerRunning==true){
                    Countdown_Timer.setBackgroundColor(Color.parseColor("#FF9933"));

                }
            }
        });


        Countdown_Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mTimerRunning) {
                    updateCountDownText();
                    pauseTimer();
                    startTimer2();
                    k=k+1;
                    count3++;
                    moveb3.setText(String.valueOf(count3));
                }

            }


        });


        ButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startTimer();



            }
        });

        ButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonPause.setVisibility(View.INVISIBLE);
                pauseTimer2();
                pauseTimer();

            }
        });

        ButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Reset the Timer ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                resetTimer();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Chess Watch");
                alert.show();
            }
        });


        Buttonrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (k==0){
                    startTimer();
                }
                else{
                    startTimer2();

                }
            }
        });

    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
                ButtonPause.setVisibility(View.VISIBLE);
            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
            }
        }.start();
        mTimerRunning = true;
        ButtonReset.setVisibility(View.INVISIBLE);
        Buttonrestart.setVisibility(View.INVISIBLE);
        ButtonStart.setVisibility(View.INVISIBLE);
        if (mTimerRunning==true){
            Countdown_Timer.setBackgroundColor(Color.parseColor("#FF9933"));
            Countdown_Timer.setTextColor(Color.parseColor("#FFFFFF"));
            Countdown_Timer2.setBackgroundColor(Color.parseColor("#E6E2E2"));
            Countdown_Timer2.setTextColor(Color.parseColor("#000000"));
        }

    }
    private void startTimer2() {
        mCountDownTimer2 = new CountDownTimer(mTimeLeftInMillis2, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis2 = millisUntilFinished;
                updateCountDownText2();
                ButtonPause.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFinish() {
                mTimerRunning2 = false;

            }
        }.start();
        mTimerRunning2 = true;
        ButtonReset.setVisibility(View.INVISIBLE);
        Buttonrestart.setVisibility(View.INVISIBLE);
        if (mTimerRunning2==true){
            Countdown_Timer2.setBackgroundColor(Color.parseColor("#FF9933"));
            Countdown_Timer2.setTextColor(Color.parseColor("#FFFFFF"));
            Countdown_Timer.setBackgroundColor(Color.parseColor("#E6E2E2"));
            Countdown_Timer.setTextColor(Color.parseColor("#000000"));

        }


    }
    private  void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        ButtonStart.setVisibility(View.INVISIBLE);
        ButtonReset.setVisibility(View.VISIBLE);
        Buttonrestart.setVisibility(View.VISIBLE);

    }
    private  void pauseTimer2(){
        mCountDownTimer2.cancel();
        mTimerRunning2 = false;
        ButtonStart.setVisibility(View.INVISIBLE);
        ButtonReset.setVisibility(View.VISIBLE);
        Buttonrestart.setVisibility(View.VISIBLE);
    }

    private  void  resetTimer() {
        mTimeLeftInMillis = start_time_in_millis;
        mTimeLeftInMillis2 = start_time_in_millis;
        updateCountDownText();
        updateCountDownText2();
        moveb2.setText(String.valueOf(""));
        moveb3.setText(String.valueOf(""));
        count2=0;
        count3=0;
        Countdown_Timer.setBackgroundColor(Color.parseColor("#E6E2E2"));
        Countdown_Timer.setTextColor(Color.parseColor("#000000"));
        Countdown_Timer2.setBackgroundColor(Color.parseColor("#E6E2E2"));
        Countdown_Timer2.setTextColor(Color.parseColor("#000000"));
        ButtonReset.setVisibility(View.INVISIBLE);
        ButtonStart.setVisibility(View.VISIBLE);
        Buttonrestart.setVisibility(View.INVISIBLE);
    }
    private void updateCountDownText(){

        int hours = (int) ((mTimeLeftInMillis*2) / 60000) / 60;
        int minuts = (int) (mTimeLeftInMillis / 1000) /60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%2d:%02d:%02d",hours,minuts,seconds);
        Countdown_Timer.setText(timeLeftFormatted);
        if(hours==00 && minuts==00 && seconds==00){
            toast=Toast.makeText(this,"black pieces wins",Toast.LENGTH_LONG);
            Countdown_Timer.setBackgroundColor(Color.parseColor("#FFCC0000"));
            Countdown_Timer.setTextSize(60);
            Countdown_Timer.setText(String.valueOf("Time Up!!"));
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

    }
    private void updateCountDownText2() {

        int hours2 = (int) ((mTimeLeftInMillis2*2) / 60000) / 60;
        int minuts2 = (int) (mTimeLeftInMillis2 / 1000) / 60;
        int seconds2 = (int) (mTimeLeftInMillis2 / 1000) % 60;

        String timeLeftFormatted2 = String.format(Locale.getDefault(), "%2d:%02d:%02d",hours2, minuts2, seconds2);

        Countdown_Timer2.setText(timeLeftFormatted2);
        if (hours2==00 && minuts2==00 && seconds2==00) {
            toast=Toast.makeText(Stimer.this, "white pieces wins", Toast.LENGTH_LONG);
            Countdown_Timer2.setBackgroundColor(Color.parseColor("#FFCC0000"));
            Countdown_Timer2.setTextSize(60);
            Countdown_Timer2.setText(String.valueOf("Time Up!!"));
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }
}
