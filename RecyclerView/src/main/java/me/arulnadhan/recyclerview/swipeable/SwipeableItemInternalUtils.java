package me.arulnadhan.recyclerview.swipeable;

import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.swipeable.action.LegacySwipeResultAction;
import me.arulnadhan.recyclerview.swipeable.action.SwipeResultAction;

public class SwipeableItemInternalUtils {
    private SwipeableItemInternalUtils() {
    }

    @SuppressWarnings("unchecked")
    public static SwipeResultAction invokeOnSwipeItem(
            BaseSwipeableItemAdapter<?> adapter, RecyclerView.ViewHolder holder, int position, int result) {

        if (adapter instanceof LegacySwipeableItemAdapter) {

            int reaction = ((LegacySwipeableItemAdapter) adapter).onSwipeItem(
                    holder, position, result);

            switch (reaction) {
                case RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_DEFAULT:
                case RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION:
                case RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_REMOVE_ITEM:
                    //noinspection deprecation
                    return new LegacySwipeResultAction<>(
                            (LegacySwipeableItemAdapter) adapter,
                            holder, position, result, reaction);
                default:
                    throw new IllegalStateException("Unexpected reaction type: " + reaction);
            }
        } else {
            return ((SwipeableItemAdapter) adapter).onSwipeItem(holder, position, result);
        }
    }
}
