package me.arulnadhan.androidultimate.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;

public class LoginActivity extends ThemeBaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void LoginAnim(View v) {
        Intent intent = new Intent(this, Login_anim.class);
        startActivity(intent);
    }


    public void LoginSocial(View v) {
        Intent intent = new Intent(this, Login_social.class);
        startActivity(intent);
    }

    public void VideoLogin(View v) {
        Intent intent = new Intent(this, Login_video.class);
        startActivity(intent);
    }

    public void MLogin(View v) {
        Intent intent = new Intent(this, Login_material.class);
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
