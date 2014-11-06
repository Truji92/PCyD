/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaapplet;

import java.applet.Applet;

/**
 *
 * @author alejandro
 */
public class ColaApplet extends Applet {
    
    private Productor prod;
    private Consumidor cons;

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        this.setSize(400, 200);
        CanvasCola vista;
        vista = new CanvasCola(10);
        add(vista);
    }

    // TODO overwrite start(), stop() and destroy() methods
    
    @Override
    public void start() {
       
    }

    @Override
    public void stop() {
        
    }
}
