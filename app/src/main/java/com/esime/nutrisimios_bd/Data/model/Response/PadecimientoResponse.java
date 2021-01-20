package com.esime.nutrisimios_bd.Data.model.Response;

import com.esime.nutrisimios_bd.Data.model.Padecimiento;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PadecimientoResponse  {

    @SerializedName("Padecimiento")
    @Expose
    private List<Padecimiento> padecimiento = new ArrayList<Padecimiento>();

    public List<Padecimiento> getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(List<Padecimiento> padecimiento) {
        this.padecimiento = padecimiento;
    }

}