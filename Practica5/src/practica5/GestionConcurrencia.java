/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class GestionConcurrencia {
    int numlectores = 0;
    boolean hayescritor = false;
    
    /**
     *
     */
    public  synchronized void entrada_escritor() {
        try {
            while (hayescritor || numlectores > 0) {
                wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(GestionConcurrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        hayescritor = true;
    }
    
    public synchronized void salida_escritor() {
        hayescritor = false;
        notifyAll();
    }
    
    public synchronized void entrada_lector() {
        while (hayescritor == true) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(GestionConcurrencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numlectores++;
    }
    
    public synchronized void salida_lector() {
        numlectores--;
        if (numlectores == 0) 
            notifyAll();
    }
    
    
}
