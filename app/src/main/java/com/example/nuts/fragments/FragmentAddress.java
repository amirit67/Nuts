package com.example.nuts.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nuts.DummyContent;
import com.example.nuts.R;
import com.example.nuts.adapter.addressAdapter;
import com.example.nuts.utils.navigation.ItemDecorationAlbumColumns2;

public class FragmentAddress extends Fragment implements View.OnClickListener {


    private View rootView = null;
    private LinearLayoutManager layoutManager;
    private RecyclerView rv;

    private void DeclareElements() {
        //editTextSearch = rootView.findViewById(R.id.editTextSearch);
        rv = rootView.findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.addItemDecoration(new ItemDecorationAlbumColumns2(rv.getContext(), 1));

        rv.setLayoutManager(layoutManager);

        rv.setHasFixedSize(true);
        rv.setAdapter(new addressAdapter(DummyContent.ITEMS));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_addresses, container, false);
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
