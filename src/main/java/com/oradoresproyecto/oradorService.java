package com.oradoresproyecto;

import java.util.ArrayList;

public class oradorService {
    static oradorDTO oradorDTO = new oradorDTO();

    public static void validateAndSaveOrador(orador orador){
        if(orador.getNombre() == null ){
            System.out.println("ERROR CAMPO VACIO: INGRESE NOMBRE");
        }
        if(orador.getApellido() == null ){
            System.out.println("ERROR CAMPO VACIO: INGRESE APELLIDO");
        }
        if(orador.getTematica()== null ){
            System.out.println("ERROR DATO INVALIDO: DNI DEBE CONTENER 9 NUMEROS");
        }
        if(orador.getTematica() == null ){
            System.out.println("ERROR DATO INVALIDO: AÑOS DE ANTIGÜEDAD DEBE SER MAYOR O IGUAL A 0");
        } 
        else {
            oradorDTO.saveOrador(orador.getNombre(), orador.getApellido(), orador.getTematica(), orador.getFecha());
            System.out.println("OK");
        }
    }

    public ArrayList<orador> getOrador(){
        ArrayList<orador> orador = oradorDTO.getOradora();
        ArrayList<orador> oradores= new ArrayList<orador>();
        
        for(int x = 0 ; x < orador.size();x++){
            oradores.add(new orador(orador.get(x).getNombre(), orador.get(x).getApellido(), orador.get(x).getTematica(), orador.get(x).getFecha()));
        }
        System.out.println("Se creó JSON con los sueldos de los choferes\n"+oradores);
        return oradores;
    }
}
