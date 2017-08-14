package me.arulnadhan.recyclerview.event;

import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;

/**
 * Deprecated.
 *
 * Please use {@link RecyclerView#addOnScrollListener(RecyclerView.OnScrollListener)} and {@link RecyclerView#removeOnScrollListener(RecyclerView.OnScrollListener)} instead.
 */
@Deprecated
public class RecyclerViewOnScrollEventDistributor extends BaseRecyclerViewEventDistributor<RecyclerView.OnScrollListener> {

    private InternalOnScrollListener mInternalOnScrollListener;

    public RecyclerViewOnScrollEventDistributor() {
        super();

        mInternalOnScrollListener = new InternalOnScrollListener(this);
    }

    @Override
    protected void onRecyclerViewAttached(RecyclerView rv) {
        super.onRecyclerViewAttached(rv);

        rv.addOnScrollListener(mInternalOnScrollListener);
    }

    @Override
    protected void onRelease() {
        if (mInternalOnScrollListener != null) {
            if (mRecyclerView != null) {
                mRecyclerView.removeOnScrollListener(mInternalOnScrollListener);
            }
            mInternalOnScrollListener.release();
            mInternalOnScrollListener = null;
        }

        super.onRelease();
    }

    /*package*/ void handleOnScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (mListeners == null) {
            return;
        }

        for (RecyclerView.OnScrollListener listener : mListeners) {
            listener.onScrollStateChanged(recyclerView, newState);
        }
    }

    /*package*/ void handleOnScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (mListeners == null) {
            return;
        }

        for (RecyclerView.OnScrollListener listener : mListeners) {
            listener.onScrolled(recyclerView, dx, dy);
        }
    }

    @SuppressWarnings("deprecation")
    private static class InternalOnScrollListener extends RecyclerView.OnScrollListener {
        private WeakReference<RecyclerViewOnScrollEventDistributor> mRefDistributor;

        public InternalOnScrollListener(RecyclerViewOnScrollEventDistributor distributor) {
            super();
            mRefDistributor = new WeakReference<>(distributor);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            final RecyclerViewOnScrollEventDistributor distributor = mRefDistributor.get();
            if (distributor != null) {
                distributor.handleOnScrollStateChanged(recyclerView, newState);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            final RecyclerViewOnScrollEventDistributor holder = mRefDistributor.get();
            if (holder != null) {
                holder.handleOnScrolled(recyclerView, dx, dy);
            }
        }

        public void release() {
            mRefDistributor.clear();
        }
    }
}
