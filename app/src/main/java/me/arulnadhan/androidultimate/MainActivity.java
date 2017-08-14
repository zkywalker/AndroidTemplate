package me.arulnadhan.androidultimate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import java.util.ArrayList;
import java.util.List;

import me.arulnadhan.androidultimate.Achievement.AchievementActivity;
import me.arulnadhan.androidultimate.AppIntro.AppIntroMainActivity;
import me.arulnadhan.androidultimate.Bottomsheet.BottomsheetActivity;
import me.arulnadhan.androidultimate.Bubbles.BubblesActivity;
import me.arulnadhan.androidultimate.Dialogs.DialogsActivity;
import me.arulnadhan.androidultimate.ElasticDownload.ElasticDownloadActivity;
import me.arulnadhan.androidultimate.Fab.FabMainActivity;
import me.arulnadhan.androidultimate.Home.AndroidP;
import me.arulnadhan.androidultimate.Home.Bonus;
import me.arulnadhan.androidultimate.Home.HeadAnimateListener;
import me.arulnadhan.androidultimate.Home.MaterialH;
import me.arulnadhan.androidultimate.Listview.MainListActivity;
import me.arulnadhan.androidultimate.Login.LoginActivity;
import me.arulnadhan.androidultimate.MaterialPicker.MaterialPickerActivity;
import me.arulnadhan.androidultimate.MaterialTabs.TabActivity;
import me.arulnadhan.androidultimate.PullToRefresh.PullToRefresh;
import me.arulnadhan.androidultimate.RecyclerView.launcher.RVActivity;
import me.arulnadhan.androidultimate.Resume.ResumeActivity;
import me.arulnadhan.androidultimate.ScrollBar.ScrollBarActivity;
import me.arulnadhan.androidultimate.SearchView.SearchViewActivity;
import me.arulnadhan.androidultimate.ShareView.ShareViewActivity;
import me.arulnadhan.androidultimate.SweetSheet.SweetSheetActivity;
import me.arulnadhan.androidultimate.SwipeableLayout.SwipeableLayoutActivity;
import me.arulnadhan.androidultimate.TextSurface.TextSurfaceMainActivity;
import me.arulnadhan.androidultimate.TextView.TextViewActivity;
import me.arulnadhan.androidultimate.Themer.ThemeActivity;
import me.arulnadhan.androidultimate.Themer.ThemeBaseActivity;
import me.arulnadhan.androidultimate.Toolbar.ToolBarActivity;
import me.arulnadhan.androidultimate.UIElements.UIActivity;


