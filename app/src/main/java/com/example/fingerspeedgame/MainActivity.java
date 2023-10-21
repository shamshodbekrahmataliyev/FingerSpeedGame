package com.example.fingerspeedgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fingerspeedgame.R;
public class MainActivity extends AppCompatActivity {


    private TextView timerTextView;
    private   TextView aThousandTextView;
    private Button tapTapButton;

    private CountDownTimer countDownTimer;
    private long initialCountDownInMillis = 60000;

    private int timerInterval = 1000;

    private int remainingTime = 60;

    private int aThousand = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.txtTimer);
        aThousandTextView = findViewById(R.id.textAThousand);
        tapTapButton = findViewById(R.id.btnTap);

        aThousandTextView.setText(aThousand + "");

        tapTapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aThousand--;
//                aThousand = aThousand - 1;

                aThousandTextView.setText(aThousand + "");

                if (remainingTime > 0 && aThousand <= 0) ;


                Toast.makeText(MainActivity.this, "Coingratulation", Toast.LENGTH_SHORT).show();

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)

                        .setIcon(android.R.drawable.ic_dialog_map)
                        .setTitle("game over. Do you want to reinstall the game?")
                        .setMessage("Exit calls the finish method")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                                finish();
                            }

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                                Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_SHORT);
                            }



                        })
                        .show();

            }
        });

        countDownTimer = new CountDownTimer(initialCountDownInMillis,timerInterval) {
            @Override
            public void onTick(long millisUntilFinish) {

                remainingTime = (int) millisUntilFinish / 1000;
                timerTextView.setText(remainingTime + "");

            }

            @Override
            public void onFinish() {

                Toast.makeText(MainActivity.this,"Coundown finished",Toast.LENGTH_SHORT).show();
            }
        };

        countDownTimer.start();


    }
    private void resetTheGame(){
        aThousand = 1000;
        aThousandTextView.setText(Integer.toString(aThousand));

        timerTextView.setText(remainingTime + "");

        countDownTimer = new CountDownTimer(initialCountDownInMillis,timerInterval) {
            @Override
            public void onTick(long millisUntilFinished) {

                remainingTime = (int) millisUntilFinished / 1000;
                timerTextView.setText(remainingTime + "");

            }

            @Override
            public void onFinish() {



            }
        };
    }




}