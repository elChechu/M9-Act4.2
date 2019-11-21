package com.company;

public class Cine {


    private int entradas;

    public Cine(int entradas) {
        this.entradas = entradas;
    }

    public synchronized void reserva(int numEntradas) {

        System.out.println("[" + Thread.currentThread().getName() + "] solicita "
                + numEntradas + " entradas,de " + entradas + " disponibles");

        if(entradas > numEntradas){

            entradas = entradas - numEntradas;
            System.out.println("[" + Thread.currentThread().getName() + "] Ha comprado "
                    + numEntradas + " entradas,quedan disponibles " + entradas);


            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("No hay suficientes entradas disponibles");
        }


    }


    public int getValue() {
        return entradas;
    }

}
