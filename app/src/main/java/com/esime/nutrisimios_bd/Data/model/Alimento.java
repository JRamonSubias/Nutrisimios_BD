package com.esime.nutrisimios_bd.Data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Alimento{

    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Porcion")
    @Expose
    private String porcion;
    @SerializedName("Proteina")
    @Expose
    private String proteina;
    @SerializedName("Grasas")
    @Expose
    private String grasas;
    @SerializedName("Sodio")
    @Expose
    private String sodio;
    @SerializedName("Carbohidratos")
    @Expose
    private String carbohidratos;
    @SerializedName("Calorias")
    @Expose
    private String calorias;
    @SerializedName("Grupo")
    @Expose
    private String grupo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    public String getGrasas() {
        return grasas;
    }

    public void setGrasas(String grasas) {
        this.grasas = grasas;
    }

    public String getSodio() {
        return sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }

    public String getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(String carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}