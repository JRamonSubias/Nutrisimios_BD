package com.esime.nutrisimios_bd.ui.Pacientes;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.esime.nutrisimios_bd.MyApp.Constants;
import com.esime.nutrisimios_bd.MyApp.MyApp;
import com.esime.nutrisimios_bd.MyApp.SharedPreferenceManager;
import com.esime.nutrisimios_bd.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

public class AddPaciente extends DialogFragment {
     private TextInputLayout etNombre, etApPaterno, etApMaterno, etEdad,
                    etCorreo, etTelefono, etPeso, etAltura, etCintura, etCadera;
     private Chip chMan, chWoman;
     private Spinner spPadecimineto, spTipo, spGrado;
     private Button btnAddPaciente;
     private PacienteViewModel pacienteViewModel;
     private String nombre, apPaterno, apMaterno, Edad, Correo, Telefono, Peso, Altura, Cintura, Cadera,
                sexo, padecimiento, tipo, grado,idClinica;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.FullScreenDialogStyle);
        pacienteViewModel =  new ViewModelProvider(this).get(PacienteViewModel.class);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_paciente, container, false);
        getById(view);


        btnAddPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getInformation();
                pacienteViewModel.InsertPaciente(nombre,apPaterno,apMaterno,sexo,Edad,Correo,Telefono,padecimiento,tipo,
                        grado,Peso,Altura,Cintura,Cadera,idClinica);
            }
        });
        return view;
    }

    private void getInformation(){
        nombre = etNombre.getEditText().getText().toString();
        apPaterno = etApPaterno.getEditText().getText().toString();
        apMaterno = etApMaterno.getEditText().getText().toString();
        Edad = etEdad.getEditText().getText().toString();
        Correo = etCorreo.getEditText().getText().toString();
        Telefono = etTelefono.getEditText().getText().toString();
        Peso = etPeso.getEditText().getText().toString();
        Altura = etAltura.getEditText().getText().toString();
        Cintura = etCintura.getEditText().getText().toString();
        Cadera = etCadera.getEditText().getText().toString();
        padecimiento = spPadecimineto.getSelectedItem().toString();
        tipo = spTipo.getSelectedItem().toString();
        grado = spGrado.getSelectedItem().toString();
        if(chMan.isChecked()){
            sexo="H";
        }else{
            sexo="M";
        }
        String id = SharedPreferenceManager.getSomeStringValue(Constants.NUTRIOLOGO_CLINICA);
        if(id.equals("NUTRISIMIOS")){
            idClinica="1";
        }else{
            idClinica="2";
        }

    }

    private void getById(View view) {
        etNombre = view.findViewById(R.id.addAlimento_EtNombre);
        etApPaterno = view.findViewById(R.id.addPaciente_EtApPaterno);
        etApMaterno = view.findViewById(R.id.addPaciente_EtAp_Materno);
        etEdad = view.findViewById(R.id.addPaciente_Edad);
        etCorreo = view.findViewById(R.id.addPaciente_etCorreo);
        etTelefono = view.findViewById(R.id.addPaciente_etTelefono);
        etPeso = view.findViewById(R.id.addPaciente_etPeso);
        etAltura = view.findViewById(R.id.addPaciente_etAltura);
        etCintura = view.findViewById(R.id.addPaciente_etCintura);
        etCadera = view.findViewById(R.id.addPaciente_etCadera);
        chMan = view.findViewById(R.id.addPaciente_chipMan);
        chWoman = view.findViewById(R.id.addPaciente_chipWoman);
        spPadecimineto = view.findViewById(R.id.addPaciente_spinner_NamePadecimiento);
        spTipo = view.findViewById(R.id.addPaciente_spinner_TypePadecimiento);
        spGrado = view.findViewById(R.id.addPaciente_spinner_GravePadecimiento);
        btnAddPaciente = view.findViewById(R.id.addPaciente_btnAddPaciente);

        //inflamos los spinner con las listas hechas
            //NamePadecimientos
        ArrayAdapter<CharSequence> adapterName =
                ArrayAdapter.createFromResource(MyApp.getContext(),R.array.padecimientos_array, android.R.layout.simple_spinner_item);
        adapterName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPadecimineto.setAdapter(adapterName);
            //TipoPadecimiento
        ArrayAdapter<CharSequence> adapterType =
                ArrayAdapter.createFromResource(MyApp.getContext(),R.array.Type_array, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adapterType);
            //GradoPadecimiento
        ArrayAdapter<CharSequence> adapterGrade =
                ArrayAdapter.createFromResource(MyApp.getContext(),R.array.grade_array, android.R.layout.simple_spinner_item);
        adapterGrade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGrado.setAdapter(adapterGrade);

    }
}