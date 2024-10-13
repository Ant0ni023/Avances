package com.brain2;

public class Imagen {

    private String nombre;  // Nombre personalizado que el usuario asigna a la imagen
    private String ruta;    // Ruta donde la imagen está almacenada
    private long fechaCreacion; // Fecha de creación de la imagen en formato de milisegundos

    // Constructor
    public Imagen(String nombre, String ruta, long fechaCreacion) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public long getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(long fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // Método para obtener la información de la imagen en formato legible
    @Override
    public String toString() {
        return "Imagen: " + nombre + " (ruta: " + ruta + ")";
    }
}
