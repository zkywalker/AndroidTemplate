package me.arulnadhan.androidultimate.Themer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.IntentCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.arulnadhan.androidultimate.MainActivity;
import me.arulnadhan.androidultimate.R;


public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.MyVH> {

    private final LayoutInflater inflater;
    private List<Theme> ThemeList;
    private final Activity mActivity;


    public ThemeAdapter(Context context, Activity mActivity, List<Theme> ThemeList) {
        inflater = LayoutInflater.from(context);
        this.ThemeList = ThemeList;
        this.mActivity = mActivity;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.theme_card, parent, false);
        MyVH holder = new MyVH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        Theme current = ThemeList.get(position);
        holder.name.setText(current.Name);
        holder.mCardView.setCardBackgroundColor(Color.parseColor(current.Color));
    }

    @Override
    public int getItemCount() {
        return ThemeList.size();
    }

    class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        me.arulnadhan.robototextview.widget.RobotoTextView name;
        CardView mCardView;
        Context context;

        public MyVH(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            name = (me.arulnadhan.robototextview.widget.RobotoTextView) itemView.findViewById(R.id.Theme);
            mCardView = (CardView) itemView.findViewById(R.id.ThemeCard);
        }

        @Override
        public void onClick(View view) {
            switch (getAdapterPosition()) {
                case 0:
                    Utility.setTheme(context, 0);
                    recreateActivity();
                    break;
                case 1:
                    Utility.setTheme(context, 1);
                    recreateActivity();
                    break;
                case 2:
                    Utility.setTheme(context, 2);
                    recreateActivity();
                    break;
                case 3:
                    Utility.setTheme(context, 3);
                    recreateActivity();
                    break;
                case 4:
                    Utility.setTheme(context, 4);
                    recreateActivity();
                    break;
                case 5:
                    Utility.setTheme(context, 5);
                    recreateActivity();
                    break;
                case 6:
                    Utility.setTheme(context, 6);
                    recreateActivity();
                    break;
                case 7:
                    Utility.setTheme(context, 7);
                    recreateActivity();
                    break;
            }
        }
    }


    public void recreateActivity() {
        mActivity.finish();
        final Intent intent = IntentCompat.makeMainActivity(new ComponentName(mActivity, MainActivity.class));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        mActivity.startActivity(intent);
    }

}
