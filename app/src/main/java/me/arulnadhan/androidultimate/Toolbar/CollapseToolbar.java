package me.arulnadhan.androidultimate.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;


public class CollapseToolbar extends ThemeBaseActivity {

    private final static String COLLAPSING_TOOLBAR_FRAGMENT_TAG = "collapsing_toolbar";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                new CollapsingToolbarFragment(), COLLAPSING_TOOLBAR_FRAGMENT_TAG).addToBackStack(null).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}