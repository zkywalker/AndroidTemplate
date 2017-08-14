package me.arulnadhan.recyclerview.swipeable.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import me.arulnadhan.recyclerview.swipeable.SwipeableItemConstants;

@IntDef(flag = true, value = {
        SwipeableItemConstants.STATE_FLAG_SWIPING,
        SwipeableItemConstants.STATE_FLAG_IS_ACTIVE,
        SwipeableItemConstants.STATE_FLAG_IS_UPDATED,
})
@Retention(RetentionPolicy.SOURCE)
public @interface SwipeableItemStateFlags {
}
