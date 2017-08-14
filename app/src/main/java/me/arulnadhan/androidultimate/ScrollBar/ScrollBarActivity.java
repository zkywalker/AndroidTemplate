package me.arulnadhan.androidultimate.ScrollBar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.List;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.scrollbar.AlphabetIndicator;
import me.arulnadhan.scrollbar.MaterialScrollBar;

public class ScrollBarActivity extends ThemeBaseActivity {

    static String[] dataArray = new String[]{"AruLNadhaN", "AruLNadhaN", "AruLNadhaN", "Brian", "Brian", "Brian", "Christopher", "Donald", "Donald", "Donald", "Donald", "Edward", "Ford", "Ford", "Ford", "Ford", "George", "Harry", "Harry", "Harry", "Harry", "Irvin", "James", "James", "James", "James", "Kenneth", "Lucas", "Mark", "Mark", "Mark", "Mark", "Nick", "Orlando", "Paul", "Paul", "Paul", "Paul", "Queen", "Robert", "Steven", "Steven", "Steven", "Steven", "Thomas", "Usher", "Vanessa", "Vanessa", "Vanessa", "Vanessa", "William", "Xman", "Yang", "Yang", "Yang", "Yang", "Zoe", "Zoe", "Zoe", "Zoe", "Edward", "Ford", "George", "Harry", "Irvin", "James"};
    static List<String> list = Arrays.asList(dataArray);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Material Scroll Bar");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        recyclerView.setAdapter(new RecyclerAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new MaterialScrollBar(this, recyclerView, true).addIndicator(new AlphabetIndicator(this));

        Snackbar.make(recyclerView, "Scroll iT :)", Snackbar.LENGTH_LONG).show();

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