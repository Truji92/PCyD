/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Hilos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      /*  //HiloA h1 = new HiloA("Hilo 1", 7);
        HiloB r1 = new HiloB("Hilo1", 10000);
        Thread h1 = new Thread(r1);
        Thread h2 = new Thread(r1);
        
        h1.start();
        h2.start();
        
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos1.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        Compartido c = new Compartido();
        Aumentador h1 = new Aumentador(c);
        Aumentador h2 = new Aumentador(c);
        Aumentador h3 = new Aumentador(c);
        
        h1.start();
        h2.start();
        h3.start();
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e){

        }
        c.visualiza();
        
        System.out.println("Acaba la main");
    }
    
}

class Aumentador extends Thread {
    private Compartido com;
    
    public Aumentador(Compartido c) {
        com = c;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            com.incrementa();
        }
        
    }
}

class HiloA extends Thread {
    private String nombre;
    private int vueltas;
    int contador = 0;
    
    public HiloA (String nombre, int vueltas) {
        this.nombre = nombre;
        this.vueltas = vueltas;
        this.setPriority(vueltas);
    }
    
    @Override
    public void run() {
        
        for (int i = 0; i < vueltas; i++) {
            //System.out.println("Soy el hilo " + this.getName() + " Prioridad: " + this.getPriority()+ " Estado " + this.getState());
            contador++;
        }
        System.out.println("Contador vale:" + contador);
    }
}


class HiloB implements Runnable {
    private String nombre;
    private int vueltas;
    private int contador = 0;
    
    public HiloB (String nombre, int vueltas) {
        this.nombre = nombre;
        this.vueltas = vueltas;
        //Thread.currentThread().setPriority(vueltas);
    }
    
    @Override
    public void run() {
        
        for (int i = 0; i < vueltas; i++) {
            //System.out.println("Soy el hilo " + Thread.currentThread().getName() + " Prioridad: " + Thread.currentThread().getPriority()+ " Estado " + Thread.currentThread().getState());
            contador++;
        }
        System.out.println("Contador vale: "+contador);
        
        
    }
}