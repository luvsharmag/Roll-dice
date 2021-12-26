package com.example.rolldice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private Random random = new Random();
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        mediaPlayer = MediaPlayer.create(this,R.raw.music1);
        mediaPlayer1 = MediaPlayer.create(this,R.raw.music);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rolldice();
                mediaPlayer1.seekTo(0);
                mediaPlayer1.start();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imageView.setImageResource(R.drawable.ic_baseline_volume_off_24);
                }else{
                    mediaPlayer.start();
                    imageView.setImageResource(R.drawable.ic_baseline_volume_down_24);
                }
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });
    }
    private void rolldice(){
        int roll = random.nextInt(6)+1;
        switch (roll){
            case 1:
                imageView2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageView2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageView2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageView2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageView2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageView2.setImageResource(R.drawable.dice6);
                break;
        }
    }

}