/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos;

import java.applet.Applet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class AppletFilosofos extends Applet{
    
    private Filosofo[] filosofos = new Filosofo[5];

    private SemaforoGeneral asiento;
    
    @Override
    public void init() {
        SemaforoBinario [] palillos;
        palillos = new SemaforoBinario[5];
        
        try {
            asiento = new SemaforoGeneral(4);
        } catch (InicializacionInvalida ex) {
            Logger.getLogger(AppletFilosofos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Canvas_Filosofos canvas = new Canvas_Filosofos(520, 220);
        this.setSize(canvas.getWidth(), canvas.getHeight());
        this.add(canvas);
        
        for (int i = 0; i < 5; i++) {
            try {
                palillos[i] = new SemaforoBinario(1);
            } catch (InicializacionInvalida ex) {
                Logger.getLogger(AppletFilosofos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            filosofos[i] = new Filosofo(canvas, i, palillos, asiento);
        }
    }

    @Override
    public void start() {
        
        for (Filosofo filosofo : filosofos) {
            filosofo.start();
        }
    }

    @Override
    public void stop() {
        for (Filosofo filosofo : filosofos)
            filosofo.interrupt();
        
    }
    
    
}
