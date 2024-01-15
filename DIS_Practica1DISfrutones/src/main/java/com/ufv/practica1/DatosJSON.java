package com.ufv.practica1;

/*
    Author: Fernando Juanas
*/

public class DatosJSON {

    //Declaración de las variables

    private String latitud, provincia;
    private int altitud;
    private String indicativo, nombre;
    private int indsinop;
    private String longitud;

    //Formateo a String de las variables

    @Override
    public String toString() {
        return "DatosJSON{" +
                "latitud='" + latitud + '\'' +
                ", provincia='" + provincia + '\'' +
                ", altitud=" + altitud +
                ", indicativo='" + indicativo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", indsinop=" + indsinop +
                ", longitud='" + longitud + '\'' +
                '}';
    }

    //Constructor

    public DatosJSON(String latitud, String provincia, int altitud, String indicativo, String nombre, int indsinop, String longitud) {
        this.latitud = latitud;
        this.provincia = provincia;
        this.altitud = altitud;
        this.indicativo = indicativo;
        this.nombre = nombre;
        this.indsinop = indsinop;
        this.longitud = longitud;
    }

    //Getter and Setter

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public String getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(String indicativo) {
        this.indicativo = indicativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIndsinop() {
        return indsinop;
    }

    public void setIndsinop(int indsinop) {
        this.indsinop = indsinop;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}