package com.example.ireribrian.apartments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class startpage extends AppCompatActivity {

    private Button launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

       VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.anim));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.setLooping(true);
            }
        });
        videoView.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(startpage.this, massionatedetail.class);
                startpage.this.startActivity(mainIntent);
                startpage.this.finish();
            }
        }, 10000);

       /**launcher = (Button) findViewById(R.id.launchbutton);
       launcher.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final Intent mainIntent = new Intent(startpage.this, login.class);
               startpage.this.startActivity(mainIntent);
               startpage.this.finish();
           }
       });**/

    }
}
