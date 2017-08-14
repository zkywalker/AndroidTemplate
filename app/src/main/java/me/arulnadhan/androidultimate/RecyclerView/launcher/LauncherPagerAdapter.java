package me.arulnadhan.androidultimate.RecyclerView.launcher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class LauncherPagerAdapter extends FragmentPagerAdapter {
    public LauncherPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        return LauncherPageFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Drag";
            case 1:
                return "Swipe";
            case 2:
                return "Expand";
            case 3:
                return "Advanced";
            default:
                throw new IllegalArgumentException();
        }
    }
}
