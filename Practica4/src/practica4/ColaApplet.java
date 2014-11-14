/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.applet.Applet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class ColaApplet extends Applet {
    
    private Productor prod1, prod2, prod3, prod4;
    private Consumidor cons;

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        this.setSize(500, 300);
        CanvasCola vista;
        int capacidad = 6;
        vista = new CanvasCola(capacidad);
        add(vista);
        
        ColaLenta cola; 
        cola = new ColaLenta(capacidad, vista);
        
        prod1 = new Productor(cola);
        prod2 = new Productor(cola);
        prod3 = new Productor(cola);
        prod4 = new Productor(cola);
        cons = new Consumidor(cola);

    }

    // TODO overwrite start(), stop() and destroy() methods
    
    @Override
    public void start() {
                
        prod1.start();
        prod2.start();
        prod3.start();
        prod4.start();
        cons.start();
        
    }

    @Override
    public void stop() {
        
    }
}
