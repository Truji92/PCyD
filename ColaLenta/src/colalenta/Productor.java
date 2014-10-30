/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalenta;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entidad que introduce elementos en una cola
 *
 * @author alejandro
 */
public class Productor extends Thread {

    private ColaLenta cola;

    /**
     * Constructor del productor
     *
     * @param cola Cola sobre la que realizara las operaciones
     */
    public Productor(ColaLenta cola) {
        this.cola = cola;
    }

    /**
     * Método a ejecutar al lanzar como hilo
     */
    @Override
    public void run() {
        Random rnd = new Random(this.getId());

        for (int i = 0; i < 10; i++) {
            try {
                int elemento = rnd.nextInt(10);
                cola.Acola(elemento);
                System.out.println("Productor "+this.getId()+". Ha introducido "+elemento);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
