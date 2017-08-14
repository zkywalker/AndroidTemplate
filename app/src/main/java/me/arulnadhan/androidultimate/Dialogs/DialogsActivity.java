package me.arulnadhan.androidultimate.Dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;

public class DialogsActivity extends ThemeBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Material Dialogs");
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void shwmsg(final View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage("Hello, Android Ultimate!");
        builder.setPositiveButton("Nice Job", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Snackbar.make(v, "Nice Job", Snackbar.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Dismiss", null);
        builder.show();
    }

    public void shwlmsg(View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage("Hello, Android Ultimate!\nThis message is a bit longer than you would expect, so you can see how nicely this dialog behaves on tablets and landscape orientations. The Dialog does not stretch to fill the width but maintains a nice aspect ratio, yeah!");
        builder.setPositiveButton("Nice Job", null);
        builder.setNegativeButton("Dismiss", null);
        builder.show();
    }

    public void shwlist(final View v) {
        final String[] list = new String[]{"Argentina", "Canada", "China (中国)", "Japan (日本)",
                "United States", "India (தமிழ்)"};
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Select Country");
        builder.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Snackbar.make(v, list[which], Snackbar.LENGTH_LONG).show();
            }
        }).show();
    }

    private List<String> mCheckedItems = new ArrayList<String>();

    public void shwcb(final View v) {
        final String[] list = new String[]{"Material theme", "Holo theme", "Custom theme"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Choose a Theme");
        builder.setMultiChoiceItems(list,
                new boolean[]{false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            mCheckedItems.add(list[which]);
                        } else {
                            mCheckedItems.remove(list[which]);
                        }
                        Snackbar.make(v, list[which] + " is "
                                + (isChecked ? "checked" : "unchecked" + "."), Snackbar.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("More info", null)
                .setNegativeButton("Cancel", null)
                .setPositiveButton(
                        "Choose", null)
                .show();
    }

    private String mCheckedItem;

    public void shwrb(final View v) {

        final String[] list = new String[]{"Female", "Male"};
        int checkedItemIndex = 0;
        mCheckedItem = list[checkedItemIndex];

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setSingleChoiceItems(list, checkedItemIndex,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mCheckedItem = list[which];
                        Snackbar.make(v, mCheckedItem, Snackbar.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Save", null)
                .show();
    }

    public void shwet(View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Edit your Cool Name :)");
        builder.setView(getLayoutInflater().inflate(R.layout.dialog_et, null));
        builder.setPositiveButton("Done", null);
        builder.setNegativeButton("Dismiss", null);
        builder.show();
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
