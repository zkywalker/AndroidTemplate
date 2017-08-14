package me.arulnadhan.androidultimate.RecyclerView.launcher;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.recyclerview.utils.RecyclerViewAdapterUtils;

public class LauncherButtonsAdapter
        extends RecyclerView.Adapter<LauncherButtonsAdapter.ViewHolder>
        implements View.OnClickListener {

    private static class LauncherItem {
        private final Class<? extends Activity> mActivityClass;
        @StringRes
        private final int mTextRes;

        public LauncherItem(Class<? extends Activity> activityClass, @StringRes int textRes) {
            mActivityClass = activityClass;
            mTextRes = textRes;
        }
    }

    private Fragment mFragment;
    private List<LauncherItem> mItems;

    public LauncherButtonsAdapter(Fragment fragment) {
        mFragment = fragment;
        mItems = new ArrayList<>();
    }

    public void put(Class<? extends Activity> activityClass, @StringRes int textRes) {
        mItems.add(new LauncherItem(activityClass, textRes));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_launcher_button, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.mButton.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LauncherItem item = mItems.get(position);
        holder.mButton.setText(item.mTextRes);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(View v) {
        ViewHolder viewHolder = (ViewHolder) RecyclerViewAdapterUtils.getViewHolder(v);
        int position = viewHolder.getAdapterPosition();

        Intent intent = new Intent(v.getContext(), mItems.get(position).mActivityClass);
        mFragment.startActivity(intent);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        public ViewHolder(View itemView) {
            super(itemView);
            mButton = (Button) itemView;
        }
    }
}
