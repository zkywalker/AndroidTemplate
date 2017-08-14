package me.arulnadhan.recyclerview.swipeable;

import android.view.animation.Interpolator;

class RubberBandInterpolator implements Interpolator {
    private final float mLimit;

    public RubberBandInterpolator(float limit) {
        mLimit = limit;
    }

    @Override
    public float getInterpolation(float input) {
        final float t = (1 - input);
        return mLimit * (1 - (t * t));
    }
}
