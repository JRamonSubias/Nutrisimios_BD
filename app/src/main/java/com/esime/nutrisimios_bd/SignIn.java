package com.esime.nutrisimios_bd;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;


public class SignIn extends Fragment {
    Button btnSingIn;
    TextInputLayout etUser, etPassword;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sing_in, container, false);
        getFindById(view);
        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NutriActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void getFindById(View view) {
        btnSingIn = view.findViewById(R.id.singInBtn);
        etUser = view.findViewById(R.id.singInETUser);
        etPassword = view.findViewById(R.id.singInEtpassword);

    }
}