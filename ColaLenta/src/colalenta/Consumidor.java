/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalenta;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entidad que extrae elementos de una cola
 *
 * @author alejandro
 */
public class Consumidor implements Runnable {

    private ColaLenta cola;

    /**
     * Constructor del consumidor
     *
     * @param cola Cola sobre la que realizará las operaciones
     */
    public Consumidor(ColaLenta cola) {
        this.cola = cola;
    }

    /**
     * Método a ejecutar al lanzar como hilo
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Consumidor " + Thread.currentThread().getId() + ". Extrae " + cola.Desacola());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
