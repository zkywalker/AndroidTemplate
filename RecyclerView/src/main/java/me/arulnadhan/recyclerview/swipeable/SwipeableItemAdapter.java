package me.arulnadhan.recyclerview.swipeable;

import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.swipeable.action.SwipeResultAction;
import me.arulnadhan.recyclerview.swipeable.annotation.SwipeableItemResults;

public interface SwipeableItemAdapter<T extends RecyclerView.ViewHolder> extends BaseSwipeableItemAdapter<T> {
    /**
     * Called when item is swiped.
     *
     * *Note that do not change the data set and do not call notifyDataXXX() methods inside of this method.*
     *
     * @param holder The ViewHolder which is associated to the swiped item.
     * @param position The position of the item within the adapter's data set.
     * @param result The result code of user's swipe operation.
     *              {@link SwipeableItemConstants#RESULT_CANCELED},
     *              {@link SwipeableItemConstants#RESULT_SWIPED_LEFT},
     *              {@link SwipeableItemConstants#RESULT_SWIPED_UP},
     *              {@link SwipeableItemConstants#RESULT_SWIPED_RIGHT} or
     *              {@link SwipeableItemConstants#RESULT_SWIPED_DOWN}
     *
     * @return Result action.
     */
    SwipeResultAction onSwipeItem(T holder, int position, @SwipeableItemResults int result);
}
