/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.applet.Applet;

/**
 *
 * @author alejandro
 */
public class AppletArez extends Applet {
    
    
    private CanvasArea canvas;
    private int numhilos = 6;
    private int numpartes = 60;
    private Supervisor spvs;
    
    
    @Override
    public void init() {
        
        canvas = new CanvasArea(800, 600, numpartes);
        this.setSize(canvas.getSize());
        this.add(canvas);
        spvs = new Supervisor(canvas, numpartes, numhilos);
        spvs.start();
        
    }
    
    @Override
    public void start() {
        
    }

    @Override
    public void stop() {
        
    }
    
    
}
