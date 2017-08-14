package me.arulnadhan.recyclerview.swipeable;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

class InternalHelperKK {
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void clearViewPropertyAnimatorUpdateListener(View view) {
        view.animate().setUpdateListener(null);
    }
}
