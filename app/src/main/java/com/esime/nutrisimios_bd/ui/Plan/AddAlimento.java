package com.esime.nutrisimios_bd.ui.Plan;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.esime.nutrisimios_bd.MyApp.MyApp;
import com.esime.nutrisimios_bd.R;
import com.google.android.material.textfield.TextInputLayout;

public class AddAlimento extends DialogFragment {
    TextInputLayout etNameAlimento, etProteina, etGrasa, etSodio, etCarbos, etCalorias;
    TextView tvPorcion;
    Spinner spGrupoA;
    Button btnPorcionM, getBtnPorcionP, btnAddAliment;
    String nombre, proteina, grasa, sodio,carbos, calorias, porcion, grupoAlimenticio;
    PlanViewModel planViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.FullScreenDialogStyle);
        planViewModel = new ViewModelProvider(this).get(PlanViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_alimento, container, false);
        getById(view);
        btnPorcionM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int porcion =  Integer.parseInt(tvPorcion.getText().toString()) - 1;
               tvPorcion.setText("0"+porcion);
            }
        });

        getBtnPorcionP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int porcion =  Integer.parseInt(tvPorcion.getText().toString()) + 1;
                tvPorcion.setText("0"+porcion);
            }
        });

        btnAddAliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformation();
                planViewModel.repository.insertAlimento(nombre,proteina,grasa,sodio,carbos,calorias,porcion,grupoAlimenticio);
            }
        });

        return view;
    }

    private void getInformation(){

        nombre = etNameAlimento.getEditText().getText().toString();
        proteina = etProteina.getEditText().getText().toString();
        grasa = etGrasa.getEditText().getText().toString();
        sodio = etSodio.getEditText().getText().toString();
        carbos = etCarbos.getEditText().getText().toString();
        calorias = etCalorias.getEditText().getText().toString();
        porcion = tvPorcion.getText().toString();

        switch (spGrupoA.getSelectedItem().toString()){
            case "Verduras": grupoAlimenticio="1";
            break;
            case "Frutas": grupoAlimenticio="2";
            break;
            case "Cereales y tuberculos": grupoAlimenticio="3";
                break;
            case "Leguminosas": grupoAlimenticio="4";
                break;
            case "Leche": grupoAlimenticio="5";
                break;
            case "Alimentos de origen animal": grupoAlimenticio="6";
                break;
            case "Aceites y Grasas": grupoAlimenticio="7";
                break;
            case "Azucares": grupoAlimenticio="8";
                break;
            case "Alimentos libres en energia": grupoAlimenticio="9";
                break;
            case "Bebidas alcoholicas": grupoAlimenticio="10";
                break;
        }

    }


    private void getById(View view) {
        etNameAlimento = view.findViewById(R.id.addAlimento_EtNombre);
        etProteina = view.findViewById(R.id.addAlimentos_Proteina);
        etGrasa = view.findViewById(R.id.addAlimentos_etGrasas);
        etSodio = view.findViewById(R.id.addAlimentos_etSodio);
        etCarbos = view.findViewById(R.id.addAlimentos_etCarbos);
        etCalorias = view.findViewById(R.id.addAlimentos_etCalorias);
        tvPorcion = view.findViewById(R.id.addAlimento_tvPorcion);
        btnPorcionM = view.findViewById(R.id.addAlimento_btnMenosPorcion);
        getBtnPorcionP = view.findViewById(R.id.addAlimento_btnPlusPorcion);
        btnAddAliment = view.findViewById(R.id.addAlimentos_btnAdd);
        spGrupoA = view.findViewById(R.id.addAlimentos_spGrupoAli);

        ArrayAdapter<CharSequence> adapterName =
                ArrayAdapter.createFromResource(MyApp.getContext(),R.array.grupo_alimenticio, android.R.layout.simple_spinner_item);
        adapterName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGrupoA.setAdapter(adapterName);

    }
}