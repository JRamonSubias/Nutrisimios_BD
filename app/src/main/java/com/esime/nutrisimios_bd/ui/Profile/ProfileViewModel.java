package com.esime.nutrisimios_bd.ui.Profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esime.nutrisimios_bd.Data.Repository;
import com.esime.nutrisimios_bd.Data.model.Cita;

import java.util.List;

public class ProfileViewModel extends ViewModel {
    private final Repository repository;
    private MutableLiveData<List<Cita>> listCitasLiveData;

    public ProfileViewModel() {
       repository = new Repository();
       }


     public MutableLiveData<List<Cita>> getListCitas  (String id_nutriologo){
            listCitasLiveData = repository.getListCitasNutriologo(id_nutriologo);
            return listCitasLiveData;
     }

     public void deleteNutriologo(String idNutriologo){
        repository.deleteNutriologo(idNutriologo);
        repository.deleteNameNutriologo(idNutriologo);
     }

}
