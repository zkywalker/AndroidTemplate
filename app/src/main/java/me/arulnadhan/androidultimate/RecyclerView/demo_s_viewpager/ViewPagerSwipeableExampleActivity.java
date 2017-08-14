package me.arulnadhan.androidultimate.RecyclerView.demo_s_viewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.RecyclerView.common.data.AbstractDataProvider;
import me.arulnadhan.androidultimate.RecyclerView.common.fragment.ExampleDataProviderFragment;

public class ViewPagerSwipeableExampleActivity extends AppCompatActivity {
    public static final String FRAGMENT_TAG_DATA_PROVIDER_1 = "data provider 1";
    public static final String FRAGMENT_TAG_DATA_PROVIDER_2 = "data provider 2";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_activity_demo_viewpager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        mTabLayout.setupWithViewPager(mViewPager);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(new ExampleDataProviderFragment(), FRAGMENT_TAG_DATA_PROVIDER_1)
                    .add(new ExampleDataProviderFragment(), FRAGMENT_TAG_DATA_PROVIDER_2)
                    .commit();
        }
    }

    public AbstractDataProvider getDataProvider(String dataProviderName) {
        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(dataProviderName);
        return ((ExampleDataProviderFragment) fragment).getDataProvider();
    }
}
