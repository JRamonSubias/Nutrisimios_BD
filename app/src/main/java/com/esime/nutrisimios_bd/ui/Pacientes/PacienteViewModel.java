package com.esime.nutrisimios_bd.ui.Pacientes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esime.nutrisimios_bd.Data.Repository;
import com.esime.nutrisimios_bd.Data.model.Alimento;
import com.esime.nutrisimios_bd.Data.model.Medida;
import com.esime.nutrisimios_bd.Data.model.Paciente;
import com.esime.nutrisimios_bd.Data.model.Padecimiento;
import com.esime.nutrisimios_bd.MyApp.Constants;
import com.esime.nutrisimios_bd.MyApp.SharedPreferenceManager;

import java.util.List;

public class PacienteViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<List<Paciente>> listPaciente;
    private MutableLiveData<Medida> medidaLiveData;
    private MutableLiveData<List<Alimento>> listAlimentoLiveData;

    private List<Padecimiento> listPadecimiento;

    public PacienteViewModel() {
       repository = new Repository();
    }

    public MutableLiveData<List<Paciente>> getPacientes(String id){
        String id_clinica;
        if(id.equals("NUTRISIMIOS")){
            id_clinica="1";
        }else{
            id_clinica="2";
        }
        listPaciente = repository.getListPacientesClinica(id_clinica);
        return listPaciente;
    }

    public MutableLiveData<Medida>  getMedidaPaciente(String id_medida){
        medidaLiveData = repository.getMedidaPaciente(id_medida);
        return medidaLiveData;
    }

    public MutableLiveData<List<Alimento>> getAlimentoPaciente(String id_paciente){
        listAlimentoLiveData = repository.getListAlimentoPaciente(id_paciente);
        return listAlimentoLiveData;
    }


    public void InsertPaciente (String nombre, String apPaterno, String apMaterno, String sexo,
                                String edad, String correo, String telefono, String padecimiento, String tipo,
                                String grado, String peso, String altura, String cintura, String cadera,String clinica){

        repository.InsertPaciente(nombre, apPaterno, apMaterno, sexo, edad, correo, telefono, padecimiento, tipo, grado, peso, altura, cintura, cadera, clinica);
    }





}