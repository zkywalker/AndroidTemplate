package me.arulnadhan.androidultimate.Fab.FabDownload;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.fabdownload.ArrowDownloadButton;


public class FabDownloadActivity extends ThemeBaseActivity {

    int count = 0;
    int progress = 0;
    ArrowDownloadButton button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabdownload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fab Download");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (ArrowDownloadButton) findViewById(R.id.arrow_download_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((count % 2) == 0) {
                    button.startAnimating();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progress = progress + 1;
                                    button.setProgress(progress);
                                }
                            });
                        }
                    }, 800, 20);
                } else {
                    button.reset();
                }
                count++;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
