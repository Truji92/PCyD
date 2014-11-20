/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entidad que extrae elementos de una cola
 *
 * @author alejandro
 */
public class Consumidor extends Thread {

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
        Random rnd = new Random(this.getId());
        for (int i = 0; i < 20; i++) {
            try {
                sleep(rnd.nextInt(3) * 1000 + 1000);
                cola.Desacola();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
    }
}
