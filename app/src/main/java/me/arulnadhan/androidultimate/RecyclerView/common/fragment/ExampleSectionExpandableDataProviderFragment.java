package me.arulnadhan.androidultimate.RecyclerView.common.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import me.arulnadhan.androidultimate.RecyclerView.common.data.AbstractExpandableDataProvider;
import me.arulnadhan.androidultimate.RecyclerView.common.data.ExampleSectionExpandableDataProvider;


public class ExampleSectionExpandableDataProviderFragment extends Fragment {
    private ExampleSectionExpandableDataProvider mDataProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);  // keep the mDataProvider instance
        mDataProvider = new ExampleSectionExpandableDataProvider();
    }

    public AbstractExpandableDataProvider getDataProvider() {
        return mDataProvider;
    }
}
