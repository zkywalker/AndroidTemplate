package me.arulnadhan.androidultimate.RecyclerView.common.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import me.arulnadhan.androidultimate.RecyclerView.common.data.AbstractDataProvider;
import me.arulnadhan.androidultimate.RecyclerView.common.data.ExampleSectionDataProvider;


public class ExampleSectionDataProviderFragment extends Fragment {
    private ExampleSectionDataProvider mDataProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);  // keep the mDataProvider instance
        mDataProvider = new ExampleSectionDataProvider();
    }

    public AbstractDataProvider getDataProvider() {
        return mDataProvider;
    }
}
