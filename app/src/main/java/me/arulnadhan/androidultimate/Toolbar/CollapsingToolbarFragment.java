package me.arulnadhan.androidultimate.Toolbar;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.androidultimate.Toolbar.adapters.RecyclerAdapter;
import me.arulnadhan.androidultimate.Toolbar.models.CardItemModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollapsingToolbarFragment extends Fragment {

    private List<CardItemModel> cardItems = new ArrayList<>(20);
    private ToolBarActivity Activity;
    private Toolbar toolbar;
    private RecyclerView recyclerView;


    public CollapsingToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collapsing_toolbar, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((CollapseToolbar) getActivity()).setSupportActionBar(toolbar);

        ((CollapseToolbar) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar)).setTitle(
                getString(R.string.collapsing_toolbar_fragment_title));

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        setupRecyclerView();

        return view;
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(Activity));
        recyclerView.setHasFixedSize(true);
        initializeCardItemList();
        recyclerView.setAdapter(new RecyclerAdapter(cardItems));
    }

    private void initializeCardItemList() {
        CardItemModel cardItemModel;
        String[] cardTitles = getResources().getStringArray(R.array.card_titles);
        String[] cardContents = getResources().getStringArray(R.array.card_contents);
        final int length = cardTitles.length;
        for (int i = 0; i < length; i++) {
            cardItemModel = new CardItemModel(cardTitles[i], cardContents[i]);
            cardItems.add(cardItemModel);
        }
    }

}
