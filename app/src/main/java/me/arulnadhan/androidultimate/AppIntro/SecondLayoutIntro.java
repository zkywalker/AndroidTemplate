package me.arulnadhan.androidultimate.AppIntro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.appintro.AppIntro2;

public class SecondLayoutIntro extends AppIntro2 {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro_2));
        addSlide(SampleSlide.newInstance(R.layout.intro2_2));
        addSlide(SampleSlide.newInstance(R.layout.intro3_2));
    }

    private void loadMainActivity() {
        Intent intent = new Intent(this, AppIntroMainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    public void getStarted(View v) {
        loadMainActivity();
    }
}
