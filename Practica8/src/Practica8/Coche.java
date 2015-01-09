/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

import java.util.concurrent.locks.Lock;

/**
 *
 * @author alejandro
 */
public class Coche extends Vehiculo {
    
    private int lado;
    
    public Coche(int id, Lock lock, CanvasPuente canvas) {
        super(id, lock, canvas);
    }

    @Override
    public void run() {
        
    }
    
    
   
    
}
