package me.arulnadhan.androidultimate.RecyclerView.demo_s_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RecyclerListViewPageFragment.newInstance(
                        ViewPagerSwipeableExampleActivity.FRAGMENT_TAG_DATA_PROVIDER_1, false);
            case 1:
                return RecyclerListViewPageFragment.newInstance(
                        ViewPagerSwipeableExampleActivity.FRAGMENT_TAG_DATA_PROVIDER_2, true);
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position + 1);
    }
}
