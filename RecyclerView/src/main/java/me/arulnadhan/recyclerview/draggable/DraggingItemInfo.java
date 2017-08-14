package me.arulnadhan.recyclerview.draggable;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.utils.CustomRecyclerViewUtils;

public class DraggingItemInfo {
    public final int width;
    public final int height;
    public final long id;
    public final int grabbedPositionX;
    public final int grabbedPositionY;
    public final Rect margins;

    public DraggingItemInfo(RecyclerView.ViewHolder vh, int touchX, int touchY) {
        width = vh.itemView.getWidth();
        height = vh.itemView.getHeight();
        id = vh.getItemId();
        grabbedPositionX = touchX - vh.itemView.getLeft();
        grabbedPositionY = touchY - vh.itemView.getTop();
        margins = new Rect();
        CustomRecyclerViewUtils.getLayoutMargins(vh.itemView, margins);
    }
}
