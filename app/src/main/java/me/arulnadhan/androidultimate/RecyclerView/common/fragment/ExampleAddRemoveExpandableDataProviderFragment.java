package me.arulnadhan.androidultimate.RecyclerView.common.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import me.arulnadhan.androidultimate.RecyclerView.common.data.AbstractAddRemoveExpandableDataProvider;
import me.arulnadhan.androidultimate.RecyclerView.common.data.ExampleAddRemoveExpandableDataProvider;


public class ExampleAddRemoveExpandableDataProviderFragment extends Fragment {
    private ExampleAddRemoveExpandableDataProvider mDataProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);  // keep the mDataProvider instance
        mDataProvider = new ExampleAddRemoveExpandableDataProvider();
    }

    public AbstractAddRemoveExpandableDataProvider getDataProvider() {
        return mDataProvider;
    }
}
