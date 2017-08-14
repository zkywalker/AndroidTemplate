package me.arulnadhan.androidultimate.Fab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.Fab.FABToolbar.FABToolbarActivity;
import me.arulnadhan.androidultimate.Fab.FabDownload.FabDownloadActivity;
import me.arulnadhan.androidultimate.Fab.FabLoading.FabLoadingActivity;
import me.arulnadhan.androidultimate.Fab.FabMenu.FabMenuActivity;
import me.arulnadhan.androidultimate.Fab.FabProgress.FabProgressActivity;
import me.arulnadhan.androidultimate.Fab.FabReveal.FabRevealActivity;
import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;

public class FabMainActivity extends ThemeBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fab");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void FabLoader(View v) {
        Intent intent = new Intent(this, FabLoadingActivity.class);
        startActivity(intent);
    }


    public void FABDownload(View v) {
        Intent intent = new Intent(this, FabDownloadActivity.class);
        startActivity(intent);
    }


    public void FABProgress(View v) {
        Intent intent = new Intent(this, FabProgressActivity.class);
        startActivity(intent);
    }


    public void FABReveal(View v) {
        Intent intent = new Intent(this, FabRevealActivity.class);
        startActivity(intent);
    }

    public void FABMenu(View v) {
        Intent intent = new Intent(this, FabMenuActivity.class);
        startActivity(intent);
    }

    public void FABToolbar(View v) {
        Intent intent = new Intent(this, FABToolbarActivity.class);
        startActivity(intent);
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
