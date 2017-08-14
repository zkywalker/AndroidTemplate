
package me.arulnadhan.fabreveal;

public class Point {

    protected float x, y;
    protected float control0X, control0Y;
    protected float control1X, control1Y;

    public Point(float control0X, float control0Y, float control1X, float control1Y, float x, float y) {
        this.control0X = control0X;
        this.control0Y = control0Y;
        this.control1X = control1X;
        this.control1Y = control1Y;
        this.x = x;
        this.y = y;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
