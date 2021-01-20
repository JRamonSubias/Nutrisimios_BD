package com.esime.nutrisimios_bd.ui.Pacientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esime.nutrisimios_bd.Data.model.Paciente;
import com.esime.nutrisimios_bd.MyApp.Constants;
import com.esime.nutrisimios_bd.MyApp.SharedPreferenceManager;
import com.esime.nutrisimios_bd.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Progress extends Fragment {
    private PacienteViewModel pacienteViewModel;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pacienteViewModel =
                new ViewModelProvider(this).get(PacienteViewModel.class);
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        getById(view);
        getListCita();

        floatingActionButton.setOnClickListener(v -> {
              AddPaciente addPaciente = new AddPaciente();
              addPaciente.show(getChildFragmentManager(),"AddPaciente");
        });
        return view;
    }

    private void getById(View view) {
        recyclerView = view.findViewById(R.id.cita_recyclerView);
        floatingActionButton = view.findViewById(R.id.cita_floatingButtom);
    }

    private void getListCita(){
        pacienteViewModel.getPacientes(SharedPreferenceManager
                .getSomeStringValue(Constants.NUTRIOLOGO_CLINICA))
                .observe(getActivity(), new Observer<List<Paciente>>() {
                    @Override
                    public void onChanged(List<Paciente> pacientes) {
                        PacienteAdapter pacienteAdapter = new PacienteAdapter(getChildFragmentManager(),pacientes);
                        recyclerView.setAdapter(pacienteAdapter);
                        recyclerView.setHasFixedSize(true);

                        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                        recyclerView.setLayoutManager(layoutManager);
                    }
                });
    }
}