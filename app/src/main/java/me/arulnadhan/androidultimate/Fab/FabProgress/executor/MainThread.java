
package me.arulnadhan.androidultimate.Fab.FabProgress.executor;

/**
 * Abstraction used to allow interactor callbacks to be executed in the main UI thread.
 */
public interface MainThread {
    void post(final Runnable runnable);
}
