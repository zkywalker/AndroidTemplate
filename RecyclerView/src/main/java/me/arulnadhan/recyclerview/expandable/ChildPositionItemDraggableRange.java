package me.arulnadhan.recyclerview.expandable;

import me.arulnadhan.recyclerview.draggable.ItemDraggableRange;

public class ChildPositionItemDraggableRange extends ItemDraggableRange {
    public ChildPositionItemDraggableRange(int start, int end) {
        super(start, end);
    }

    protected String getClassName() {
        return "ChildPositionItemDraggableRange";
    }
}
