package com.ufv.practica1;

import com.opencsv.CSVReader;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import  java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
    Author: Giancarlo Rios
*/


public class ListaDatos extends ArrayList<Datos> {
    //Función de lectura del CSV
    public ListaDatos(String nombreArchivo){

        try {
            //Usamos CSVReader para leer el .csv de los datos meteorológicos
            //Los introducimos todos en un ArrayList de tipo Datos
            CSVReader csvReader = new CSVReader( new FileReader(nombreArchivo));
            String[] fila;
            fila = csvReader.readNext(); //Leo la fila de los titulos
            while((fila = csvReader.readNext()) != null){
                Datos miDatos = new Datos(fila);
                this.add(miDatos);
            }
            csvReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Ejercicio 1

    public void opcion_menu1() throws ParseException {
        //Declaramos la función que guardará la velocidad máxima
        final float[] velmax = {0.0f};
        //Contador para el for
        int i;
        //Contador de los datos que recojamos entre las 2 fechas
        int j = 0;
        //Variable para el sumador de temperaturas
        float sumador = 0.0f;
        //Obtención de las fechas
        System.out.println("Introduce una fecha de inicio con el siguiente formato dd/MM/yy");
        Scanner sc = new Scanner(System.in);
        String entradaini = sc.nextLine();
        System.out.println("Introduce una fecha de fin con el siguiente formato dd/MM/yy");
        Scanner sc2 = new Scanner(System.in);
        String entradafini = sc2.nextLine();
        //Formateo de fechas
        DateFormat format = new SimpleDateFormat("dd/MM/yy");
        Date ini = format.parse(entradaini);
        Date fini = format.parse(entradafini);

        System.out.println(ini);
        //For para obtener todos los datos entre ambas fechas
        for(i = 1; i < this.size(); i++){
            if (this.get(i).getFecha().compareTo(ini) >= 0  && this.get(i).getFecha().compareTo(fini) <= 0) {
                //Con este if obtenemos la velocidad más alta entre los datos que comparemos
                if(Float.compare(this.get(i).getVelmedia(), velmax[0]) > 0)
                {
                    velmax[0] = this.get(i).getVelmedia();
                }
                //Sumador de temperaturas
                sumador = sumador + this.get(i).getTmed();
                j++;
                System.out.println();
            }
        }

        System.out.println("Velocidad de viento maximo " + velmax[0]);
        sumador = sumador / j;
        System.out.println("Temperatura media: " + sumador);
    }
    //Ejercicio 2
    public  void opcion_menu2() {
        //Contador i para el numero total de registros
        AtomicInteger i= new AtomicInteger();
        //Foreach para recorrer todos los datos
        this.forEach((p -> {
            //Solo los que sean "Varias"
            if(p.getHoratmin().equals("Varias")){
                System.out.println("Temperatura Hora minima "+p.getHoratmin());
                System.out.println("Temperatura Media "+p.getTmed());
                System.out.println();
                i.getAndIncrement();
            }
        }));
        System.out.println("Numero total de registros "+i);
    }

    //Ejercicio 3

    public int opcionmenu3() throws IOException {
        //Ruta para el fichero csv
        String CSVFichero = "./src/main/resources/datos/temperaturas.csv";
        //Escritor para el fichero csv
        BufferedWriter bw = new BufferedWriter(new FileWriter(CSVFichero));
        //Contador para el número de lines del fichero
        AtomicInteger i = new AtomicInteger();
        //Numero de lineas al que igualamos a i para hacer el return
        int numLineas;
        //forEach para recorrer todos los datos
        this.forEach((p -> {
            //Solo si entra en las temperaturas indicadas
            if (p.getTmin() >= 18 && p.getTmin() <= 25) {
                //Incrementamos i
                i.addAndGet(1);
                //Lo metemos al csv
                try {
                    bw.write("Temperatura minima " + p.getTmin() + "\n");
                    bw.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }));
        System.out.println("Fichero creado con exito");
        numLineas = i.get();
        return numLineas;
    }

}
