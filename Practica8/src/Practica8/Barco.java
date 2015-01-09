/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Barco extends Vehiculo {

    public Barco(int id, Lock lock, CanvasPuente canvas) {
        super(id, lock, canvas);
    }

    @Override
    public void run() {
        
    }
    
    
}
