package me.arulnadhan.androidultimate.Listview.itemmanipulation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import me.arulnadhan.androidultimate.Listview.BaseActivity;
import me.arulnadhan.androidultimate.Listview.itemmanipulation.expandablelistitems.ExpandableListItemActivity;
import me.arulnadhan.androidultimate.R;

public class ItemManipulationsExamplesActivity extends BaseActivity {

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_itemmanipulations);
    }

    public void onDynamicListViewClicked(final View view) {
        Intent intent = new Intent(this, DynamicListViewActivity.class);
        startActivity(intent);
    }

    public void onExpandListItemAdapterClicked(final View view) {
        Intent intent = new Intent(this, ExpandableListItemActivity.class);
        startActivity(intent);
    }
}
