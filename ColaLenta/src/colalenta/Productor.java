/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalenta;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Productor extends Thread{
    private ColaLenta cola;
    
    public Productor(ColaLenta cola) {
        this.cola = cola;
    }
    
    @Override
    public void run() {
        Random rnd = new Random(System.currentTimeMillis());
        
        for (int i = 0; i < 10; i++) {
            try {
                cola.Acola(rnd.nextInt(10));
            } catch (Exception ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
