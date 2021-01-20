package com.esime.nutrisimios_bd.Data.model.Response;

import com.esime.nutrisimios_bd.Data.model.Medida;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MedidaResponse {

    @SerializedName("Medida")
    @Expose
    private List<Medida> medida = new ArrayList<Medida>();

    public List<Medida> getMedida() {
        return medida;
    }

    public void setMedida(List<Medida> medida) {
        this.medida = medida;
    }

}