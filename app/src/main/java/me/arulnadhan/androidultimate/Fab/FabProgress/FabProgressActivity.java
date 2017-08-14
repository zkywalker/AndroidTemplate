package me.arulnadhan.androidultimate.Fab.FabProgress;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.squareup.picasso.Picasso;

import me.arulnadhan.androidultimate.Fab.FabProgress.executor.ThreadExecutor;
import me.arulnadhan.androidultimate.Fab.FabProgress.interactor.MockAction;
import me.arulnadhan.androidultimate.Fab.FabProgress.interactor.MockActionCallback;
import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.fabprogress.FABProgressCircle;
import me.arulnadhan.fabprogress.listeners.FABProgressListener;

public class FabProgressActivity extends ThemeBaseActivity implements MockActionCallback, FABProgressListener {

    private FABProgressCircle fabProgressCircle;
    private boolean taskRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabprogress);
        initViews();
        loadAvatar();
        attachListeners();
    }

    private void initViews() {
        fabProgressCircle = (FABProgressCircle) findViewById(R.id.fabProgressCircle);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }

    private void loadAvatar() {
        ImageView avatarView = (ImageView) findViewById(R.id.avatar);

        Picasso.with(this)
                .load(R.drawable.profile)
                .into(avatarView);
    }

    private void attachListeners() {
        fabProgressCircle.attachListener(this);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!taskRunning) {
                    fabProgressCircle.show();
                    runMockInteractor();
                }
            }
        });
        Snackbar.make(fabProgressCircle, "Press on the Fab Above to check the progress!", Snackbar.LENGTH_LONG).show();

    }

    private void runMockInteractor() {
        ThreadExecutor executor = new ThreadExecutor();
        executor.run(new MockAction(this));
        taskRunning = true;
    }

    @Override
    public void onMockActionComplete() {
        taskRunning = false;
        fabProgressCircle.beginFinalAnimation();
        //fabProgressCircle.hide();
    }

    @Override
    public void onFABProgressAnimationEnd() {
        Snackbar.make(fabProgressCircle, "Download Completed :P", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }
}