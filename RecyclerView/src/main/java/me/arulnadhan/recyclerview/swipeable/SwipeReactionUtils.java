package me.arulnadhan.recyclerview.swipeable;

class SwipeReactionUtils {
    public static int extractLeftReaction(int type) {
        return ((type >>> InternalConstants.BIT_SHIFT_AMOUNT_LEFT) & InternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static int extractUpReaction(int type) {
        return ((type >>> InternalConstants.BIT_SHIFT_AMOUNT_UP) & InternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static int extractRightReaction(int type) {
        return ((type >>> InternalConstants.BIT_SHIFT_AMOUNT_RIGHT) & InternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static int extractDownReaction(int type) {
        return ((type >>> InternalConstants.BIT_SHIFT_AMOUNT_DOWN) & InternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static boolean canSwipeLeft(int reactionType) {
        return (extractLeftReaction(reactionType) == InternalConstants.REACTION_CAN_SWIPE);
    }

    public static boolean canSwipeUp(int reactionType) {
        return (extractUpReaction(reactionType) == InternalConstants.REACTION_CAN_SWIPE);
    }

    public static boolean canSwipeRight(int reactionType) {
        return (extractRightReaction(reactionType) == InternalConstants.REACTION_CAN_SWIPE);
    }

    public static boolean canSwipeDown(int reactionType) {
        return (extractDownReaction(reactionType) == InternalConstants.REACTION_CAN_SWIPE);
    }
}
