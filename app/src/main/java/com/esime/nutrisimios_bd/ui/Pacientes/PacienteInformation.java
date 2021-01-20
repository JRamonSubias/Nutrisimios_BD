package com.esime.nutrisimios_bd.ui.Pacientes;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esime.nutrisimios_bd.Data.model.Alimento;
import com.esime.nutrisimios_bd.Data.model.Medida;
import com.esime.nutrisimios_bd.R;

import java.util.List;

public class PacienteInformation extends DialogFragment {
    TextView tvEmail, tvTelefono, tvName, tvPadecimiento,
            tvEdad, tvSexo, tvPeso, tvAltura, tvCadera, tvCintura, tvIMC, tvICC;
    RecyclerView recyclerView;
    PacienteViewModel pacienteViewModel;
    String name, email, telefono, padecimiento, edad, sexo, id_medida, id_paciente;
    Medida medida;

    public PacienteInformation(String name, String email, String telefono, String padecimiento,
                               String edad, String sexo, String id_medida, String id_paciente){
        this.name = name;
        this.email = email;
        this.telefono = telefono;
        this.padecimiento = padecimiento;
        this.edad = edad;
        this.sexo = sexo;
        this.id_medida = id_medida;
        this.id_paciente = id_paciente;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.FullScreenDialogStyle);
        pacienteViewModel =
                new ViewModelProvider(this).get(PacienteViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paciente_information, container, false);
        getById(view);
        loadInformation();
        getMedida();
        loadRecyclerView();
        return view;
    }

    private void loadInformation(){
        tvEmail.setText(email);
        tvTelefono.setText(telefono);
        tvName.setText(name);
        tvPadecimiento.setText(padecimiento);
        tvEdad.setText(edad);
        tvSexo.setText(sexo);
    }

    private void getMedida(){
        pacienteViewModel.getMedidaPaciente(id_medida).observe(getActivity(), new Observer<Medida>() {
            @Override
            public void onChanged(Medida medida) {
                tvAltura.setText("Altura: "+medida.getTalla());
                tvPeso.setText("Peso: "+medida.getPeso());
                tvCadera.setText("Cadera: "+medida.getCadera());
                tvCintura.setText("Cintura: "+medida.getCintura());
                tvIMC.setText("IMC: "+medida.getIMC());
                tvICC.setText("ICC: "+medida.getICC());
            }
        });

    }

    private void loadRecyclerView(){
       pacienteViewModel.getAlimentoPaciente(id_paciente).observe(getActivity(), new Observer<List<Alimento>>() {
           @Override
           public void onChanged(List<Alimento> list) {
               PacienteInformationAdapter pacienteInformationAdapter =
                                        new PacienteInformationAdapter(getChildFragmentManager(),list);
               recyclerView.setAdapter(pacienteInformationAdapter);
               recyclerView.setHasFixedSize(true);
               final GridLayoutManager layoutManager = new GridLayoutManager(getContext(),4);
               recyclerView.setLayoutManager(layoutManager);
           }
       });

    }

    private void getById(View view) {
        tvEmail = view.findViewById(R.id.pacInfo_tvCorreo);
        tvTelefono = view.findViewById(R.id.pacInfo_tvTelefono);
        tvName = view.findViewById(R.id.pacInfo_tvName);
        tvPadecimiento = view.findViewById(R.id.pacInfo_tvPadecimiento);
        tvEdad = view.findViewById(R.id.pacInfo_tvEdad);
        tvSexo = view.findViewById(R.id.pacInfo_tvSexo);
        tvPeso = view.findViewById(R.id.pacInfo_tvPeso);
        tvAltura = view.findViewById(R.id.pacInfo_tvAltura);
        tvCadera = view.findViewById(R.id.pacInfo_tvCadera);
        tvCintura = view.findViewById(R.id.pacInfo_tvCintura);
        tvIMC = view.findViewById(R.id.pacInfo_tvIMC);
        tvICC = view.findViewById(R.id.pacInfo_tvICC);
        recyclerView = view.findViewById(R.id.pacInfo_recyclerView);
    }
}