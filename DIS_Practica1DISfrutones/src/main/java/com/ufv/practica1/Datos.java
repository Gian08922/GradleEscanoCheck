package com.ufv.practica1;


import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
    Author: Giancarlo Rios
*/

//fecha;indicativo;nombre;provincia;altitud;tmed;prec;tmin;horatmin;tmax;horatmax;dir;velmedia;racha;horaracha;sol;presMax;horaPresMax;presMin;horaPresMin
public class Datos {

    //Declaración de variables

    private Date fecha;
    private String indicativo, horatmin, horatmax, horaracha, horaPresMax, horaPresMin;
    private float tmed, prec, tmin, tmax, velmedia, racha, sol, presMax, presMin;
    private int dir;

    //Formateo de la fecha

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");

    //Constructor
    public Datos(String[] fila) throws ParseException {

        this.setFecha(formato.parse(fila[0]));
        this.setIndicativo(fila[1]);
        this.setTmed(Float.parseFloat(fila[5]));
        if(fila[6].equals("Ip"))
        {
            //System.out.println("Entra");
            this.setPrec((float) 0.1);
        }
        else
        {
            this.setPrec(Float.parseFloat(fila[6]));
        }
        this.setTmin(Float.parseFloat(fila[7]));
        this.setHoratmin(fila[8]);
        this.setTmax(Float.parseFloat(fila[9]));
        this.setHoratmax(fila[10]);
        this.setDir(Integer.parseInt(fila[11]));
        this.setVelmedia(Float.parseFloat(fila[12]));
        this.setRacha(Float.parseFloat(fila[13]));
        this.setHoraracha(fila[14]);
        this.setSol(Float.parseFloat(fila[15]));
        this.setPresMax(Float.parseFloat(fila[16]));
        this.setHoraPresMax(fila[17]);
        this.setPresMin(Float.parseFloat(fila[18]));
        this.setHoraPresMin(fila[19]);

    }
    //Getter y Setter
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(String indicativo) {
        this.indicativo = indicativo;
    }

    public String getHoratmin() {
        return horatmin;
    }

    public void setHoratmin(String horatmin) {
        this.horatmin = horatmin;
    }

    public String getHoratmax() {
        return horatmax;
    }

    public void setHoratmax(String horatmax) {
        this.horatmax = horatmax;
    }

    public String getHoraracha() {
        return horaracha;
    }

    public void setHoraracha(String horaracha) {
        this.horaracha = horaracha;
    }

    public String getHoraPresMax() {
        return horaPresMax;
    }

    public void setHoraPresMax(String horaPresMax) {
        this.horaPresMax = horaPresMax;
    }

    public String getHoraPresMin() {
        return horaPresMin;
    }

    public void setHoraPresMin(String horaPresMin) {
        this.horaPresMin = horaPresMin;
    }

    public float getTmed() {
        return tmed;
    }

    public void setTmed(float tmed) {
        this.tmed = tmed;
    }

    public float getPrec() {
        return prec;
    }

    public void setPrec(float prec) {
        this.prec = prec;
    }

    public float getTmin() {
        return tmin;
    }

    public void setTmin(float tmin) {
        this.tmin = tmin;
    }

    public float getTmax() {
        return tmax;
    }

    public void setTmax(float tmax) {
        this.tmax = tmax;
    }

    public float getVelmedia() {
        return velmedia;
    }

    public void setVelmedia(float velmedia) {
        this.velmedia = velmedia;
    }

    public float getRacha() {
        return racha;
    }

    public void setRacha(float racha) {
        this.racha = racha;
    }

    public float getSol() {
        return sol;
    }

    public void setSol(float sol) {
        this.sol = sol;
    }

    public float getPresMax() {
        return presMax;
    }

    public void setPresMax(float presMax) {
        this.presMax = presMax;
    }

    public float getPresMin() {
        return presMin;
    }

    public void setPresMin(float presMin) {
        this.presMin = presMin;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
