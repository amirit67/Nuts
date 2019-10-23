package com.example.nuts.fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.nuts.DummyContent;
import com.example.nuts.R;
import com.example.nuts.adapter.FilterAdapter;
import com.example.nuts.utils.navigation.ItemDecorationAlbumColumns2;

public class FragmentCategories extends Fragment implements View.OnClickListener {


    private View rootView = null;
    private LinearLayoutManager layoutManager;
    private RecyclerView rv;

    private void DeclareElements() {
        //editTextSearch = rootView.findViewById(R.id.editTextSearch);
        rv = rootView.findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.addItemDecoration(new ItemDecorationAlbumColumns2(rv.getContext(), 1));
        StaggeredGridLayoutManager lmanager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(lmanager);

        rv.setHasFixedSize(true);
        rv.setAdapter(new FilterAdapter(DummyContent.ITEMS));


        rootView.findViewById(R.id.txt_advance_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                Window window = dialog.getWindow();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialog_advane_search);

                ViewGroup.LayoutParams params = window.getAttributes();
                window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes((WindowManager.LayoutParams) params);
                window.setGravity(Gravity.CENTER);

                dialog.show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        DeclareElements();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


        }
    }


}
