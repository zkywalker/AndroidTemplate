package me.arulnadhan.recyclerview.expandable;

import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.swipeable.RecyclerViewSwipeManager;
import me.arulnadhan.recyclerview.swipeable.action.SwipeResultAction;

class ExpandableSwipeableItemInternalUtils {
    private ExpandableSwipeableItemInternalUtils() {
    }

    @SuppressWarnings("unchecked")
    public static SwipeResultAction invokeOnSwipeItem(
            BaseExpandableSwipeableItemAdapter<?, ?> adapter, RecyclerView.ViewHolder holder,
            int groupPosition, int childPosition, int result) {

        if (adapter instanceof LegacyExpandableSwipeableItemAdapter) {
            int reaction;

            if (childPosition == RecyclerView.NO_POSITION) {
                reaction = ((LegacyExpandableSwipeableItemAdapter) adapter).onSwipeGroupItem(
                        holder, groupPosition, result);
            } else {
                reaction = ((LegacyExpandableSwipeableItemAdapter) adapter).onSwipeChildItem(
                        holder, groupPosition, childPosition, result);
            }

            switch (reaction) {
                case RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_DEFAULT:
                case RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION:
                case RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_REMOVE_ITEM:
                    //noinspection deprecation
                    return new LegacyExpandableSwipeResultAction<>(
                            (LegacyExpandableSwipeableItemAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder>) adapter,
                            holder, groupPosition, childPosition, result, reaction);
                default:
                    throw new IllegalStateException("Unexpected reaction type: " + reaction);
            }
        } else {
            if (childPosition == RecyclerView.NO_POSITION) {
                return ((ExpandableSwipeableItemAdapter) adapter).onSwipeGroupItem(holder, groupPosition, result);
            } else {
                return ((ExpandableSwipeableItemAdapter) adapter).onSwipeChildItem(holder, groupPosition, childPosition, result);
            }
        }
    }
}
