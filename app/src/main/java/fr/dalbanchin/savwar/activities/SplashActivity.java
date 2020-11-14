package fr.dalbanchin.savwar.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.IOException;

import fr.dalbanchin.savwar.R;


public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private static int splashTimeOut=3500;
    MediaPlayer splashSong;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo=(ImageView)findViewById(R.id.logo);

        splashSong = MediaPlayer.create(this, R.raw.goutte);

        splashSong.setVolume(0.4f,0.4f);

        splashSong.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
        logo.startAnimation(myanim);
    }
}