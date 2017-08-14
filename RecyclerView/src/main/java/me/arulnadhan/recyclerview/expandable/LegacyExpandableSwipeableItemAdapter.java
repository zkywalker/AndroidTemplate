package me.arulnadhan.recyclerview.expandable;

import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.swipeable.RecyclerViewSwipeManager;

public interface LegacyExpandableSwipeableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder>
        extends BaseExpandableSwipeableItemAdapter<GVH, CVH> {

    /**
     * <p>Called when group item is swiped.</p>
     * <p>*Note that do not change data set and do not call notifyDataXXX() methods inside of this method.*</p>
     *
     * @param holder        The ViewHolder which is associated to the swiped item.
     * @param groupPosition Group position.
     * @param result        The result code of user's swipe operation.
     *                      {@link RecyclerViewSwipeManager#RESULT_CANCELED},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_LEFT},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_UP},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_RIGHT} or
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_DOWN}
     * @return Reaction type of after swiping.
     * One of the {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_DEFAULT},
     * {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION} or
     * {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_REMOVE_ITEM}.
     */
    int onSwipeGroupItem(GVH holder, int groupPosition, int result);

    /**
     * <p>Called when child item is swiped.</p>
     * <p>*Note that do not change data set and do not call notifyDataXXX() methods inside of this method.*</p>
     *
     * @param holder        The ViewHolder which is associated to the swiped item.
     * @param groupPosition Group position.
     * @param childPosition Child position.
     * @param result        The result code of user's swipe operation.
     *                      {@link RecyclerViewSwipeManager#RESULT_CANCELED},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_LEFT},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_UP},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_RIGHT} or
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_DOWN}
     * @return Reaction type of after swiping.
     * One of the {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_DEFAULT},
     * {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION} or
     * {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_REMOVE_ITEM}.
     */
    int onSwipeChildItem(CVH holder, int groupPosition, int childPosition, int result);

    /**
     * <p>Called after {@link #onSwipeGroupItem(android.support.v7.widget.RecyclerView.ViewHolder, int, int)} method.</p>
     * <p>You can update data set and call notifyDataXXX() methods inside of this method.</p>
     *
     * @param holder        The ViewHolder which is associated to the swiped item.
     * @param groupPosition Group position.
     * @param result        The result code of user's swipe operation.
     *                      {@link RecyclerViewSwipeManager#RESULT_CANCELED},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_LEFT},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_UP},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_RIGHT} or
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_DOWN}
     * @param reaction      Reaction type. One of the {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_DEFAULT},
     *                      {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION} or
     *                      {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_REMOVE_ITEM}.
     */
    void onPerformAfterSwipeGroupReaction(GVH holder, int groupPosition, int result, int reaction);


    /**
     * <p>Called after {@link #onSwipeChildItem(android.support.v7.widget.RecyclerView.ViewHolder, int, int, int)} method.</p>
     * <p>You can update data set and call notifyDataXXX() methods inside of this method.</p>
     *
     * @param holder        The ViewHolder which is associated to the swiped item.
     * @param groupPosition Group position.
     * @param childPosition Child position.
     * @param result        The result code of user's swipe operation.
     *                      {@link RecyclerViewSwipeManager#RESULT_CANCELED},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_LEFT},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_UP},
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_RIGHT} or
     *                      {@link RecyclerViewSwipeManager#RESULT_SWIPED_DOWN}
     * @param reaction      Reaction type. One of the {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_DEFAULT},
     *                      {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION} or
     *                      {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_REMOVE_ITEM}.
     */
    void onPerformAfterSwipeChildReaction(CVH holder, int groupPosition, int childPosition, int result, int reaction);
}
