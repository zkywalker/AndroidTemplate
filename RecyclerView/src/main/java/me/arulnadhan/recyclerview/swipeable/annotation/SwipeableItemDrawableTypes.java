package me.arulnadhan.recyclerview.swipeable.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import me.arulnadhan.recyclerview.swipeable.SwipeableItemConstants;

@IntDef(flag = false, value = {
        SwipeableItemConstants.DRAWABLE_SWIPE_NEUTRAL_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_LEFT_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_UP_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_RIGHT_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_DOWN_BACKGROUND,
})
@Retention(RetentionPolicy.SOURCE)
public @interface SwipeableItemDrawableTypes {
}
