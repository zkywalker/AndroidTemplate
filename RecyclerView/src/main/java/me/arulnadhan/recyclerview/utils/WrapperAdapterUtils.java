package me.arulnadhan.recyclerview.utils;

import android.support.v7.widget.RecyclerView;

public class WrapperAdapterUtils {

    private WrapperAdapterUtils() {
    }

    public static <T> T findWrappedAdapter(RecyclerView.Adapter adapter, Class<T> clazz) {
        if (clazz.isInstance(adapter)) {
            return clazz.cast(adapter);
        } else if (adapter instanceof BaseWrapperAdapter) {
            final RecyclerView.Adapter wrappedAdapter = ((BaseWrapperAdapter) adapter).getWrappedAdapter();
            return findWrappedAdapter(wrappedAdapter, clazz);
        } else {
            return null;
        }
    }

    public static RecyclerView.Adapter releaseAll(RecyclerView.Adapter adapter) {
        return releaseCyclically(adapter);
    }

    private static RecyclerView.Adapter releaseCyclically(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof BaseWrapperAdapter)) {
            return adapter;
        }

        final BaseWrapperAdapter wrapperAdapter = (BaseWrapperAdapter) adapter;
        final RecyclerView.Adapter wrappedAdapter = wrapperAdapter.getWrappedAdapter();

        wrapperAdapter.release();

        return releaseCyclically(wrappedAdapter);
    }
}
