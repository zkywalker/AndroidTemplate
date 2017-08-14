package me.arulnadhan.recyclerview.expandable;

public interface ExpandableItemConstants {
    /**
     * State flag for the {@link ExpandableItemViewHolder#setExpandStateFlags(int)} and {@link ExpandableItemViewHolder#getExpandStateFlags()} methods.
     * Indicates that this ViewHolder is associated to group item.
     */
    @SuppressWarnings("PointlessBitwiseExpression")
    int STATE_FLAG_IS_GROUP = (1 << 0);

    /**
     * State flag for the {@link ExpandableItemViewHolder#setExpandStateFlags(int)} and {@link ExpandableItemViewHolder#getExpandStateFlags()} methods.
     * Indicates that this ViewHolder is associated to child item.
     */
    int STATE_FLAG_IS_CHILD = (1 << 1);

    /**
     * State flag for the {@link ExpandableItemViewHolder#setExpandStateFlags(int)} and {@link ExpandableItemViewHolder#getExpandStateFlags()} methods.
     * Indicates that this is an expanded group item.
     */
    int STATE_FLAG_IS_EXPANDED = (1 << 2);

    /**
     * State flag for the {@link ExpandableItemViewHolder#setExpandStateFlags(int)} and {@link ExpandableItemViewHolder#getExpandStateFlags()} methods.
     * If this flag is set, the {@link #STATE_FLAG_IS_EXPANDED} flag has changed.
     */
    int STATE_FLAG_HAS_EXPANDED_STATE_CHANGED = (1 << 3);

    /**
     * State flag for the {@link ExpandableItemViewHolder#setExpandStateFlags(int)} and {@link ExpandableItemViewHolder#getExpandStateFlags()} methods.
     * If this flag is set, some other flags are changed and require to apply.
     */
    int STATE_FLAG_IS_UPDATED = (1 << 31);
    // ---
}
