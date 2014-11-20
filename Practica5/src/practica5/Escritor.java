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
public class Escritor extends Thread {
        
    private Bola bola;
    private GestionConcurrencia concu;
    
    public Escritor(Bola _bola, GestionConcurrencia _concu) {
        bola = _bola;
        concu = _concu;
    }

    public void run() {
        try {
            while (true) {
                sleep(50);

                if (bola.EnZonaCompartida()) {
                    concu.entrada_escritor();
                    while (bola.EnZonaCompartida()) {
                        sleep(50);
                        bola.update();
                    }
                    concu.salida_escritor();
                } else {
                    bola.update();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   
    