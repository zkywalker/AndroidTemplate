package me.arulnadhan.androidultimate.RecyclerView.launcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class OptionsMenuFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

}
