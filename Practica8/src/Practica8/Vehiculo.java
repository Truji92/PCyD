/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author alejandro
 */
public abstract class Vehiculo extends Thread{
    
    protected int id;
    protected Lock lock;
    protected CanvasPuente canvas;
    protected Puente puente;
    
    protected Condition no_hay_coche_cruzando;
    protected Condition no_hay_barco_cruzando;
    
    public Vehiculo(int _id, Lock _lock, CanvasPuente _canvas, Puente _puente) {
        id = _id;
        lock = _lock;
        canvas =_canvas;
        puente = _puente;
        no_hay_barco_cruzando = lock.newCondition();
        no_hay_coche_cruzando = lock.newCondition();
    }
    
    
    
}
