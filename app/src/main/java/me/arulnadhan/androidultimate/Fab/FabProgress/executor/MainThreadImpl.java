
package me.arulnadhan.androidultimate.Fab.FabProgress.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * {@link MainThread} implementation. Will make
 * interactor Callbacks able to get executed in the Android UI thread
 */
public class MainThreadImpl implements MainThread {

    private Handler handler;

    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
