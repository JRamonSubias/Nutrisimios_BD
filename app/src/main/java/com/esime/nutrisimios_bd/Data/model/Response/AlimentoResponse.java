package com.esime.nutrisimios_bd.Data.model.Response;

import com.esime.nutrisimios_bd.Data.model.Alimento;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AlimentoResponse {
        @SerializedName("Alimento")
        @Expose
        private List<Alimento> alimento = new ArrayList<Alimento>();

        public List<Alimento> getAlimento() {
        return alimento;
    }

        public void setAlimento(List<Alimento> alimento) {
        this.alimento = alimento;
    }

}

