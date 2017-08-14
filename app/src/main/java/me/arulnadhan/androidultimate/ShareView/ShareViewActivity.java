package me.arulnadhan.androidultimate.ShareView;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;

public class ShareViewActivity extends ThemeBaseActivity {

    PinterestView pinterestView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shareview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Share View");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * PinterestView'layoutParams must match_parent or fill_parent,
         * just for cover the whole screen
         */
        pinterestView = (PinterestView) findViewById(R.id.item_layout);
        /**
         * add item view into pinterestView
         */
        pinterestView.addShowView(40, createChildView(R.drawable.googleplus, "Google +")
                , createChildView(R.drawable.linkedin, "LinkedIn"), createChildView(R.drawable.twitter, "Twitter")
                , createChildView(R.drawable.pinterest, "Pinterest"));
        /**
         * add pinterestview menu and Pre click view click
         */
        pinterestView.setPinClickListener(new PinterestView.PinMenuClickListener() {

            @Override
            public void onMenuItemClick(int childAt) {
                String tips = (String) pinterestView.getChildAt(childAt).getTag();
                Toast.makeText(ShareViewActivity.this, tips + " clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPreViewClick() {
                Toast.makeText(ShareViewActivity.this, "button clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * dispatch pre click view onTouchEvent to PinterestView
         */
        findViewById(R.id.text).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pinterestView.dispatchTouchEvent(event);
                return true;
            }
        });

        findViewById(R.id.left).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pinterestView.dispatchTouchEvent(event);
                return true;
            }
        });

        findViewById(R.id.right).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pinterestView.dispatchTouchEvent(event);
                return true;
            }
        });

        findViewById(R.id.left_bottom).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pinterestView.dispatchTouchEvent(event);
                return true;
            }
        });

        findViewById(R.id.bottom).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pinterestView.dispatchTouchEvent(event);
                return true;
            }
        });

        findViewById(R.id.right_bottom).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pinterestView.dispatchTouchEvent(event);
                return true;
            }
        });
        
        CircleImageView imageView = (CircleImageView) findViewById(R.id.image);
        imageView.setFillColor(getResources().getColor(R.color.pink));
    }

    public View createChildView(int imageId, String tip) {
        CircleImageView imageView = new CircleImageView(this);
        imageView.setBorderWidth(0);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setFillColor(getResources().getColor(R.color.pink));
        imageView.setImageResource(imageId);
        //just for save Menu item tips
        imageView.setTag(tip);
        return imageView;
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
