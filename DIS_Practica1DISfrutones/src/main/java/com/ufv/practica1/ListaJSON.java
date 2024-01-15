package com.ufv.practica1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
    Author: Fernando Juanas
*/

public class ListaJSON {
    //Lector del archivo JSON, lo guarda en una variable tipo ArrayList
    public ArrayList<DatosJSON> readJsonFile(String fichero){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fichero));
            ArrayList<DatosJSON> estaciones = new Gson().fromJson(reader, new TypeToken<ArrayList<DatosJSON>>() {}.getType());
            return estaciones;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>(); //si no ha leido nada, devuelve un array vacio
        }
    }

    public int Opcion4() //opcion 4 del menú
    {
        //Creamos objeto de tipo ListaJSON para poder trabajar con él desde aquí
        //Se podría usar this para esto mismo, pero por cuestiones de entender más fácilmente el código,
        //lo hemos hecho mediante un objeto de clase ListaJSON
        ListaJSON lector = new ListaJSON();
        //Llamada a la función readJsonFile para meter los datos del .json en el ArrayList
        ArrayList<DatosJSON> datosJSON = this.readJsonFile("./src/main/resources/datos/Datos_Estaciones.json");
        //Variable para almacenar la estación de la que el usuario quiera comprobar los datos
        String estacion;
        System.out.println("Introduzca la estacion de la que desea ver los datos: ");
        Scanner sc = new Scanner(System.in);
        estacion = sc.nextLine();
        //Se pasa a mayúsculas para que concuerde con los datos del .json
        estacion = estacion.toUpperCase();
        //Pasamos por todos los elementos del ArrayList
        for (int j = 1; j < datosJSON.size(); j++) {
            //Si encontramos un elemento que tenga el nombre de la estación indicada por el usuario
            if (estacion.equals(datosJSON.get(j).getNombre())) {
                //Escribimos los datos relativos a la estación y devolvemos un 1 (Se ha encontrado)
                System.out.println("Nombre: " + datosJSON.get(j).getNombre() +
                        "\nLatitud: " + datosJSON.get(j).getLatitud() +
                        "\nLongitud: " + datosJSON.get(j).getLongitud() + "\n");
                return 1;
            }
        }
        //Devolvemos un 0 si no se ha encontrado
        return 0;
    }
}