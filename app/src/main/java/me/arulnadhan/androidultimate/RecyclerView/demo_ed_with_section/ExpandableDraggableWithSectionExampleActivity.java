package me.arulnadhan.androidultimate.RecyclerView.demo_ed_with_section;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.RecyclerView.common.data.AbstractExpandableDataProvider;
import me.arulnadhan.androidultimate.RecyclerView.common.fragment.ExampleSectionExpandableDataProviderFragment;


public class ExpandableDraggableWithSectionExampleActivity extends AppCompatActivity {
    private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
    private static final String FRAGMENT_LIST_VIEW = "list view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_activity_demo);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(new ExampleSectionExpandableDataProviderFragment(), FRAGMENT_TAG_DATA_PROVIDER)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new RecyclerListViewFragment(), FRAGMENT_LIST_VIEW)
                    .commit();
        }
    }

    public AbstractExpandableDataProvider getDataProvider() {
        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
        return ((ExampleSectionExpandableDataProviderFragment) fragment).getDataProvider();
    }
}
