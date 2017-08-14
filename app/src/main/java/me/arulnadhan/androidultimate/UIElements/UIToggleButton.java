package me.arulnadhan.androidultimate.UIElements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.arulnadhan.androidultimate.R;

public class UIToggleButton extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ui_togglebutton, container, false);
        return v;
    }

}
