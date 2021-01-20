package com.esime.nutrisimios_bd.Data.model.Response;

import com.esime.nutrisimios_bd.Data.model.Cita;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CitaResponse{

    @SerializedName("Cita")
    @Expose
    private List<Cita> cita = new ArrayList<Cita>();

    public List<Cita> getCita() {
        return cita;
    }

    public void setCita(List<Cita> cita) {
        this.cita = cita;
    }

}