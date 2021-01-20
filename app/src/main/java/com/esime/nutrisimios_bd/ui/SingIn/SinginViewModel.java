package com.esime.nutrisimios_bd.ui.SingIn;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esime.nutrisimios_bd.Data.Repository;
import com.esime.nutrisimios_bd.Data.model.Nutriologo;

public class SinginViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<Nutriologo> nutriologoMutableLiveData;

    public SinginViewModel(){
        repository = new Repository();
    }


  public  MutableLiveData<Nutriologo> validateNutriologo (String correo, String password){
        nutriologoMutableLiveData = repository.validateNutriologo(correo, password);
        return nutriologoMutableLiveData;
  }


}
