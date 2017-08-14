
package me.arulnadhan.androidultimate.Fab.FabProgress.interactor;

import me.arulnadhan.androidultimate.Fab.FabProgress.executor.Interactor;
import me.arulnadhan.androidultimate.Fab.FabProgress.executor.MainThread;
import me.arulnadhan.androidultimate.Fab.FabProgress.executor.MainThreadImpl;


public class MockAction implements Interactor {

    private MockActionCallback callback;
    private MainThread mainThread;

    public MockAction(MockActionCallback callback) {
        this.callback = callback;
        this.mainThread = new MainThreadImpl();
    }

    @Override
    public void run() {
        mockLoadingTime();
        notifyActionComplete();
    }

    private void mockLoadingTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //Empty
        }
    }

    private void notifyActionComplete() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onMockActionComplete();
            }
        });
    }
}
