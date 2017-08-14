package me.arulnadhan.androidultimate.PullToRefresh;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.ScrollBar.RecyclerAdapter;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.scrollbar.AlphabetIndicator;
import me.arulnadhan.scrollbar.MaterialScrollBar;

public class SwipeRefreshActivity extends ThemeBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefresh);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Swipe Refresh");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        recyclerView.setAdapter(new RecyclerAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new MaterialScrollBar(this, recyclerView, true).addIndicator(new AlphabetIndicator(this));

        Snackbar.make(recyclerView, "Pull To Refresh :)", Snackbar.LENGTH_LONG).show();

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.one, R.color.two, R.color.three, R.color.four, R.color.five, R.color.six);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Snackbar mSnack = Snackbar.make(mSwipeRefreshLayout, "Loading data from server... It will not end :P", Snackbar.LENGTH_INDEFINITE);
                View view = mSnack.getView();
                view.setBackgroundColor(getAccentColor(SwipeRefreshActivity.this));
                mSnack.show();
            }
        });
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