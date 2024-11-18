package es.ieslavereda;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private GestorReservas gr;
    private int numPuerto;

    public Servidor() {
        this.gr = new GestorReservas();
        numPuerto = 50000;
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.start();
    }

    private void start() {
        try {

            ServerSocket socketServidor = new ServerSocket(numPuerto);

            while (true) {

                Socket socketComunicacion = socketServidor.accept();
                new Thread(new MyThread(socketComunicacion, gr)).start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
