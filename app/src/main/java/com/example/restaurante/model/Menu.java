package com.example.restaurante.model;
import com.google.gson.annotations.SerializedName;
public class Menu {
    @SerializedName("PlatilloID")
    private int platilloID;

    @SerializedName("Nombre")
    private String nombre;

    @SerializedName("Costo")
    private double costo;

    @SerializedName("CategoriaNombre")
    private String categoriaNombre;

    @SerializedName("EstadoDescripcion")
    private String estadoDescripcion;

    public Menu(int platilloID, String nombre, double costo, String categoriaNombre, String estadoDescripcion) {
        this.platilloID = platilloID;
        this.nombre = nombre;
        this.costo = costo;
        this.categoriaNombre = categoriaNombre;
        this.estadoDescripcion = estadoDescripcion;
    }

    public int getPlatilloID() {
        return platilloID;
    }

    public void setPlatilloID(int platilloID) {
        this.platilloID = platilloID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
    }
}
