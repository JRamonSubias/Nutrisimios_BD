package com.esime.nutrisimios_bd.ui.Profile;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.esime.nutrisimios_bd.MyApp.Constants;
import com.esime.nutrisimios_bd.MyApp.SharedPreferenceManager;
import com.esime.nutrisimios_bd.R;
import com.esime.nutrisimios_bd.ui.Profile.ProfileViewModel;


public class SeetingProfile extends DialogFragment {
    Button btnDeleteProfile;
    ProfileViewModel profileViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_seeting_profile, container, false);
        btnDeleteProfile =  view.findViewById(R.id.setting_deleteProfile);

        btnDeleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNutriologo = SharedPreferenceManager.getSomeStringValue(Constants.ID_NUTRIOGOLO);
                profileViewModel.deleteNutriologo(idNutriologo);
            }
        });
        return view;
    }
}