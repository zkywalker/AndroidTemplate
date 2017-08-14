package me.arulnadhan.recyclerview.swipeable.action;

import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.swipeable.LegacySwipeableItemAdapter;

public class LegacySwipeResultAction<VH extends RecyclerView.ViewHolder>
        extends SwipeResultAction {

    LegacySwipeableItemAdapter<VH> mAdapter;
    VH mHolder;
    int mPosition;
    int mResult;
    int mReaction;

    public LegacySwipeResultAction(
            LegacySwipeableItemAdapter<VH> adapter,
            VH holder, int position, int result, int reaction) {
        super(reaction);
        mAdapter = adapter;
        mHolder = holder;
        mPosition = position;
        mResult = result;
        mReaction = reaction;
    }

    @Override
    protected void onPerformAction() {
        mAdapter.onPerformAfterSwipeReaction(
                mHolder, mPosition, mResult, mReaction);
    }

    @Override
    protected void onCleanUp() {
        super.onCleanUp();

        mAdapter = null;
        mHolder = null;
    }
}
