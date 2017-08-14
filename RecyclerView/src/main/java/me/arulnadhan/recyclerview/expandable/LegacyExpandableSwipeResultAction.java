package me.arulnadhan.recyclerview.expandable;

import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.swipeable.action.SwipeResultAction;

public class LegacyExpandableSwipeResultAction<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder>
        extends SwipeResultAction {

    LegacyExpandableSwipeableItemAdapter<GVH, CVH> mAdapter;
    RecyclerView.ViewHolder mHolder;
    int mGroupPosition;
    int mChildPosition;
    int mResult;
    int mReaction;

    public LegacyExpandableSwipeResultAction(
            LegacyExpandableSwipeableItemAdapter<GVH, CVH> adapter,
            RecyclerView.ViewHolder holder, int groupPosition, int childPosition, int result, int reaction) {
        super(reaction);
        mAdapter = adapter;
        mHolder = holder;
        mGroupPosition = groupPosition;
        mChildPosition = childPosition;
        mResult = result;
        mReaction = reaction;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onPerformAction() {
        if (mChildPosition == RecyclerView.NO_POSITION) {
            mAdapter.onPerformAfterSwipeGroupReaction(
                    (GVH) mHolder, mGroupPosition, mResult, mReaction);
        } else {
            mAdapter.onPerformAfterSwipeChildReaction(
                    (CVH) mHolder, mGroupPosition, mChildPosition, mResult, mReaction);
        }
    }

    @Override
    protected void onCleanUp() {
        super.onCleanUp();

        mAdapter = null;
        mHolder = null;
    }
}
