package com.example.alejandroguma.barbosa;

/**
 * Created by Alejo on 25/03/2017.
 */

public class Lista_Entrada {
    private int idImagen;
    private String nombre,descripcion;

    public Lista_Entrada(int idImagen, String nombre, String descripcion) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
