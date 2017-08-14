package me.arulnadhan.androidultimate.AppIntro.indicators;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.arulnadhan.androidultimate.AppIntro.AppIntroMainActivity;
import me.arulnadhan.androidultimate.AppIntro.SampleSlide;
import me.arulnadhan.androidultimate.R;
import me.arulnadhan.appintro.AppIntro;
import me.arulnadhan.appintro.IndicatorController;


public class CustomIndicator extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));

        setCustomIndicator(new CustomIndicatorController());
    }

    private void loadMainActivity() {
        Intent intent = new Intent(this, AppIntroMainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSkipPressed() {
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    public void getStarted(View v) {
        loadMainActivity();
    }

    private class CustomIndicatorController implements IndicatorController {
        private TextView mTextView;
        private int mSlideCount;

        private static final int FIRST_PAGE_NUM = 0;

        @Override
        public View newInstance(@NonNull Context context) {
            mTextView = (TextView) View.inflate(context, R.layout.custom_indicator, null);
            return mTextView;
        }

        @Override
        public void initialize(int slideCount) {
            mSlideCount = slideCount;
            selectPosition(FIRST_PAGE_NUM);
        }

        @Override
        public void selectPosition(int index) {
            mTextView.setText(String.format("%d/%d", index + 1, mSlideCount));
        }
    }
}
