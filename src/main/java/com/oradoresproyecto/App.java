package com.oradoresproyecto;

public class App {
    public static void main( String[] args ){

        oradorController oradorController = new oradorController();
        
        oradorController.getOrador();//trae los oradores de la Base de Datos en JSON empleadosBase.json

    }
}
