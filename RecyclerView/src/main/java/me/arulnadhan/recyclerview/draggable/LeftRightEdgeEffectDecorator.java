package me.arulnadhan.recyclerview.draggable;

import android.support.v7.widget.RecyclerView;

class LeftRightEdgeEffectDecorator extends BaseEdgeEffectDecorator {
    public LeftRightEdgeEffectDecorator(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    protected int getEdgeDirection(int no) {
        switch (no) {
            case 0:
                return EDGE_LEFT;
            case 1:
                return EDGE_RIGHT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
