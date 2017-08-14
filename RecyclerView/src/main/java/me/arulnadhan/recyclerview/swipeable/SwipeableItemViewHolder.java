package me.arulnadhan.recyclerview.swipeable;

import android.view.View;

/**
 * Interface which provides required information for swiping item.
 *
 * Implement this interface on your sub-class of the {@link android.support.v7.widget.RecyclerView.ViewHolder}.
 */
public interface SwipeableItemViewHolder {
    /**
     * Sets the state flags value for swiping item
     *
     * @param flags Bitwise OR of these flags;
     *              - {@link SwipeableItemConstants#STATE_FLAG_SWIPING}
     *              - {@link SwipeableItemConstants#STATE_FLAG_IS_ACTIVE}
     *              - {@link SwipeableItemConstants#STATE_FLAG_IS_UPDATED}
     */
    void setSwipeStateFlags(int flags);

    /**
     * Gets the state flags value for swiping item
     *
     * @return  Bitwise OR of these flags;
     *              - {@link SwipeableItemConstants#STATE_FLAG_SWIPING}
     *              - {@link SwipeableItemConstants#STATE_FLAG_IS_ACTIVE}
     *              - {@link SwipeableItemConstants#STATE_FLAG_IS_UPDATED}
     */
    int getSwipeStateFlags();

    /**
     * Sets the result code of swiping item.
     *
     * @param result Result code. One of these values;
     *              - {@link RecyclerViewSwipeManager#RESULT_NONE}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_LEFT}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_UP}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_RIGHT}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_DOWN}
     *              - {@link RecyclerViewSwipeManager#RESULT_CANCELED}
     */
    void setSwipeResult(int result);

    /**
     * Gets the result code of swiping item.
     *
     * @return Result code. One of these values;
     *              - {@link RecyclerViewSwipeManager#RESULT_NONE}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_LEFT}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_UP}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_RIGHT}
     *              - {@link RecyclerViewSwipeManager#RESULT_SWIPED_DOWN}
     *              - {@link RecyclerViewSwipeManager#RESULT_CANCELED}
     */
    int getSwipeResult();

    /**
     * Sets the reaction type of after swiping item.
     *
     * @param reaction After-reaction type. One of these values;
     *              - {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_DEFAULT}
     *              - {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_REMOVE_ITEM}
     *              - {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION}
     */
    void setAfterSwipeReaction(int reaction);

    /**
     * Gets the reaction type of after swiping item.
     *
     * @return After-reaction type. One of these values;
     *              - {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_DEFAULT}
     *              - {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_REMOVE_ITEM}
     *              - {@link RecyclerViewSwipeManager#AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION}
     */
    int getAfterSwipeReaction();

    /**
     * Sets the amount of horizontal swipe.
     *
     * @param amount Item swipe amount. Generally the range is [-1.0 .. 1.0], but these special values can be accepted;
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_LEFT}
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_RIGHT}
     */
    void setSwipeItemHorizontalSlideAmount(float amount);

    /**
     * Gets the amount of horizontal swipe.
     *
     * @return Item swipe amount. Generally the range is [-1.0 .. 1.0], but these special values may be returned;
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_LEFT}
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_RIGHT}
     */
    float getSwipeItemHorizontalSlideAmount();

    /**
     * Sets the amount of vertical swipe.
     *
     * @param amount Item swipe amount. Generally the range is [-1.0 .. 1.0], but these special values can be accepted;
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_TOP}
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_BOTTOM}
     */
    void setSwipeItemVerticalSlideAmount(float amount);

    /**
     * Gets the amount of vertical swipe.
     *
     * @return Item swipe amount. Generally the range is [-1.0 .. 1.0], but these special values may be returned;
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_TOP}
     *              - {@link RecyclerViewSwipeManager#OUTSIDE_OF_THE_WINDOW_BOTTOM}
     */
    float getSwipeItemVerticalSlideAmount();

    /**
     * Sets the maximum item left swipe amount.
     *
     * @param amount Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    void setMaxLeftSwipeAmount(float amount);

    /**
     * Gets the maximum item left swipe amount.
     *
     * @return Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    float getMaxLeftSwipeAmount();

    /**
     * Sets the maximum item up swipe amount.
     *
     * @param amount Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    void setMaxUpSwipeAmount(float amount);

    /**
     * Gets the maximum item up swipe amount.
     *
     * @return Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    float getMaxUpSwipeAmount();

    /**
     * Sets the maximum item right swipe amount.
     *
     * @param amount Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    void setMaxRightSwipeAmount(float amount);

    /**
     * Gets the maximum item right swipe amount.
     *
     * @return Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    float getMaxRightSwipeAmount();

    /**
     * Sets the maximum item down swipe amount.
     *
     * @param amount Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    void setMaxDownSwipeAmount(float amount);

    /**
     * Gets the maximum item down swipe amount.
     *
     * @return Item swipe amount. Generally the range is [-1.0 .. 1.0]
     */
    float getMaxDownSwipeAmount();

    /**
     * Gets the container view for the swipeable area.
     *
     * @return The container view instance.
     */
    View getSwipeableContainerView();

    /**
     * Called when sets background of the swiping item.
     *
     * @param horizontalAmount Horizontal slide amount of the item view. (slide left: &lt; 0, slide right: 0 &gt;)
     * @param verticalAmount Vertical slide amount of the item view. (slide up: &lt; 0, slide down: 0 &gt;)
     * @param isSwiping Indicates whether the user is swiping the item or not
     */
    void onSlideAmountUpdated(float horizontalAmount, float verticalAmount, boolean isSwiping);
}
