
package me.arulnadhan.recyclerview.animator.impl;

import android.support.v7.widget.RecyclerView;

public class AddAnimationInfo extends ItemAnimationInfo {
    public RecyclerView.ViewHolder holder;

    public AddAnimationInfo(RecyclerView.ViewHolder holder) {
        this.holder = holder;
    }

    @Override
    public RecyclerView.ViewHolder getAvailableViewHolder() {
        return holder;
    }

    @Override
    public void clear(RecyclerView.ViewHolder item) {
        if (holder == null) {
            holder = null;
        }
    }

    @Override
    public String toString() {
        return "AddAnimationInfo{" +
                "holder=" + holder +
                '}';
    }
}
