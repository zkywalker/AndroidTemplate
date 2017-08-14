package me.arulnadhan.androidultimate.Listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import me.arulnadhan.androidultimate.Listview.appearance.AppearanceExamplesActivity;
import me.arulnadhan.androidultimate.Listview.googlecards.GoogleCardsActivity;
import me.arulnadhan.androidultimate.Listview.gridview.GridViewActivity;
import me.arulnadhan.androidultimate.Listview.itemmanipulation.ItemManipulationsExamplesActivity;
import me.arulnadhan.androidultimate.R;

public class MainListActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lv);
    }


    public void onGoogleCardsExampleClicked(final View view) {
        Intent intent = new Intent(this, GoogleCardsActivity.class);
        startActivity(intent);
    }

    public void onGridViewExampleClicked(final View view) {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }

    public void onAppearanceClicked(final View view) {
        Intent intent = new Intent(this, AppearanceExamplesActivity.class);
        startActivity(intent);
    }

    public void onItemManipulationClicked(final View view) {
        Intent intent = new Intent(this, ItemManipulationsExamplesActivity.class);
        startActivity(intent);
    }

    public void onSLHClicked(final View view) {
        Intent intent = new Intent(this, StickyListHeadersActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
