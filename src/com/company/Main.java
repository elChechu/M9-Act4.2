package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int disponibles = 9;
        long startTime = System.currentTimeMillis();
        System.out.println("Numero de libros disponibles:" + disponibles);

        Cine cine1 = new Cine(disponibles);

//        Solicitud repeticiones1 = new Solicitud(2,cine1);
//        Solicitud repeticiones1 = new Solicitud(2,cine1);
//        Thread hilo1 = new Thread(repeticiones1);
//        hilo1.start();
//
//        Solicitud repeticiones2 = new Solicitud(5,cine1);
//        Thread hilo2 = new Thread(repeticiones2);
//        hilo2.start();
//
//        Solicitud repeticiones3 = new Solicitud(1,cine1);
//        Thread hilo3 = new Thread(repeticiones3);
//        hilo3.start();
//
//        Solicitud repeticiones4 = new Solicitud(2,cine1);
//        Thread hilo4 = new Thread(repeticiones4);
//        hilo4.start();

//        try {
//            hilo1.join();
//            hilo2.join();
//            hilo3.join();
//            hilo4.join();
//
//        } catch(InterruptedException e) {
//            e.printStackTrace();
//        }


        System.out.println("num vale:" + cine1.getValue());
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecución(ms):" + endTime);

    }

}
