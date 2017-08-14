package me.arulnadhan.androidultimate.Fab.FabMenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;

public class FabMenuActivity extends ThemeBaseActivity implements View.OnClickListener {

    private FloatingActionButton menuBase;

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabmenu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fab Menu");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        menuBase = (FloatingActionButton) findViewById(R.id.fabMenu);
        menuBase.setOnClickListener(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            FABMenuUtil.setupFABMenu(menuBase,
                    new int[]{R.drawable.twitter, R.drawable.googleplus, R.drawable.pinterest},
                    R.style.AppTheme_FABMenu,
                    this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FABMenuUtil.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FABMenuUtil.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == menuBase.getId()) {
            FABMenuUtil.triggerMenu();
        }
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
