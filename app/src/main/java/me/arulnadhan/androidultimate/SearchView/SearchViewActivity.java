package me.arulnadhan.androidultimate.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.R;

public class SearchViewActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView defaultButton;
    private CardView themedButton;
    private CardView voiceButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search View");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        defaultButton = (CardView) findViewById(R.id.button_default);
        defaultButton.setOnClickListener(this);
        themedButton = (CardView) findViewById(R.id.button_themed);
        themedButton.setOnClickListener(this);
        voiceButton = (CardView) findViewById(R.id.button_voice);
        voiceButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button_default:
                intent = new Intent(this, DefaultActivity.class);
                break;
            case R.id.button_themed:
                intent = new Intent(this, ColoredActivity.class);
                break;
            case R.id.button_voice:
                intent = new Intent(this, VoiceActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
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
