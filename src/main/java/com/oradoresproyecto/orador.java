package com.oradoresproyecto;

public class orador {
    
    private String nombre;
    private String apellido;
    private String tematica;
    private String fecha;

    public orador(String newNombre, String newApellido, String newTematica, String newFecha){
        this.nombre = newNombre;
        this.apellido = newApellido;
        this.tematica = newTematica;
        this.fecha = newFecha;
        }
    
    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getTematica() {
        return this.tematica;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String tematica) {
        this.tematica = tematica;
    }

    public void setantiguedad(String fecha) {
        this.fecha = fecha;
    }
    
    public String toString(){
        return this.nombre + " " + this.apellido + " " + this.tematica + " " + this.fecha + " ";
    }
    
}
