package server;



/**
 * Class ServerHilo, mantiene comunicacion con el cliente.
 *
 *
 * @author Kevin Rojas
 */

import java.io.*;
import java.net.*;
import Classes.NombrePrueba;

import java.util.concurrent.TimeUnit;

public class ServerHilo extends Thread{
    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private boolean conectado;


    public ServerHilo(Socket socket) { //, int id) {
        this.socket = socket;
        setConectado(true);
        try {
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());
            //start();
        } catch (Exception e) {
            System.out.println("Error en clase ServerHilos, en constructor: " + e);
        }
    }

    public void desconectar() {
        try {
            socket.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar server: " + e);
        }
    }

    @Override
    public void run() {
        NombrePrueba objectbasura = new NombrePrueba(0);
        int primero = 1;
        while (isConectado()) {
            try {
                if (primero == 1) {
                    primero--;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("delay 1 second");
                } else {
                    NombrePrueba objectentrada = (NombrePrueba) entrada.readObject();
                    if (objectentrada.getData() == 1){
                        System.out.println("se ha recibido del cliente " + objectentrada.getData());
                        objectentrada.setData(100);
                        salida.writeObject(objectentrada);
                        System.out.println("Se ha enviado al cliente " + objectentrada.getData());
                    }
                    /**if (objectentrada.getData() == 1) {
                        System.out.println("se ha recibido: " + objectentrada.getData());
                        objectentrada.setData(2);
                        salida.writeObject(objectentrada);
                        System.out.println("se ha enviado: " + objectentrada.getData());
                        //salida.flush();
                    } else {
                        if (objectentrada.getData() == (3)) {
                            System.out.println("se ha recibido: " + objectentrada.getData());
                            objectentrada.setData(4);
                            salida.writeObject(objectentrada);
                            System.out.println("se ha enviado: " + objectentrada.getData());
                            desconectar();
                            System.out.println(" DESCONECTADO ");
                        }
                    }*/
                }
            } catch (Exception e) {
                System.out.println("Error en clase ServerHilo, en el run: " + e);
                break;
                //desconectar();
            }
        }
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
}
