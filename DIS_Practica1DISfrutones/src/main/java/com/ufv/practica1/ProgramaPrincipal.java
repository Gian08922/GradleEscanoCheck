package com.ufv.practica1;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/*
    Author: Alba Garcia
*/

public class ProgramaPrincipal {

    public static void main(String[] args) throws IOException, ParseException {
        //Creación de Objetos de lectura de CSV y JSON (Incluyen el método de los ejercicios)
        ListaDatos miLista = new ListaDatos("./src/main/resources/datos/AEMET_ColmenarViejo_desde2000.csv");
        ListaJSON EjJSON = new ListaJSON();
        //Variables para el return de los métodos 3 y 4
        int var3;
        int var4;

        //Captor de entrada de teclado para el menú
        Scanner varmenu = new Scanner(System.in);
        //Variable para el switch case del menú
        int selectmenu = 0;
        while(selectmenu != 5) {
            //Opciones del menú
            System.out.println("-- Menú --\n");
            System.out.println("[1] - Velocidad Viento Máxima y Temperatura media en un periodo");
            System.out.println("[2] - Hora Temperatura Mínima = Varias y Temperatura Media");
            System.out.println("[3] - Guardar  en  Fichero  Temperatura  Mínima  entre  18  y  25 grados");
            System.out.println("[4] - Geolocalización  de  la  estación");
            System.out.println("[5] - Salir de la aplicación");
            //Captura de la selección del usuario
            selectmenu = Integer.parseInt(varmenu.nextLine());

            switch (selectmenu) {
                case 1:
                    System.out.println("Procesando opción 1...\n");
                    miLista.opcion_menu1();
                    break;

                case 2:
                    System.out.println("Procesando opción 2...\n");
                    miLista.opcion_menu2();
                    break;

                case 3:
                    //En este método, si se recibe un 0, no se ha añadido ninguna linea al fichero que hay que crear
                    //Si se recibe más de un 0, son las lineas que se han añadido al fichero
                    System.out.println("Procesando opción 3...\n");
                    var3 = miLista.opcionmenu3();
                    if(var3 > 0){
                        System.out.println("Se ha completado la funcion sin errores. Filas añadidas: "+ var3);
                    }
                    else{
                        System.out.println("La función no se ha completado completamente. No se han añadido filas");
                    }
                    break;

                case 4:
                    //Si se recibe un 1, se ha encontrado la estación
                    //Si se recibe un 0, no se ha encontrado
                    System.out.println("Procesando opción 4... \n");
                    var4 = EjJSON.Opcion4();
                    if(var4 == 1){
                        System.out.println("Se ha encontrado la estación");
                    }
                    else{
                        System.out.println("No se ha encontrado la estación");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...\n");
                    break;

                default:
                    System.out.println("Opción no válida\n");
                    break;
            }
        }
    }


}
