package com.esime.nutrisimios_bd.Data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutriologo {

    @SerializedName("ID_Nutriologo")
    @Expose
    private String iDNutriologo;
    @SerializedName("Nombre_nut")
    @Expose
    private String nombreNut;
    @SerializedName("Ape_pat_nut")
    @Expose
    private String apePatNut;
    @SerializedName("Ape_mat_nut")
    @Expose
    private String apeMatNut;
    @SerializedName("Direccion")
    @Expose
    private String direccion;
    @SerializedName("Telefono")
    @Expose
    private String telefono;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("Nombre_cli")
    @Expose
    private String nombreCli;

    public String getiDNutriologo() {
        return iDNutriologo;
    }

    public void setiDNutriologo(String iDNutriologo) {
        this.iDNutriologo = iDNutriologo;
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

    public String getApeMatNut() {
        return apeMatNut;
    }

    public void setApeMatNut(String apeMatNut) {
        this.apeMatNut = apeMatNut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }
}