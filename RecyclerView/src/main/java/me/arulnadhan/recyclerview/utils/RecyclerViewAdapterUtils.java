package me.arulnadhan.recyclerview.utils;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;

public class RecyclerViewAdapterUtils {
    private RecyclerViewAdapterUtils() {
    }

    /**
     * Gets parent RecyclerView instance.
     * @param view Child view of the RecyclerView's item
     * @return Parent RecyclerView instance
     */
    public static RecyclerView getParentRecyclerView(@Nullable View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return (RecyclerView) parent;
        } else if (parent instanceof View) {
            return getParentRecyclerView((View) parent);
        } else {
            return null;
        }
    }

    /**
     * Gets directly child of RecyclerView (== {@link android.support.v7.widget.RecyclerView.ViewHolder#itemView}})
     * @param view Child view of the RecyclerView's item
     * @return Item view
     */
    public static View getParentViewHolderItemView(@Nullable View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return view;
        } else if (parent instanceof View) {
            return getParentViewHolderItemView((View) parent);
        } else {
            return null;
        }
    }

    /**
     * Gets {@link android.support.v7.widget.RecyclerView.ViewHolder}.
     * @param view Child view of the RecyclerView's item
     * @return ViewHolder
     */
    public static RecyclerView.ViewHolder getViewHolder(@Nullable View view) {
        RecyclerView rv = getParentRecyclerView(view);
        View rvChild = getParentViewHolderItemView(view);

        if (rv != null && rvChild != null) {
            return rv.getChildViewHolder(rvChild);
        } else {
            return null;
        }
    }
}
