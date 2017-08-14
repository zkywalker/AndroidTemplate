package me.arulnadhan.recyclerview.draggable;

public class ItemDraggableRange {
    private final int mStart;
    private final int mEnd;

    public ItemDraggableRange(int start, int end) {
        if (!(start <= end)) {
            throw new IllegalArgumentException("end position (= " + end + ") is smaller than start position (=" + start + ")");
        }

        mStart = start;
        mEnd = end;
    }

    public int getStart() {
        return mStart;
    }

    public int getEnd() {
        return mEnd;
    }

    public boolean checkInRange(int position) {
        return ((position >= mStart) && (position <= mEnd));
    }

    protected String getClassName() {
        return "ItemDraggableRange";
    }

    @Override
    public String toString() {
        return getClassName() + "{" +
                "mStart=" + mStart +
                ", mEnd=" + mEnd +
                '}';
    }
}