public class MainActivity extends ThemeBaseActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
    }

    private void setupUI() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        AppBarLayout appbarLayout = (AppBarLayout) findViewById(R.id.appbar);

        RelativeLayout relLogo = (RelativeLayout) findViewById(R.id.logo);
        appbarLayout.addOnOffsetChangedListener(new HeadAnimateListener(appbarLayout, relLogo));


    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.nav_home:
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.tool_bar:
                                startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_tabs:
                                startActivity(new Intent(MainActivity.this, TabActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_fab:
                                startActivity(new Intent(MainActivity.this, FabMainActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.dialogs:
                                startActivity(new Intent(MainActivity.this, DialogsActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_rv:
                                startActivity(new Intent(MainActivity.this, RVActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_bottomsheet:
                                startActivity(new Intent(MainActivity.this, BottomsheetActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_scrollbar:
                                startActivity(new Intent(MainActivity.this, ScrollBarActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_searchview:
                                startActivity(new Intent(MainActivity.this, SearchViewActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_mpicker:
                                startActivity(new Intent(MainActivity.this, MaterialPickerActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;

//                            AP

                            case R.id.nav_intro:
                                startActivity(new Intent(MainActivity.this, AppIntroMainActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_login:
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_swipeablelayout:
                                startActivity(new Intent(MainActivity.this, SwipeableLayoutActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_bubbles:
                                startActivity(new Intent(MainActivity.this, BubblesActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_achievement:
                                startActivity(new Intent(MainActivity.this, AchievementActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_refresh:
                                startActivity(new Intent(MainActivity.this, PullToRefresh.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_lv:
                                startActivity(new Intent(MainActivity.this, MainListActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_tv:
                                startActivity(new Intent(MainActivity.this, TextViewActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_elasticdownload:
                                startActivity(new Intent(MainActivity.this, ElasticDownloadActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;

//                          Bonus

                            case R.id.nav_ui:
                                startActivity(new Intent(MainActivity.this, UIActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;

                            case R.id.nav_sweetsheet:
                                startActivity(new Intent(MainActivity.this, SweetSheetActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_shareview:
                                startActivity(new Intent(MainActivity.this, ShareViewActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
                            case R.id.nav_textsurface:
                                startActivity(new Intent(MainActivity.this, TextSurfaceMainActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;
//                      About

                            case R.id.nav_resume:
                                startActivity(new Intent(MainActivity.this, ResumeActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;

                            case R.id.nav_theme:
                                startActivity(new Intent(MainActivity.this, ThemeActivity.class));
                                mDrawerLayout.closeDrawers();
                                return true;


                            default:
                                return true;
                        }
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new MaterialH(), "Material Highlights");
        adapter.addFragment(new AndroidP(), "Android Patterns");
        adapter.addFragment(new Bonus(), "Bonus");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }

//    Onclick

    public void ToolbarH(View v) {
        startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
    }

    public void MTabs(View v) {
        startActivity(new Intent(MainActivity.this, TabActivity.class));
    }

    public void FAB(View v) {
        startActivity(new Intent(MainActivity.this, FabMainActivity.class));
    }

    public void MDialogs(View v) {
        startActivity(new Intent(MainActivity.this, DialogsActivity.class));
    }

    public void RV(View v) {
        startActivity(new Intent(MainActivity.this, RVActivity.class));
    }

    public void BSheet(View v) {
        startActivity(new Intent(MainActivity.this, BottomsheetActivity.class));
    }

    public void MScrollbar(View v) {
        startActivity(new Intent(MainActivity.this, ScrollBarActivity.class));
    }

    public void SearchV(View v) {
        startActivity(new Intent(MainActivity.this, SearchViewActivity.class));
    }

    public void MPicker(View v) {
        startActivity(new Intent(MainActivity.this, MaterialPickerActivity.class));
    }

    //    Android Patterns

    public void AppIntro(View v) {
        startActivity(new Intent(MainActivity.this, AppIntroMainActivity.class));
    }

    public void Login(View v) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    public void Swipeable(View v) {
        startActivity(new Intent(MainActivity.this, SwipeableLayoutActivity.class));
    }

    public void Bubbles(View v) {
        startActivity(new Intent(MainActivity.this, BubblesActivity.class));
    }

    public void Achievement(View v) {
        startActivity(new Intent(MainActivity.this, AchievementActivity.class));
    }

    public void PullRefresh(View v) {
        startActivity(new Intent(MainActivity.this, PullToRefresh.class));
    }

    public void ListView(View v) {
        startActivity(new Intent(MainActivity.this, MainListActivity.class));
    }

    public void TextView(View v) {
        startActivity(new Intent(MainActivity.this, TextViewActivity.class));
    }

    public void ElasticD(View v) {
        startActivity(new Intent(MainActivity.this, ElasticDownloadActivity.class));
    }

//    Bonus

    public void UIElements(View v) {
        startActivity(new Intent(MainActivity.this, UIActivity.class));
    }

    public void Sweet(View v) {
        startActivity(new Intent(MainActivity.this, SweetSheetActivity.class));
    }

    public void ShareV(View v) {
        startActivity(new Intent(MainActivity.this, ShareViewActivity.class));
    }

    public void TextS(View v) {
        startActivity(new Intent(MainActivity.this, TextSurfaceMainActivity.class));
    }

}
