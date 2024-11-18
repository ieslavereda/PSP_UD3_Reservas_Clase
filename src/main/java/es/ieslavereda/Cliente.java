package es.ieslavereda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private int numPuerto;
    private String host;

    public Cliente() {
        numPuerto = 50000;
        host = "127.0.0.1";
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.start();
    }

    public int obtenerOpcion() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca una opcion");
        System.out.println("1-Listar reservas");
        System.out.println("2-Crear reserva");
        System.out.println("3-Anular reserva");
        System.out.println("4-Salir");

        return sc.nextInt();

    }

    private void start() {

        Socket socket = null;
        String respuesta = "";
        try {
            socket = new Socket(host, numPuerto);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                int opcion = obtenerOpcion();

                switch (opcion) {

                    case 1:
                        out.println("1:");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;

                    default:


                }
                respuesta = in.readLine();
                System.out.println(respuesta);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
