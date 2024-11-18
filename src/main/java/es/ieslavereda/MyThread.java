package es.ieslavereda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread implements Runnable {

    private Socket socketComunicacion;
    private GestorReservas gr;

    public MyThread(Socket socketComunicacion, GestorReservas gr) {
        this.socketComunicacion = socketComunicacion;
        this.gr = gr;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socketComunicacion.getInputStream()));
            PrintWriter pw = new PrintWriter(socketComunicacion.getOutputStream(), true);

            String linea;
            String respuesta = "";
            while ((linea = br.readLine()) != null) {

                // 1:
                // 2: Joaquin -> Reservar para Joaquin
                // 3: Manolo -> Anular reserva Manolo

                switch (Integer.parseInt(linea.split(":")[0])) {

                    case 1:
                        respuesta = gr.getReservas();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;


                }

                pw.println(respuesta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
