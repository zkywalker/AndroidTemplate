package me.arulnadhan.resume;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;



public class SCViewAnimation {

    private View view;
    private HashMap<Integer, ArrayList<SCPageAnimation>> pageAnimationMap;

    public SCViewAnimation(View inView) {
        this.view = inView;
        this.pageAnimationMap = new HashMap<Integer, ArrayList<SCPageAnimation>>();
    }

    public void startToPosition(Integer xPosition, Integer yPosition) {
        if (xPosition != null) this.view.setX(xPosition);
        if (yPosition != null) this.view.setY(yPosition);
        this.view.requestLayout();
    }

    public void addPageAnimation(SCPageAnimation inPageAnimation) {
        ArrayList<SCPageAnimation> animationList = pageAnimationMap.get(inPageAnimation.page);
        if (animationList == null) animationList = new ArrayList<SCPageAnimation>();
        animationList.add(inPageAnimation);
        pageAnimationMap.put(inPageAnimation.page, animationList);
    }

    public void applyAnimation(int page, float positionOffset) {
        ArrayList<SCPageAnimation> animationList = pageAnimationMap.get(page);

        if (animationList == null) return;

        for(SCPageAnimation animation : animationList) {
            animation.applyTransformation(this.view, positionOffset);
        }
    }

}
