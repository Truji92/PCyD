/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.applet.Applet;
import java.util.logging.Level;
import java.util.logging.Logger;

class Actualizador extends Thread {
    CanvasBolas cab;
    
    public Actualizador(CanvasBolas c) {
        cab = c;
    }
    
    @Override
    public void run() {
        while(true) {
            cab.repaint();
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Actualizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
            
}
/**
 *
 * @author alejandro
 */
public class AppletBolas extends Applet {
    
    public CanvasBolas vista;
    
    public static int NUM_LECTORES = 10;
    public static int NUM_ESCRITORES = 4;
    
    private Bola [] bolas;
    private Escritor [] escritores;
    private Lector [] lectores;
    
    
    public Actualizador act;
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        this.setSize(CanvasBolas.ANCHO, CanvasBolas.ALTO);
        
        GestionConcurrencia concurrencia;
        concurrencia = new GestionConcurrencia();
        
        
        bolas = new Bola[NUM_ESCRITORES + NUM_LECTORES];
        escritores = new Escritor[NUM_ESCRITORES];
        lectores = new Lector[NUM_LECTORES];
        
        int i;
        for (i = 0; i < NUM_ESCRITORES; i++) {
            bolas [i] = new Bola(Bola.ROJO);
            escritores[i] = new Escritor(bolas[i], concurrencia);
        }
        for (int j = 0; j < NUM_LECTORES; j++) {
            bolas [i+j] = new Bola(Bola.AZUL);
            lectores [j] = new Lector(bolas[i+j], concurrencia);
        }
        
        vista = new CanvasBolas(bolas);
        add(vista);
        act = new Actualizador(vista);
        
    }

    // TODO overwrite start(), stop() and destroy() methods
    
    @Override
    public void start() {
        for (int i = 0; i < NUM_LECTORES; i++) {
            lectores[i].start();
        }
        for (int i = 0; i < NUM_ESCRITORES; i++) {
            escritores[i].start();
        }
        act.start();
    }

    @Override
    public void stop() {
        
    }
}

