package me.arulnadhan.recyclerview.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.arulnadhan.recyclerview.draggable.DraggableItemViewHolder;
import me.arulnadhan.recyclerview.draggable.annotation.DraggableItemStateFlags;

public abstract class AbstractDraggableItemViewHolder extends RecyclerView.ViewHolder implements DraggableItemViewHolder {
    @DraggableItemStateFlags
    private int mDragStateFlags;

    public AbstractDraggableItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setDragStateFlags(@DraggableItemStateFlags int flags) {
        mDragStateFlags = flags;
    }

    @Override
    @DraggableItemStateFlags
    public int getDragStateFlags() {
        return mDragStateFlags;
    }
}
