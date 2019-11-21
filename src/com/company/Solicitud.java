package com.company;

public class Solicitud {

    private Cine cine1;
    private int numEntradas;

    public Solicitud( int numEntradas,Cine cine1) {
        this.cine1 = cine1;
        this.numEntradas = numEntradas;
    }

    public void run() {

        cine1.reserva(numEntradas);
    }


}
