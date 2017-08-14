package me.arulnadhan.androidultimate.Login;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;

import me.arulnadhan.androidultimate.R;

public class Login_video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_video);
        EditText email = (EditText) findViewById(R.id.input_email);
        email.requestFocus();

        VideoView video = (VideoView) findViewById(R.id.login_video);
        Uri videoUri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.login_video);
        video.setVideoURI(videoUri);
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    public void submit(View v) {
        Snackbar.make(v, "Submiting...", Snackbar.LENGTH_LONG).show();
    }

}
