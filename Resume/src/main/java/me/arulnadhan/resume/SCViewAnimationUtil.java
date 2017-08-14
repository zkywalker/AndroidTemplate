package me.arulnadhan.resume;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.View;


public class SCViewAnimationUtil {

    public static void prepareViewToGetSize(View view) {
        view.measure( View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),  View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static Point getDisplaySize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        return size;
    }

}
