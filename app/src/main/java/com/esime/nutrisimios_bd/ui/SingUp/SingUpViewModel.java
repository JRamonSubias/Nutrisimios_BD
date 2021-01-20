package com.esime.nutrisimios_bd.ui.SingUp;

import androidx.lifecycle.ViewModel;

import com.esime.nutrisimios_bd.Data.Repository;
import com.esime.nutrisimios_bd.ui.SingIn.SinginViewModel;

public class SingUpViewModel  extends ViewModel {
    private Repository repository;

    public SingUpViewModel(){
        repository = new Repository();
    }


    public void insertNutriologo(String email, String nombre, String apPaterno, String apMaterno, String password,String id_clinica,String cedula, String direccion,String telefono){

        repository.insertNutriologo(email, nombre, apPaterno, apMaterno, password, id_clinica, cedula, direccion, telefono);
    }





}
