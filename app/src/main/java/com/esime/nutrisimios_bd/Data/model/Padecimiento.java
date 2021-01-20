package com.esime.nutrisimios_bd.Data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Padecimiento{

    @SerializedName("ID_Padecimiento")
    @Expose
    private String iDPadecimiento;
    @SerializedName("Padecimientos")
    @Expose
    private String padecimientos;
    @SerializedName("Tipo")
    @Expose
    private String tipo;
    @SerializedName("Grado")
    @Expose
    private String grado;

    public String getIDPadecimiento() {
        return iDPadecimiento;
    }

    public void setIDPadecimiento(String iDPadecimiento) {
        this.iDPadecimiento = iDPadecimiento;
    }

    public String getPadecimientos() {
        return padecimientos;
    }

    public void setPadecimientos(String padecimientos) {
        this.padecimientos = padecimientos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

}