package com.esime.nutrisimios_bd.Data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nombre_Paciente {

    @SerializedName("ID_Nom_pac")
    @Expose
    private String iDNomPac;
    @SerializedName("Nombre_pac")
    @Expose
    private String nombrePac;
    @SerializedName("Ape_pat_pac")
    @Expose
    private String apePatPac;
    @SerializedName("Ape_mat_pac")
    @Expose
    private String apeMatPac;

    public String getIDNomPac() {
        return iDNomPac;
    }

    public void setIDNomPac(String iDNomPac) {
        this.iDNomPac = iDNomPac;
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

}
