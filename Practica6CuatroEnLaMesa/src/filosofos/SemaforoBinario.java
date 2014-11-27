/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class SemaforoBinario {
    
    private volatile int sem;
    
    public SemaforoBinario(int ini) throws InicializacionInvalida{
        if (ini != 0 && ini != 1)
            throw new InicializacionInvalida("Parametro de inicialización de semáforo no valido");
        else 
            sem = ini;
    }
    
    public synchronized void esperar() {
        while (sem == 0)
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SemaforoBinario.class.getName()).log(Level.SEVERE, null, ex);
            }
        sem = 0;
    }
    
    public synchronized void avisar() {
        sem = 1;
        notify();
    }
    
}
