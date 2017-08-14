package me.arulnadhan.fabreveal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class CircularExpandingView extends View {

    protected static final int ANIMATION_DURATION = 300;

    protected final Interpolator INTERPOLATOR = new AccelerateDecelerateInterpolator();
    protected Paint paint = null;
    protected float expandFraction = 0;

    public CircularExpandingView(Context context) {
        super(context);
        initialize();
    }

    public CircularExpandingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public CircularExpandingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    protected void initialize(){
        paint = new Paint();
    }

    public void setColor(int color){
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int cx = canvas.getWidth()/2;
        int cy = canvas.getHeight()/2;
        float radius = (float) Math.sqrt(cx*cx + cy*cy) * expandFraction;

        canvas.drawCircle(cx, cy, radius, paint);
    }

    public Animator expand(){
        return animateExpandFraction(0.1f, 1);
    }

    public Animator contract(){
        return animateExpandFraction(1, 0.1f);
    }

    public Animator animateExpandFraction(float from, float to){
        ValueAnimator animator = ValueAnimator.ofFloat(from, to);
        animator.setDuration(ANIMATION_DURATION);
        animator.setInterpolator(INTERPOLATOR);

        animator.addUpdateListener(updateListener);
        return animator;
    }

    protected ValueAnimator.AnimatorUpdateListener updateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            setExpandFraction((float) animation.getAnimatedValue());
        }
    };

    public void setExpandFraction(float expandFraction) {
        this.expandFraction = expandFraction;
        invalidate();
    }

}
