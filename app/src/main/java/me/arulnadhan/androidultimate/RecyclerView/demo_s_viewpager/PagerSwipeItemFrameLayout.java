package me.arulnadhan.androidultimate.RecyclerView.demo_s_viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class PagerSwipeItemFrameLayout extends FrameLayout {
    private boolean mCanSwipeLeft;
    private boolean mCanSwipeRight;

    public PagerSwipeItemFrameLayout(Context context) {
        super(context);
    }

    public PagerSwipeItemFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PagerSwipeItemFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean canScrollHorizontally(int direction) {

        if (mCanSwipeLeft && direction > 0) {
            // return true to avoid view pager consume swipe left (= scroll right) touch events
            return true;
        }
        if (mCanSwipeRight && direction < 0) {
            // return true to avoid view pager consume swipe right (= scroll left) touch events
            return true;
        }

        return false;
    }

    public void setCanSwipeLeft(boolean canSwipeLeft) {
        mCanSwipeLeft = canSwipeLeft;
    }

    public void setCanSwipeRight(boolean canSwipeRight) {
        mCanSwipeRight = canSwipeRight;
    }
}
