package server;

/**
 * Class Servidor. Recibe y maniupla datos del cliente.
 *
 *
 * @author Kevin Rojas
 */

import java.net.*;

public class Servidor {
    private int PUERTO;
    private boolean encendido;
    public ServerSocket ss;

    public Servidor() {
        setEncendido(true);
    }

    public void startServer(){
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(getPUERTO());
            System.out.println("\t[OK]");
            while (isEncendido()) {
                Socket socket;
                socket = ss.accept();
                ServerHilo SH = new ServerHilo(socket);
                SH.start();
            }
        } catch (Exception e) {
            System.out.println("Error en la clase Servidor, al agregar nuevos clientes " + e);
            apagar();
        }

    }

    public void apagar(){
        try{
            ss.close();
            setEncendido(false);
        }catch(Exception e){
            System.out.println("No ha sido posible apagar el server: " + e);
        }
    }

    public void setPUERTO(int PUERTO){
        this.PUERTO = PUERTO;
    }

    public int getPUERTO(){
        return this.PUERTO;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
}
