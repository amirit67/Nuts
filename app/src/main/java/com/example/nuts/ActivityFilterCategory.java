package com.example.nuts;


import android.app.AppComponentFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuts.adapter.FilterAdapter;
import com.example.nuts.adapter.FilterCategoryAdapter;
import com.example.nuts.utils.navigation.ItemDecorationAlbumColumns2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

public class ActivityFilterCategory extends AppCompatActivity {

    private  List<DummyContent.DummyItem> feed = new ArrayList<>();
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category);

        feed.addAll(DummyContent.ITEMS);
        Collections.reverse(feed);

        mViewPager = findViewById(R.id.pager);
        mViewPager.setOffscreenPageLimit(feed.size() - 1);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), feed);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = findViewById(R.id.materialTabHost);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(feed.size() - 1/* - Integer.parseInt(getIntent().getExtras().getString("position"))*/);


    }

    public static class SubCategoryFragment extends Fragment {


        public RecyclerView rv;
        private FilterCategoryAdapter adapter;
        private LinearLayoutManager layoutManager;
        private View rootView = null;

        @SuppressWarnings("deprecation")
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            if (rootView == null) {
                rootView = inflater.inflate(R.layout.fragment_categories, container, false);
                rv = rootView.findViewById(R.id.listView);
                layoutManager = new LinearLayoutManager(getActivity());
                rv.addItemDecoration(new ItemDecorationAlbumColumns2(rv.getContext(), 1));
                StaggeredGridLayoutManager lmanager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                rv.setLayoutManager(lmanager);
                rv.setHasFixedSize(true);
                int pos = getArguments().getInt("pos");
                //adapter = new FilterCategoryAdapter(getActivity(), feed, pos);
                //rv.setAdapter(adapter);
                rv.setAdapter(new FilterCategoryAdapter(DummyContent.ITEMS));
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<DummyContent.DummyItem> feed;

        public SectionsPagerAdapter(FragmentManager fm,  List<DummyContent.DummyItem> feed) {
            super(fm);
            this.feed = feed;
        }

        @Override
        public Fragment getItem(int index) {
            SubCategoryFragment fra = new SubCategoryFragment();
            Bundle bnd = new Bundle();
            bnd.putInt("pos", index);
            fra.setArguments(bnd);
            return fra;
        }

        @Override
        public int getCount() {
            return feed.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return feed.get(position).content;
        }
    }
}