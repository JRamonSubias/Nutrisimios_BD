package com.esime.nutrisimios_bd.Data.model.Response;

import com.esime.nutrisimios_bd.Data.model.Nutriologo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NutriologoResponse {

    @SerializedName("Nutriologo")
    @Expose
    private List<Nutriologo> nutriologo = new ArrayList<Nutriologo>();

    public List<Nutriologo> getNutriologo() {
        return nutriologo;
    }

    public void setNutriologo(List<Nutriologo> nutriologo) {
        this.nutriologo = nutriologo;
    }

}