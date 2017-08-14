package me.arulnadhan.androidultimate.Home;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;


public class ResizeAnimationHeight extends Animation {

    private int startHeight;
    private int deltaHeight; // distance between start and end height
    private View view;

    public ResizeAnimationHeight() {

    }

    public void setView(View v) {
        this.view = v;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        view.getLayoutParams().height = (int) (startHeight + deltaHeight * interpolatedTime);
        view.requestLayout();
    }

    public void setParams(int start, int end) {
        this.startHeight = start;
        deltaHeight = end - startHeight;
    }

    @Override
    public void setDuration(long durationMillis) {
        super.setDuration(durationMillis);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}