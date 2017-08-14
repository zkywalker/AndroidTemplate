package me.arulnadhan.androidultimate.ScrollBar;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.scrollbar.INameableAdapter;

/**
 * Created by AruLNadhaN on 26-09-2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements INameableAdapter {
    private Activity act;

    public RecyclerAdapter(Activity a) {
        act = a;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(ScrollBarActivity.list.get(position));
    }

    @Override
    public int getItemCount() {
        return ScrollBarActivity.list.size();
    }

    @Override
    public Character getCharacterForElement(int element) {
        Character first = ScrollBarActivity.list.get(element).charAt(0);
        if (Character.isDigit(first)) {
            first = '#';
        }
        return first;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public me.arulnadhan.robototextview.widget.RobotoTextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (me.arulnadhan.robototextview.widget.RobotoTextView) itemView;
        }
    }
}