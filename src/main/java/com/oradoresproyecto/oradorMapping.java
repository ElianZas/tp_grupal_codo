package com.oradoresproyecto;

public class oradorMapping {

    public orador mapOrador(String nombreBD, String apellidoBD, String tematicaBD, String fechaBD) {
        orador orador = new orador(nombreBD, apellidoBD, tematicaBD, fechaBD);
        return orador;

    }
}
