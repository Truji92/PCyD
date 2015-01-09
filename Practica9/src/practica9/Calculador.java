/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author alejandro
 */
public class Calculador implements Callable<Double>{

    private CanvasArea canvas;
    private int numpartes;
    private int miparte;
    private int id;
    
    public Calculador(CanvasArea _canvas, int partes, int _miparte, int _id) {
        canvas = _canvas;
        numpartes = partes;
        miparte = _miparte;
        id = _id;
    }
    
    @Override
    public Double call() throws Exception {
        Random R = new Random();
        Thread.sleep(2000 + 1000*R.nextInt(3));
        
        double tamañoParte = 1/(double)numpartes;
        double inicio = miparte * numpartes;
        double fin = inicio + tamañoParte;
        double puntoMedio = inicio + tamañoParte/(double)2;
        
        canvas.pintaParte(id, miparte);
        return Math.abs(tamañoParte * Funcion.fun(puntoMedio));
    }
    
}
