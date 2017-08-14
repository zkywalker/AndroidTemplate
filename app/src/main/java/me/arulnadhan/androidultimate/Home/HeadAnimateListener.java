package me.arulnadhan.androidultimate.Home;

import android.support.design.widget.AppBarLayout;
import android.widget.RelativeLayout;

public class HeadAnimateListener implements AppBarLayout.OnOffsetChangedListener {

    private static final int PERCENTAGE_TO_ANIMATE_LOGO = 20;
    private boolean mIsLogoShown = true;
    private RelativeLayout relLogo;
    private int mMaxScrollSize;
    private ResizeAnimationHeight resizeAnimationHeight;


    public HeadAnimateListener(AppBarLayout appbarLayout, RelativeLayout relLogo) {
        mMaxScrollSize = appbarLayout.getTotalScrollRange();
        this.relLogo = relLogo;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;

        if (percentage >= PERCENTAGE_TO_ANIMATE_LOGO && mIsLogoShown) {
            mIsLogoShown = false;
            logoAnimateOff();
        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_LOGO && !mIsLogoShown) {
            mIsLogoShown = true;
            logoAnimateOn();
        }
    }

    private void logoAnimateOff() {

        relLogo.animate()
                .scaleY((float) 0)
                .scaleX((float) 0)
                .setDuration(200)
                .start();

        //TODO debug this
        try {
            resizeAnimationHeight = new ResizeAnimationHeight();
            resizeAnimationHeight.setView(relLogo);
            resizeAnimationHeight.setDuration(300);
            resizeAnimationHeight.setParams(100, 0);

            RelativeLayout.LayoutParams relLogoParams = (RelativeLayout.LayoutParams) relLogo.getLayoutParams();
            relLogoParams.topMargin = 0;
            relLogo.setLayoutParams(relLogoParams);
            relLogo.startAnimation(resizeAnimationHeight);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    private void logoAnimateOn() {

        //TODO debug this
        try {
            resizeAnimationHeight = new ResizeAnimationHeight();
            resizeAnimationHeight.setView(relLogo);
            resizeAnimationHeight.setDuration(200);
            resizeAnimationHeight.setParams(0, 100);

            RelativeLayout.LayoutParams relLogoParams = (RelativeLayout.LayoutParams) relLogo.getLayoutParams();
            relLogoParams.topMargin = -50;
            relLogo.setLayoutParams(relLogoParams);
            relLogo.startAnimation(resizeAnimationHeight);

        } catch (Exception e) {
            //e.printStackTrace();
        }

        relLogo.animate()
                .scaleY(1)
                .scaleX(1)
                .setDuration(200)
                .start();
    }
}
