package com.oradoresproyecto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class oradorController {

    oradorService oradorService = new oradorService();

    public void getOrador(){ 
        ArrayList<orador> oradorBase = oradorService.getOrador();
        JSONObject oradores = new JSONObject();

        int x = 0;
        while(x < oradorBase.size()){ 
            JSONObject orador = new JSONObject();         
            orador.put("nombre", oradorBase.get(x).getNombre());
            orador.put("apellido", oradorBase.get(x).getApellido());
            orador.put("tematica",oradorBase.get(x).getTematica());
            orador.put("fecha", oradorBase.get(x).getFecha());
            
            oradores.put(x,orador);
            x++;
        }

        JSONArray oradoresList = new JSONArray();

        oradoresList.add(oradores);

        try(FileWriter file = new FileWriter("oradores.json")){
            file.write(oradoresList.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void postOrador() {
        JSONParser jsonParser = new JSONParser();
        oradorBuilder builderOrador = new oradorBuilder();

        try (FileReader reader = new FileReader("formorador.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray jsonOrador = (JSONArray) obj;
            orador orador = builderOrador.builderOrador((JSONObject) jsonOrador.get(0));
            System.out.println(orador);
            oradorService.validateAndSaveOrador(orador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
