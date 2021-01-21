package com.esime.nutrisimios_bd.ui.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esime.nutrisimios_bd.Data.model.Cita;
import com.esime.nutrisimios_bd.MyApp.Constants;
import com.esime.nutrisimios_bd.MyApp.SharedPreferenceManager;
import com.esime.nutrisimios_bd.R;

import java.util.List;

public class Profile extends Fragment {

    private ProfileViewModel profileViewModel;
    private TextView tvFullName, tvEmail, tvTelephone, tvClinic;
    private RecyclerView recyclerView;
    private ImageView ivConfiurations;
    private ProfileAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        getById(view);
        loadUserInformation();
        loadCitasNutriologo();

        ivConfiurations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeetingProfile profile = new SeetingProfile();
                profile.show(getChildFragmentManager(),"SeetingProfile");
            }
        });

        return view;
    }

    private void loadUserInformation(){
        String fullName = SharedPreferenceManager
                .getSomeStringValue(Constants.NUTRIOLOGO_NOMBRE) + " " +
                SharedPreferenceManager
                .getSomeStringValue(Constants.NUTRIOLOGO_APPaterno)+" "+
                SharedPreferenceManager.getSomeStringValue(Constants.NUTRIOLOGO_APMATERNO);
        tvFullName.setText(fullName);
        tvEmail.setText(SharedPreferenceManager.getSomeStringValue(Constants.NUTRIOLOGO_CORREO));
        tvClinic.setText(SharedPreferenceManager.getSomeStringValue(Constants.NUTRIOLOGO_CLINICA));
        tvTelephone.setText(SharedPreferenceManager.getSomeStringValue(Constants.NUTRIOLOGO_TELEFONO));
    }

    private void loadCitasNutriologo(){
            profileViewModel.getListCitas(SharedPreferenceManager.getSomeStringValue(Constants.ID_NUTRIOGOLO))
                    .observe(getActivity(), new Observer<List<Cita>>() {
                        @Override
                        public void onChanged(List<Cita> citas) {
                            adapter = new ProfileAdapter(getChildFragmentManager(),citas);
                            recyclerView.setAdapter(adapter);
                            final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                            recyclerView.setLayoutManager(layoutManager);
                        }
                    });
    }


    private void getById(View view) {
        tvFullName = view.findViewById(R.id.profile_tvNombre);
        tvEmail = view.findViewById(R.id.profile_tvCorreo);
        tvTelephone = view.findViewById(R.id.profile_tvPhone);
        tvClinic = view.findViewById(R.id.profile_tvClinica);
        recyclerView = view.findViewById(R.id.profile_recyclerView);
        ivConfiurations = view.findViewById(R.id.imageViewSetting);
    }
}