package me.arulnadhan.recyclerview.swipeable.action;

import me.arulnadhan.recyclerview.swipeable.RecyclerViewSwipeManager;

public abstract class SwipeResultActionMoveToSwipedDirection extends SwipeResultAction {
    public SwipeResultActionMoveToSwipedDirection() {
        super(RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION);
    }
}
