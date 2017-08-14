package me.arulnadhan.androidultimate.Fab.FabReveal;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mikepenz.iconics.context.IconicsContextWrapper;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.fabreveal.FABRevealLayout;
import me.arulnadhan.fabreveal.OnRevealChangeListener;

public class FabRevealActivity extends ThemeBaseActivity {

    private FABRevealLayout fabRevealLayout;
    private TextView albumTitleText;
    private TextView artistNameText;
    private SeekBar songProgress;
    private TextView songTitleText;
    private ImageView prev;
    private ImageView stop;
    private ImageView next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabreveal);
        findViews();
        configureFABReveal();
    }

    private void findViews() {
        fabRevealLayout = (FABRevealLayout) findViewById(R.id.fab_reveal_layout);
        albumTitleText = (TextView) findViewById(R.id.album_title_text);
        artistNameText = (TextView) findViewById(R.id.artist_name_text);
        songProgress = (SeekBar) findViewById(R.id.song_progress_bar);
        styleSeekbar(songProgress);

        songTitleText = (TextView) findViewById(R.id.song_title_text);
        prev = (ImageView) findViewById(R.id.previous);
        stop = (ImageView) findViewById(R.id.stop);
        next = (ImageView) findViewById(R.id.next);
    }

    private void styleSeekbar(SeekBar songProgress) {
        int color = getResources().getColor(R.color.reveal);
        songProgress.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        songProgress.getThumb().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }

    private void configureFABReveal() {
        fabRevealLayout.setOnRevealChangeListener(new OnRevealChangeListener() {
            @Override
            public void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView) {
                showMainViewItems();
            }

            @Override
            public void onSecondaryViewAppeared(final FABRevealLayout fabRevealLayout, View secondaryView) {
                showSecondaryViewItems();
                prepareBackTransition(fabRevealLayout);
            }
        });
    }

    private void showMainViewItems() {
        scale(albumTitleText, 50);
        scale(artistNameText, 150);
    }

    private void showSecondaryViewItems() {
        scale(songProgress, 0);
        animateSeekBar(songProgress);
        scale(songTitleText, 100);
        scale(prev, 150);
        scale(stop, 100);
        scale(next, 200);
    }

    private void prepareBackTransition(final FABRevealLayout fabRevealLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fabRevealLayout.revealMainView();
            }
        }, 5000);
    }

    private void scale(View view, long delay) {
        view.setScaleX(0);
        view.setScaleY(0);
        view.animate()
                .scaleX(1)
                .scaleY(1)
                .setDuration(500)
                .setStartDelay(delay)
                .setInterpolator(new OvershootInterpolator())
                .start();
    }

    private void animateSeekBar(SeekBar seekBar) {
        seekBar.setProgress(15);
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(seekBar, "progress", 15, 0);
        progressAnimator.setDuration(300);
        progressAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        progressAnimator.start();
    }
}
