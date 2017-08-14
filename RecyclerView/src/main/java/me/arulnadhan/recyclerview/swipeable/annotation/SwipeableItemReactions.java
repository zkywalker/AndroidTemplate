package me.arulnadhan.recyclerview.swipeable.annotation;

import android.annotation.SuppressLint;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import me.arulnadhan.recyclerview.swipeable.SwipeableItemConstants;

@SuppressWarnings("deprecation")
@SuppressLint("UniqueConstants")
@IntDef(flag = true, value = {
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_ANY,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_LEFT,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_LEFT_WITH_RUBBER_BAND_EFFECT,
        SwipeableItemConstants.REACTION_CAN_SWIPE_LEFT,
        SwipeableItemConstants.REACTION_MASK_START_SWIPE_LEFT,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_UP,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_UP_WITH_RUBBER_BAND_EFFECT,
        SwipeableItemConstants.REACTION_CAN_SWIPE_UP,
        SwipeableItemConstants.REACTION_MASK_START_SWIPE_UP,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_RIGHT,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_RIGHT_WITH_RUBBER_BAND_EFFECT,
        SwipeableItemConstants.REACTION_CAN_SWIPE_RIGHT,
        SwipeableItemConstants.REACTION_MASK_START_SWIPE_RIGHT,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_DOWN,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_DOWN_WITH_RUBBER_BAND_EFFECT,
        SwipeableItemConstants.REACTION_CAN_SWIPE_DOWN,
        SwipeableItemConstants.REACTION_MASK_START_SWIPE_DOWN,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_BOTH_H,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_BOTH_H_WITH_RUBBER_BAND_EFFECT,
        SwipeableItemConstants.REACTION_CAN_SWIPE_BOTH_H,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_BOTH_V,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_BOTH_V_WITH_RUBBER_BAND_EFFECT,
        SwipeableItemConstants.REACTION_CAN_SWIPE_BOTH_V,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_BOTH,
        SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_BOTH_WITH_RUBBER_BAND_EFFECT,
        SwipeableItemConstants.REACTION_CAN_SWIPE_BOTH,
        SwipeableItemConstants.REACTION_START_SWIPE_ON_LONG_PRESS,
})
@Retention(RetentionPolicy.SOURCE)
public @interface SwipeableItemReactions {
}
