package com.esime.nutrisimios_bd.ui.Plan;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esime.nutrisimios_bd.R;

public class Alimento_description extends DialogFragment {
    TextView tvNombre, tvGrupoAlimenticio, tvporcion, tvproteina, tvSodio, tvCalorias, tvGrasas, tvCarbohidratos;
    String info [];

    public Alimento_description(String info []){
        this.info = info;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_alimento_description, container, false);
        geById(view);
        getData();
        return view;

    }

    public void getData(){
        tvNombre.setText(tvNombre.getText()+": "+info[0]);
        tvGrupoAlimenticio.setText(tvGrupoAlimenticio.getText()+": "+info[1]);
        tvporcion.setText(tvporcion.getText()+": "+info[2]);
        tvproteina.setText(tvproteina.getText()+": "+info[3]);
        tvSodio.setText(tvSodio.getText()+": "+info[4]);
        tvCalorias.setText(tvCalorias.getText()+": "+info[5]);
        tvGrasas.setText(tvGrasas.getText()+": "+info[6]);
        tvCarbohidratos.setText(tvCarbohidratos.getText()+": "+info[7]);
    }

    private void geById(View view) {
        tvNombre = view.findViewById(R.id.alimento_desc_tvName);
        tvGrupoAlimenticio = view.findViewById(R.id.food_desc_GrupoA);
        tvporcion = view.findViewById(R.id.food_desc_Porcion);
        tvproteina = view.findViewById(R.id.food_desc_Proteina);
        tvSodio = view.findViewById(R.id.food_desc_Sodio);
        tvCalorias = view.findViewById(R.id.food_desc_Calorias);
        tvGrasas = view.findViewById(R.id.food_desc_Grasas);
        tvCarbohidratos = view.findViewById(R.id.food_desc_Carbohidratos);
    }
}