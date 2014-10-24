/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalenta;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Consumidor implements Runnable{
    private ColaLenta cola;
    
    public Consumidor(ColaLenta cola) {
        this.cola = cola;
    }
    
    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {
            try {
                cola.Desacola();
            } catch (Exception ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
