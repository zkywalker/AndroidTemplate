package me.arulnadhan.androidultimate.TextSurface;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.TextSurface.activities.Align;
import me.arulnadhan.androidultimate.TextSurface.activities.ColorText;
import me.arulnadhan.androidultimate.TextSurface.activities.CookieThumper;
import me.arulnadhan.androidultimate.TextSurface.activities.Rotation3D;
import me.arulnadhan.androidultimate.TextSurface.activities.ScaleText;
import me.arulnadhan.androidultimate.TextSurface.activities.ShapeReveal;
import me.arulnadhan.androidultimate.TextSurface.activities.Slide;
import me.arulnadhan.androidultimate.TextSurface.activities.SurfaceScale;
import me.arulnadhan.androidultimate.TextSurface.activities.SurfaceTrans;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;

public class TextSurfaceMainActivity extends ThemeBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textsurf);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Text Surface");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void CT(View v) {
        startActivity(new Intent(this, CookieThumper.class));
    }

    public void ShapeReveal(View v) {
        startActivity(new Intent(this, ShapeReveal.class));
    }

    public void Align(View v) {
        startActivity(new Intent(this, Align.class));
    }

    public void Color(View v) {
        startActivity(new Intent(this, ColorText.class));
    }

    public void Scale(View v) {
        startActivity(new Intent(this, ScaleText.class));
    }

    public void Slide(View v) {
        startActivity(new Intent(this, Slide.class));
    }

    public void Rotation(View v) {
        startActivity(new Intent(this, Rotation3D.class));
    }

    public void SurfaceScale(View v) {
        startActivity(new Intent(this, SurfaceScale.class));
    }

    public void SurfaceTrans(View v) {
        startActivity(new Intent(this, SurfaceTrans.class));
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

