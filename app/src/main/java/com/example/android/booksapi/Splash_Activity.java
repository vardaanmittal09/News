package com.example.android.booksapi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

public class Splash_Activity extends AppCompatActivity {
    VideoView videoView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_);
       // getSupportActionBar().hide();
        videoView=(VideoView)findViewById(R.id.videoView);
        Uri video=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.news);
        videoView.setVideoURI(video);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if(isFinishing()){
                    return;
                }
                startActivity(new Intent(Splash_Activity.this,TAbbed.class));
                finish();
            }
        });
        videoView.start();
    }
}
