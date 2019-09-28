package com.example.nuts.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuts.DummyContent;
import com.example.nuts.R;
import com.example.nuts.adapter.SliderAdapter;
import com.example.nuts.adapter.categoryAdapter;
import com.example.nuts.adapter.productAdapter;
import com.example.nuts.eventBus.ShowNavigationEvent;
import com.example.nuts.eventBus.ShowToolbarEvent;
import com.example.nuts.utils.RecyclerSnapHelper;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.greenrobot.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);

        final Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        EventBus.getDefault().post(new ShowToolbarEvent(toolbar, true));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ShowNavigationEvent());
            }
        });


        RecyclerView recyclerView = view.findViewById(R.id.rv_category);
        recyclerView.setLayoutManager(new /*RTL*/LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));
        //recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new categoryAdapter(DummyContent.ITEMS));
        RecyclerSnapHelper snapHelper = new RecyclerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        RecyclerView recyclerView1 = view.findViewById(R.id.rv_top_selling);
        recyclerView1.setLayoutManager(new /*RTL*/LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setAdapter(new productAdapter(DummyContent.ITEMS));

        RecyclerView recyclerView2 = view.findViewById(R.id.rv_newest);
        recyclerView2.setLayoutManager(new /*RTL*/LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(new productAdapter(DummyContent.ITEMS));


        SliderView sliderView = view.findViewById(R.id.imageSlider);
        SliderAdapter adapter = new SliderAdapter(getActivity());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        return view;
    }


}
