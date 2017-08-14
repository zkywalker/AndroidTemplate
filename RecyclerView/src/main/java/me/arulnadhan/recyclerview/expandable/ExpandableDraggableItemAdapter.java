package me.arulnadhan.recyclerview.expandable;

import android.support.v7.widget.RecyclerView;

import me.arulnadhan.recyclerview.draggable.ItemDraggableRange;

public interface ExpandableDraggableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    /**
     * Called when user is attempt to drag the group item.
     *
     * @param holder The group ViewHolder which is associated to item user is attempt to start dragging.
     * @param groupPosition Group position.
     * @param x Touched X position. Relative from the itemView's top-left.
     * @param y Touched Y position. Relative from the itemView's top-left.
     *
     * @return Whether can start dragging.
     */
    boolean onCheckGroupCanStartDrag(GVH holder, int groupPosition, int x, int y);

    /**
     * Called when user is attempt to drag the child item.
     *
     * @param holder The child ViewHolder which is associated to item user is attempt to start dragging.
     * @param groupPosition Group position.
     * @param childPosition Child position.
     * @param x Touched X position. Relative from the itemView's top-left.
     * @param y Touched Y position. Relative from the itemView's top-left.
     *
     * @return Whether can start dragging.
     */
    boolean onCheckChildCanStartDrag(CVH holder, int groupPosition, int childPosition, int x, int y);

    /**
     * Called after the {@link #onCheckGroupCanStartDrag(android.support.v7.widget.RecyclerView.ViewHolder, int, int, int)} method returned true.
     *
     * @param holder The ViewHolder which is associated to item user is attempt to start dragging.
     * @param groupPosition Group position.
     *
     * @return null: no constraints (= new ItemDraggableRange(0, getGroupCount() - 1)),
     *         otherwise: the range specified item can be drag-sortable.
     */
    ItemDraggableRange onGetGroupItemDraggableRange(GVH holder, int groupPosition);

    /**
     * Called after the {@link #onCheckChildCanStartDrag(android.support.v7.widget.RecyclerView.ViewHolder, int, int, int, int)} method returned true.
     *
     * @param holder The ViewHolder which is associated to item user is attempt to start dragging.
     * @param groupPosition Group position.
     * @param childPosition Child position.
     *
     * @return null: no constraints (= new ItemDraggableRange(0, getGroupCount() - 1)),
     *         otherwise: the range specified item can be drag-sortable.
     */
    ItemDraggableRange onGetChildItemDraggableRange(CVH holder, int groupPosition, int childPosition);

    /**
     * Called when group item is moved. Should apply the move operation result to data set.
     *
     * @param fromGroupPosition Previous group position of the item.
     * @param toGroupPosition New group position of the item.
     */
    void onMoveGroupItem(int fromGroupPosition, int toGroupPosition);

    /**
     * Called when child item is moved. Should apply the move operation result to data set.
     *
     * @param fromGroupPosition Previous group position of the item.
     * @param fromChildPosition Previous child position of the item.
     * @param toGroupPosition New group position of the item.
     * @param toChildPosition New child position of the item.
     */
    void onMoveChildItem(int fromGroupPosition, int fromChildPosition, int toGroupPosition, int toChildPosition);
}
