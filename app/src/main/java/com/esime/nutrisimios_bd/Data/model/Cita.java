package com.esime.nutrisimios_bd.Data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cita {

    @SerializedName("Costo")
    @Expose
    private String costo;
    @SerializedName("Nombre_pac")
    @Expose
    private String nombrePac;
    @SerializedName("Ape_pat_pac")
    @Expose
    private String apePatPac;
    @SerializedName("Ape_mat_pac")
    @Expose
    private String apeMatPac;
    @SerializedName("Nombre_nut")
    @Expose
    private String nombreNut;
    @SerializedName("Ape_pat_nut")
    @Expose
    private String apePatNut;
    @SerializedName("Nombre_cli")
    @Expose
    private String nombreCli;

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getApePatPac() {
        return apePatPac;
    }

    public void setApePatPac(String apePatPac) {
        this.apePatPac = apePatPac;
    }

    public String getApeMatPac() {
        return apeMatPac;
    }

    public void setApeMatPac(String apeMatPac) {
        this.apeMatPac = apeMatPac;
    }

    public String getNombreNut() {
        return nombreNut;
    }

    public void setNombreNut(String nombreNut) {
        this.nombreNut = nombreNut;
    }

    public String getApePatNut() {
        return apePatNut;
    }

    public void setApePatNut(String apePatNut) {
        this.apePatNut = apePatNut;
    }

}