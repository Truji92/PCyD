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
public class SemaforoGeneral {

    private volatile int sem;
    
    public SemaforoGeneral(int ini) throws InicializacionInvalida {
        if (ini < 0)
            throw new InicializacionInvalida("Parametro de inicialización de semáforo no valido");
        else {
            sem = ini;
        }
    }
    
    public synchronized void esperar() {
        while (sem == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SemaforoBinario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sem--;
    }

    public synchronized void avisar() {
        sem++;
        notify();
    }
}
