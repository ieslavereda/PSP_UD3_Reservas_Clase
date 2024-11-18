package es.ieslavereda;

import java.util.ArrayList;
import java.util.List;

public class GestorReservas {

    private final int MAX_RESERVAS = 10;
    private final String LIBRE= "Libre!!!";

    List<String> butacas;

    public GestorReservas() {
        this.butacas = new ArrayList<>();
        for(int i=0;i<MAX_RESERVAS;i++){
            butacas.add(LIBRE);
        }
    }

    public String getReservas(){
        String aux="";
        int i=1;
        for(String reserva : butacas){
            aux+=(i++)+":"+reserva;
        }
        return aux;
    }

    public int reservar(String nombre){

        if(butacas.contains(nombre)) return -1;

        int posicion = obtenerHueco();

        if(posicion==-1) return -2;

        butacas.set(posicion,nombre);

        return posicion+1;
    }

    private int obtenerHueco() {
        return butacas.indexOf(LIBRE);
    }

    public void anularReserva(String nombre){
        int posicion = butacas.indexOf(nombre);
        if(posicion!=-1)
            butacas.set(posicion,LIBRE);
    }


}
