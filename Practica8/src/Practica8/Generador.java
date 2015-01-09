/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Generador extends Thread{
    
    private Lock lock;
    private CanvasPuente canvas;
    private Puente puente;

    public Generador(Lock _lock, CanvasPuente _canvas, Puente _puente) {
        lock = _lock;
        canvas = _canvas;
        puente = _puente;
    }
    
    
    @Override
    public void run() {
        Random rng = new Random(this.getId());
        
        int numeroCochesDer = 0;
        int numeroCochesIzq = 0;
        int numeroBarcos = 0;
        Thread hilo;
        
        while(true) {
            int i = rng.nextInt(10);
            
            if (i <= 1) {
                hilo = new Barco(numeroBarcos++, lock, canvas);
                hilo.start();
            }else if (i <= 5) {
                hilo = new Coche(2 * numeroCochesDer++, lock, canvas);
                hilo.start();
            }else {
                hilo = new Coche(2 * numeroCochesIzq++ + 1, lock, canvas);
                hilo.start();
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
