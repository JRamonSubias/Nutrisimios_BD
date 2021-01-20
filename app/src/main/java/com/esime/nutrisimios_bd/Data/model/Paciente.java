package com.esime.nutrisimios_bd.Data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paciente  {


    @SerializedName("ID_Pacientes")
    @Expose
    private String ID_Pacientes;
    @SerializedName("Nombre_pac")
    @Expose
    private String nombrePac;
    @SerializedName("Ape_pat_pac")
    @Expose
    private String apePatPac;
    @SerializedName("Ape_mat_pac")
    @Expose
    private String apeMatPac;
    @SerializedName("Sexo")
    @Expose
    private String sexo;
    @SerializedName("Edad")
    @Expose
    private String edad;
    @SerializedName("Correo")
    @Expose
    private String correo;
    @SerializedName("Telefono")
    @Expose
    private String telefono;
    @SerializedName("Padecimientos")
    @Expose
    private String padecimientos;
    @SerializedName("Tipo")
    @Expose
    private String tipo;
    @SerializedName("Grado")
    @Expose
    private String grado;
    @SerializedName("ID_Med_Pac")
    @Expose
    private String iDMedPac;
    @SerializedName("ID_Ava_Pac")
    @Expose
    private String iDAvaPac;


    public String getID_Pacientes() {
        return ID_Pacientes;
    }

    public void setID_Pacientes(String ID_Pacientes) {
        this.ID_Pacientes = ID_Pacientes;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getIDMedPac() {
        return iDMedPac;
    }

    public void setIDMedPac(String iDMedPac) {
        this.iDMedPac = iDMedPac;
    }

    public String getIDAvaPac() {
        return iDAvaPac;
    }

    public void setIDAvaPac(String iDAvaPac) {
        this.iDAvaPac = iDAvaPac;
    }

}