package me.arulnadhan.sweetsheet.sweetpick;

import android.view.ViewGroup;
import android.widget.ImageView;

public class NoneEffect implements Effect  {
    @Override
    public float getValue() {
        return 0;
    }
    @Override
    public void effect(ViewGroup vp, ImageView view) {

    }
}
