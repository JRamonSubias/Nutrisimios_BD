package com.esime.nutrisimios_bd.Data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medida {

    @SerializedName("Peso")
    @Expose
    private String peso;
    @SerializedName("Talla")
    @Expose
    private String talla;
    @SerializedName("Cadera")
    @Expose
    private String cadera;
    @SerializedName("Cintura")
    @Expose
    private String cintura;
    @SerializedName("IMC")
    @Expose
    private String iMC;
    @SerializedName("ICC")
    @Expose
    private String iCC;

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCadera() {
        return cadera;
    }

    public void setCadera(String cadera) {
        this.cadera = cadera;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getIMC() {
        return iMC;
    }

    public void setIMC(String iMC) {
        this.iMC = iMC;
    }

    public String getICC() {
        return iCC;
    }

    public void setICC(String iCC) {
        this.iCC = iCC;
    }

}