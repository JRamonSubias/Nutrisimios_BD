package com.esime.nutrisimios_bd.ui.Plan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esime.nutrisimios_bd.Data.Repository;
import com.esime.nutrisimios_bd.Data.model.Alimento;

import java.util.List;

public class    PlanViewModel extends ViewModel {

    private MutableLiveData<List<Alimento>> listAlimentoLiveData;
    Repository repository;

    public PlanViewModel() {
       repository = new Repository();
    }

    public MutableLiveData<List<Alimento>> getListAlimentos(){
        listAlimentoLiveData = repository.getListAlimento();
        return listAlimentoLiveData;
    }

    public void insertAlimento(String nombre, String proteina, String grasa, String sodio, String carbos, String calorias,
                               String porcion, String grupoAlimenticio ){
        repository.insertAlimento(nombre, proteina, grasa, sodio, carbos, calorias, porcion, grupoAlimenticio);

    }

}