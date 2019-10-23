package com.example.nuts;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.nuts.fragments.SubCategoryFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityFilterCategory extends AppCompatActivity {

    private static Dialog dialog;
    private List<DummyContent.DummyItem> feed = new ArrayList<>();
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<DummyContent.DummyItem> feed;

        public SectionsPagerAdapter(FragmentManager fm, List<DummyContent.DummyItem> feed) {
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