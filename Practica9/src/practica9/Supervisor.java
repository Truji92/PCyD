/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author alejandro
 */
public class Supervisor extends Thread {
    
    private CanvasArea canvas;
    private int numhilos;
    private int numpartes;
    
    public Supervisor(CanvasArea _canvas, int partes, int hilos) {
        canvas = _canvas;
        numpartes = partes;
        numhilos = hilos;
    }

    @Override
    public void run() {
        ExecutorService thp = Executors.newFixedThreadPool(numhilos);
        
        
        ArrayList<Future<Double>> resultados = new ArrayList();
        
        for (int i = 0; i < numpartes; i++) {
            Calculador calc = new Calculador(canvas, numpartes, i, i%numhilos);
            Future<Double> f = thp.submit(calc);
            resultados.add(f);
        }
        
        thp.shutdown();
        
        
        Double area = 0d;
        try {
            for (Future<Double> resultado : resultados) {
                area += resultado.get();
            }
        } catch (InterruptedException | ExecutionException e){
            System.out.println("Error: "+e.getMessage());
        }
        canvas.pintaArea(area);
    }
    
    
}
