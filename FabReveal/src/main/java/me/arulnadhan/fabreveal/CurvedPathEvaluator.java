package me.arulnadhan.fabreveal;

import android.animation.TypeEvaluator;

/**
 * Created by tomas on 11/08/15.
 */
public class CurvedPathEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float t, Point startValue, Point endValue) {
        float x, y;

        float oneMinusT = 1 - t;
        x = oneMinusT * oneMinusT * oneMinusT * startValue.x +
                3 * oneMinusT * oneMinusT * t * endValue.control0X +
                3 * oneMinusT * t * t * endValue.control1X +
                t * t * t * endValue.x;
        y = oneMinusT * oneMinusT * oneMinusT * startValue.y +
                3 * oneMinusT * oneMinusT * t * endValue.y +
                3 * oneMinusT * t * t * endValue.y +
                t * t * t * endValue.y;

        return new Point(x,y);
    }
}
