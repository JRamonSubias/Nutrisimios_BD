package com.esime.nutrisimios_bd.Data.model.Response;

import com.esime.nutrisimios_bd.Data.model.Nombre_Paciente;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NombrePacienteResponse{

    @SerializedName("Name")
    @Expose
    private List<Nombre_Paciente> userName = new ArrayList<Nombre_Paciente>();

    public List<Nombre_Paciente> getListName() {
        return userName;
    }

    public void setListName(List<Nombre_Paciente> userName) {
        this.userName = userName;
    }

}
