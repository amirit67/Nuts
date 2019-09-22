package com.example.nuts.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuts.FragmentStack;
import com.example.nuts.R;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login2Fragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login2, container, false);

        view.findViewById(R.id.btn_check_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentStack stack = new FragmentStack(getActivity(), getFragmentManager(), R.id.container2);
                stack.replace(new MainFragment());
            }
        });
        return view;
    }

}
