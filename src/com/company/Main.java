package com.company;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        // ENUNCIADO

/*
        Actividad 4.2
        Estamos gestionando la venta de entradas para la peli Joker
        en el cine Spielberg de Cerdanyola para la próxima sesión.
        Sólo quedan 9 entradas disponibles, pero ahora mismo tenemos
        clientes interesados y estamos gestionando todas las peticiones de forma concurrente:
        cliente1 pide 2 entradas
        cliente2 pide 5 entradas
        cliente3 pide 1 entrada
        cliente4 pide 2 entradas
*/

        Cine cine = new Cine(9);

        EjecucionSolicitudes ej = new EjecucionSolicitudes(cine, 2);
        Thread t1 = new Thread(ej);
        t1.start();

        EjecucionSolicitudes ej2 = new EjecucionSolicitudes(cine, 2);
        Thread t2 = new Thread(ej2);
        t2.start();

        EjecucionSolicitudes ej3 = new EjecucionSolicitudes(cine, 2);
        Thread t3 = new Thread(ej3);
        t3.start();

        EjecucionSolicitudes ej4 = new EjecucionSolicitudes(cine, 2);
        Thread t4 = new Thread(ej4);
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (InterruptedException i){
            System.out.println(i);
        }


    }
}

class Cine{

    private int entradas;

    public Cine(int entradas) {
        this.entradas = entradas;
    }

    public synchronized void solicitar(int entradasolicitada) throws InterruptedException{
        this.Mensaje(entradasolicitada);
        if (entradasolicitada<entradas){
            entradas-=entradasolicitada;
            this.getEntradas(entradas, entradasolicitada);
            sleep(200);
        }
    }

    public void getEntradas(int entradas, int entradasolicitada){
        System.out.println("[" + Thread.currentThread().getName() + "] Ha comprado " + entradasolicitada + " entradas,quedan disponibles " + entradas);
    }

    public void Mensaje(int entradassolicitadas){
        System.out.println("[" + Thread.currentThread().getName() + "] solicita " +  entradassolicitadas + " entradas,de " + entradas + " disponibles");
    }
}

class EjecucionSolicitudes  implements  Runnable {

    private int entradasolicitada;
    private Cine cine;

    public EjecucionSolicitudes(Cine cine, int entradasolicitada){
        this.cine = cine;
        this.entradasolicitada = entradasolicitada;
    }

    @Override
    public void run() {
        try {
            cine.solicitar(entradasolicitada);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
