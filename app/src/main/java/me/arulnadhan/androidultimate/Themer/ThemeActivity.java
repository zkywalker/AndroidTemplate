package me.arulnadhan.androidultimate.Themer;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import me.arulnadhan.androidultimate.R;

public class ThemeActivity extends ThemeBaseActivity {
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;
    private StaggeredGridLayoutManager Manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Theme");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        Manager = new StaggeredGridLayoutManager(2, 1);
        mRecyclerView.setLayoutManager(Manager);

        List<Theme> data = getListItemData();

        adapter = new ThemeAdapter(getApplicationContext(), this, data);
        mRecyclerView.setAdapter(adapter);
    }


    private List<Theme> getListItemData() {
        List<Theme> Items = new ArrayList<Theme>();
        Items.add(new Theme("Blue", "#2196F3"));
        Items.add(new Theme("Red", "#F44336"));

        Items.add(new Theme("Green", "#4CAF50"));
        Items.add(new Theme("Cyan", "#00BCD4"));
        Items.add(new Theme("Purple", "#512DA8"));

        Items.add(new Theme("Orange", "#FF9800"));
        Items.add(new Theme("Pink", "#E91E63"));
        Items.add(new Theme("Teal", "#00796B"));
        return Items;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
