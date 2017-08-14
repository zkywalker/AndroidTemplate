package me.arulnadhan.androidultimate.SweetSheet;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.sweetsheet.entity.MenuEntity;
import me.arulnadhan.sweetsheet.sweetpick.BlurEffect;
import me.arulnadhan.sweetsheet.sweetpick.CustomDelegate;
import me.arulnadhan.sweetsheet.sweetpick.DimEffect;
import me.arulnadhan.sweetsheet.sweetpick.RecyclerViewDelegate;
import me.arulnadhan.sweetsheet.sweetpick.SweetSheet;
import me.arulnadhan.sweetsheet.sweetpick.ViewPagerDelegate;

public class SweetSheetActivity extends ThemeBaseActivity {

    private SweetSheet mSweetSheet;
    private SweetSheet mSweetSheet2;
    private SweetSheet mSweetSheet3;
    private RelativeLayout rl;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sweetsheet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sweet Sheet");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rl = (RelativeLayout) findViewById(R.id.rl);
        setupViewpager();
        setupRecyclerView();
        setupCustomView();

    }

    private void setupCustomView() {

        mSweetSheet3 = new SweetSheet(rl);
        CustomDelegate customDelegate = new CustomDelegate(true,
                CustomDelegate.AnimationType.DuangLayoutAnimation);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_custom_view, null, false);
        customDelegate.setCustomView(view);
        mSweetSheet3.setDelegate(customDelegate);
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSweetSheet3.dismiss();
            }
        });
    }

    private void setupRecyclerView() {

        ArrayList<MenuEntity> list = new ArrayList<>();
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.iconId = R.drawable.ic_account_child;
        menuEntity.title = "Hello World";
        MenuEntity menuEntity1 = new MenuEntity();
        menuEntity1.iconId = R.drawable.ic_account_child;
        menuEntity1.title = "Hello Android";
        MenuEntity menuEntity2 = new MenuEntity();
        menuEntity2.iconId = R.drawable.ic_account_child;
        menuEntity2.title = "Hello Android Ultimate";
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity);
        list.add(menuEntity1);
        list.add(menuEntity2);
        mSweetSheet = new SweetSheet(rl);

        mSweetSheet.setMenuList(list);
        mSweetSheet.setDelegate(new RecyclerViewDelegate(true));
        mSweetSheet.setBackgroundEffect(new BlurEffect(2));
        mSweetSheet.setOnMenuItemClickListener(new SweetSheet.OnMenuItemClickListener() {
            @Override
            public boolean onItemClick(int position, MenuEntity menuEntity1) {

                Toast.makeText(SweetSheetActivity.this, menuEntity1.title + "  " + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    private void setupViewpager() {


        mSweetSheet2 = new SweetSheet(rl);
        mSweetSheet2.setMenuList(R.menu.menu_sweet);
        mSweetSheet2.setDelegate(new ViewPagerDelegate());
        mSweetSheet2.setBackgroundEffect(new DimEffect(3.5f));
        mSweetSheet2.setOnMenuItemClickListener(new SweetSheet.OnMenuItemClickListener() {
            @Override
            public boolean onItemClick(int position, MenuEntity menuEntity1) {

                Toast.makeText(SweetSheetActivity.this, menuEntity1.title + "  " + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    public void action_recyclerView(View v) {
        if (mSweetSheet2.isShow()) {
            mSweetSheet2.dismiss();
        }
        if (mSweetSheet3.isShow()) {
            mSweetSheet3.dismiss();
        }
        mSweetSheet.toggle();

    }

    public void action_viewpager(View v) {
        if (mSweetSheet.isShow()) {
            mSweetSheet.dismiss();
        }
        if (mSweetSheet3.isShow()) {
            mSweetSheet3.dismiss();
        }
        mSweetSheet2.toggle();
    }

    public void action_custom(View v) {
        if (mSweetSheet.isShow()) {
            mSweetSheet.dismiss();
        }
        if (mSweetSheet2.isShow()) {
            mSweetSheet2.dismiss();
        }
        mSweetSheet3.toggle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sweetsheet, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (mSweetSheet.isShow() || mSweetSheet2.isShow()) {
            if (mSweetSheet.isShow()) {
                mSweetSheet.dismiss();
            }
            if (mSweetSheet2.isShow()) {
                mSweetSheet2.dismiss();
            }
        } else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        if (id == R.id.action_recyclerView) {
            if (mSweetSheet2.isShow()) {
                mSweetSheet2.dismiss();
            }
            if (mSweetSheet3.isShow()) {
                mSweetSheet3.dismiss();
            }
            mSweetSheet.toggle();

            return true;
        }
        if (id == R.id.action_viewpager) {
            if (mSweetSheet.isShow()) {
                mSweetSheet.dismiss();
            }
            if (mSweetSheet3.isShow()) {
                mSweetSheet3.dismiss();
            }
            mSweetSheet2.toggle();
            return true;
        }
        if (id == R.id.action_custom) {
            if (mSweetSheet.isShow()) {
                mSweetSheet.dismiss();
            }
            if (mSweetSheet2.isShow()) {
                mSweetSheet2.dismiss();
            }
            mSweetSheet3.toggle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
