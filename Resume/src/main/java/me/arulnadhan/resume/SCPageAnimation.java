package me.arulnadhan.resume;

import android.view.View;


public abstract class SCPageAnimation {
    public int page;
    public abstract void applyTransformation(View onView, float positionOffset);
}