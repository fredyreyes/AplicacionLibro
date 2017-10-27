package com.example.fredy.aplicacionlibro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {


    VideoView videoIntro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //getSupportActionBar().hide();
     videoIntro=(VideoView)findViewById(R.id.idVideoIntro);
        Uri urlVideo=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.animacion);
        videoIntro.setVideoURI(urlVideo);
        videoIntro.start();
        videoIntro.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
             startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                finish();
            }
        });
    }
}
