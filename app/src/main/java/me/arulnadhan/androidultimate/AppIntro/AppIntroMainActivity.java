package me.arulnadhan.androidultimate.AppIntro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.AppIntro.animations.CustomAnimation;
import me.arulnadhan.androidultimate.AppIntro.animations.DepthAnimation;
import me.arulnadhan.androidultimate.AppIntro.animations.FadeAnimation;
import me.arulnadhan.androidultimate.AppIntro.animations.FlowAnimation;
import me.arulnadhan.androidultimate.AppIntro.animations.SlideOverAnimation;
import me.arulnadhan.androidultimate.AppIntro.animations.ZoomAnimation;
import me.arulnadhan.androidultimate.AppIntro.indicators.CustomIndicator;
import me.arulnadhan.androidultimate.AppIntro.indicators.ProgressIndicator;
import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;


public class AppIntroMainActivity extends ThemeBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appintro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("App Intro");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void startDefaultIntro(View v) {
        Intent intent = new Intent(this, DefaultIntro.class);
        startActivity(intent);
        finish();
    }

    public void startCustomIntro(View v) {
        Intent intent = new Intent(this, CustomIntro.class);
        startActivity(intent);
        finish();
    }

    public void startSecondLayoutIntro(View v) {
        Intent intent = new Intent(this, SecondLayoutIntro.class);
        startActivity(intent);
        finish();
    }

    public void startFadeAnimation(View v) {
        Intent intent = new Intent(this, FadeAnimation.class);
        startActivity(intent);
        finish();
    }

    public void startZoomAnimation(View v) {
        Intent intent = new Intent(this, ZoomAnimation.class);
        startActivity(intent);
        finish();
    }

    public void startFlowAnimation(View v) {
        Intent intent = new Intent(this, FlowAnimation.class);
        startActivity(intent);
        finish();
    }

    public void startDepthAnimation(View v) {
        Intent intent = new Intent(this, DepthAnimation.class);
        startActivity(intent);
        finish();
    }

    public void startSlideOverAnimation(View v) {
        Intent intent = new Intent(this, SlideOverAnimation.class);
        startActivity(intent);
        finish();
    }

    public void startCustomAnimation(View v) {
        Intent intent = new Intent(this, CustomAnimation.class);
        startActivity(intent);
        finish();
    }

    public void startProgressIndicator(View v) {
        Intent intent = new Intent(this, ProgressIndicator.class);
        startActivity(intent);
        finish();
    }

    public void startCustomIndicator(View v) {
        Intent intent = new Intent(this, CustomIndicator.class);
        startActivity(intent);
        finish();
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