package me.arulnadhan.recyclerview.draggable;

import android.support.v7.widget.RecyclerView;

public interface DraggableItemAdapter<T extends RecyclerView.ViewHolder> {

    /**
     * Called when user is attempt to drag the item.
     *
     * @param holder The ViewHolder which is associated to item user is attempt to start dragging.
     * @param position The position of the item within the adapter's data set.
     * @param x Touched X position. Relative from the itemView's top-left.
     * @param y Touched Y position. Relative from the itemView's top-left.

     * @return Whether can start dragging.
     */
    boolean onCheckCanStartDrag(T holder, int position, int x, int y);

    /**
     * Called after the {@link #onCheckCanStartDrag(android.support.v7.widget.RecyclerView.ViewHolder, int, int, int)} method returned true.
     *
     * @param holder The ViewHolder which is associated to item user is attempt to start dragging.
     * @param position The position of the item within the adapter's data set.
     *
     * @return null: no constraints (= new ItemDraggableRange(0, getItemCount() - 1)),
     *         otherwise: the range specified item can be drag-sortable.
     */
    ItemDraggableRange onGetItemDraggableRange(T holder, int position);

    /**
     * Called when item is moved. Should apply the move operation result to data set.
     *
     * @param fromPosition Previous position of the item.
     * @param toPosition New position of the item.
     */
    void onMoveItem(int fromPosition, int toPosition);
}
