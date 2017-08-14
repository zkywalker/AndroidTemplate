package me.arulnadhan.androidultimate.RecyclerView.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.RecyclerView.demo_d.DraggableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_d_grid.DraggableGridExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_d_on_longpress.DragOnLongPressExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_d_with_section.DraggableWithSectionExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_ds.DraggableSwipeableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_e.ExpandableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_e_add_remove.AddRemoveExpandableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_e_already_expanded.AlreadyExpandedGroupsExpandableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_ed_with_section.ExpandableDraggableWithSectionExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_eds.ExpandableDraggableSwipeableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_s.SwipeableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_s_legacy.LegacySwipeableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_s_longpress.SwipeOnLongPressExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_s_vertical.VerticalSwipeableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_s_viewpager.ViewPagerSwipeableExampleActivity;
import me.arulnadhan.androidultimate.RecyclerView.demo_us.UnderSwipeableExampleActivity;

public class LauncherPageFragment extends Fragment {
    private static final String ARG_PAGE_NO = "page no";

    public static LauncherPageFragment newInstance(int pageNo) {
        LauncherPageFragment fragment = new LauncherPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NO, pageNo);
        fragment.setArguments(args);
        return fragment;
    }

    public LauncherPageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rv_fragment_recycler_list_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        int pageNo = getArguments().getInt(ARG_PAGE_NO);

        LauncherButtonsAdapter adapter = createAdapter(pageNo);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private LauncherButtonsAdapter createAdapter(int pageNo) {
        LauncherButtonsAdapter adapter = new LauncherButtonsAdapter(this);

        switch (pageNo) {
            case 0:
                // Drag
                adapter.put(DraggableExampleActivity.class, R.string.activity_title_demo_d);
                adapter.put(DragOnLongPressExampleActivity.class, R.string.activity_title_demo_d_on_longpress);
                adapter.put(DraggableWithSectionExampleActivity.class, R.string.activity_title_demo_d_with_section);
                adapter.put(DraggableGridExampleActivity.class, R.string.activity_title_demo_d_grid);
                break;
            case 1:
                // Swipe
                adapter.put(SwipeableExampleActivity.class, R.string.activity_title_demo_s);
                adapter.put(SwipeOnLongPressExampleActivity.class, R.string.activity_title_demo_s_on_longpress);
                adapter.put(UnderSwipeableExampleActivity.class, R.string.activity_title_demo_us);
                adapter.put(VerticalSwipeableExampleActivity.class, R.string.activity_title_demo_s_vertical);
                adapter.put(ViewPagerSwipeableExampleActivity.class, R.string.activity_title_demo_s_viewpager);
                adapter.put(LegacySwipeableExampleActivity.class, R.string.activity_title_demo_s_legacy);
                break;
            case 2:
                // Expand
                adapter.put(ExpandableExampleActivity.class, R.string.activity_title_demo_e);
                adapter.put(AddRemoveExpandableExampleActivity.class, R.string.activity_title_demo_e_add_remove);
                adapter.put(AlreadyExpandedGroupsExpandableExampleActivity.class, R.string.activity_title_demo_e_already_expanded);
                break;
            case 3:
                // Advanced
                adapter.put(DraggableSwipeableExampleActivity.class, R.string.activity_title_demo_ds);
                adapter.put(ExpandableDraggableSwipeableExampleActivity.class, R.string.activity_title_demo_eds);
                adapter.put(ExpandableDraggableWithSectionExampleActivity.class, R.string.activity_title_demo_ed_with_section);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return adapter;
    }
}
