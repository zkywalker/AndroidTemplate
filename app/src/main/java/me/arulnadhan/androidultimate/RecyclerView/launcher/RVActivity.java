package me.arulnadhan.androidultimate.RecyclerView.launcher;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;

public class RVActivity extends ThemeBaseActivity {
    private static final String FRAGMENT_TAG_OPTIONS_MENU = "options menu";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rv_activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);

        pager.setAdapter(new LauncherPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(new OptionsMenuFragment(), FRAGMENT_TAG_OPTIONS_MENU)
                    .commit();
        }
    }
}
