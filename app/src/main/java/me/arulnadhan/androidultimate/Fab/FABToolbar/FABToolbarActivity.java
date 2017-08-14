package me.arulnadhan.androidultimate.Fab.FABToolbar;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.fabtoolbar.widget.FABToolbarLayout;


public class FABToolbarActivity extends ThemeBaseActivity {
    private FABToolbarLayout layout;
    private View one, two, three, four;
    private ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabtoolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FAB Toolbar");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layout = (FABToolbarLayout) findViewById(R.id.fabtoolbar);
        list = (ListView) findViewById(R.id.list);

        String[] data = new String[10];
        for (int i = 0; i < 10; i++) {
            data[i] = "Thanks for Looking here :) ";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                layout.show();
            }
        });
    }

    public void Alert(View v) {
        Toast.makeText(this, "You have Pressed this Cute Little Icon :P", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            layout.hide();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}

