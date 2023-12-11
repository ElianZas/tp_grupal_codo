package com.oradoresproyecto;

import org.json.simple.JSONObject;

public class oradorBuilder {
    
    public static orador builderOrador(JSONObject object){
        JSONObject oradorObject = (JSONObject) object.get("11");
        String nombre = (String) oradorObject.get("nombre");
        String apellido = (String) oradorObject.get("apellido");
        String tematica=(String) oradorObject.get("tematica");
        String fecha = (String) oradorObject.get("fecha");
        orador resultOrador = new orador(nombre, apellido, tematica, fecha);
        return resultOrador;   
    }        
}