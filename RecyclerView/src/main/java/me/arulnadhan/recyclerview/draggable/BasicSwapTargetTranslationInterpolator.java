package me.arulnadhan.recyclerview.draggable;


import android.view.animation.Interpolator;

public class BasicSwapTargetTranslationInterpolator implements Interpolator {
    private final float mThreshold;
    private final float mHalfValidRange;
    private final float mInvValidRange;

    public BasicSwapTargetTranslationInterpolator() {
        this(0.3f);
    }

    public BasicSwapTargetTranslationInterpolator(float threshold) {
        if (!(threshold >= 0 && threshold < 0.5f)) {
            throw new IllegalArgumentException("Invalid threshold range: " + threshold);
        }
        final float validRange = 1.0f - 2 * threshold;

        mThreshold = threshold;
        mHalfValidRange = validRange * 0.5f;
        mInvValidRange = 1.0f / validRange;
    }

    @Override
    public float getInterpolation(float input) {
        if (Math.abs(input - 0.5f) < mHalfValidRange) {
            return (input - mThreshold) * mInvValidRange;
        } else {
            return (input < 0.5f) ? 0.0f : 1.0f;
        }
    }
}
