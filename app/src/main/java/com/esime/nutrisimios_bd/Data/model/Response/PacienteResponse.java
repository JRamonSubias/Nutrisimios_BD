package com.esime.nutrisimios_bd.Data.model.Response;

import com.esime.nutrisimios_bd.Data.model.Paciente;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PacienteResponse {

    @SerializedName("Paciente")
    @Expose
    private List<Paciente> paciente = new ArrayList<Paciente>();

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

}