package me.arulnadhan.androidultimate.Toolbar;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.androidultimate.Toolbar.adapters.RecyclerAdapter;
import me.arulnadhan.androidultimate.Toolbar.models.CardItemModel;


public class QuickReturnToolbar extends ThemeBaseActivity {

    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private List<CardItemModel> cardItems = new ArrayList<>(20);

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quickreturn);
        mToolbar = (Toolbar) findViewById(R.id.tb);
        mToolbar.setTitle("Quick Return Toolbar");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        initializeCardItemList();
        recyclerView.setAdapter(new RecyclerAdapter(cardItems));
    }

    private void initializeCardItemList() {
        CardItemModel cardItemModel;
        String[] cardTitles = getResources().getStringArray(R.array.card_titles);
        String[] cardContents = getResources().getStringArray(R.array.card_contents);
        final int length = cardTitles.length;
        for (int i = 0; i < length; i++) {
            cardItemModel = new CardItemModel(cardTitles[i], cardContents[i]);
            cardItems.add(cardItemModel);
        }
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
