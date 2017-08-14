package me.arulnadhan.androidultimate.ElasticDownload;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.elasticdownload.ElasticDownloadView;
import me.arulnadhan.elasticdownload.ProgressDownloadView;

public class ElasticDownloadActivity extends ThemeBaseActivity {

    ElasticDownloadView mElasticDownloadView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elasticdownload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Elastic Download");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mElasticDownloadView = (ElasticDownloadView) findViewById(R.id.elastic_download_view);
    }

    public void action_run_fail_animation(View v) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mElasticDownloadView.startIntro();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mElasticDownloadView.setProgress(45);
            }
        }, 2 * ProgressDownloadView.ANIMATION_DURATION_BASE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mElasticDownloadView.fail();
            }
        }, 3 * ProgressDownloadView.ANIMATION_DURATION_BASE);
    }

    public void action_run_success_animation(View v) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mElasticDownloadView.startIntro();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mElasticDownloadView.success();
            }
        }, 2 * ProgressDownloadView.ANIMATION_DURATION_BASE);

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
