package com.example.nuts.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuts.FragmentStack;
import com.example.nuts.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login1Fragment extends Fragment {


    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login1, container, false);

        view.findViewById(R.id.btn_check_mobile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((TextInputEditText)view.findViewById(R.id.et_mobile)).getText().length() > 0) {
                    FragmentStack stack = new FragmentStack(getActivity(), getFragmentManager(), R.id.container);
                    stack.replace(new Login2Fragment());
                }
                else
                    ((TextInputLayout)view.findViewById(R.id.textInputLayout_mobile)).setError("شماره موبایل را وارد نمایید");
            }
        });
        return view;
    }

}
