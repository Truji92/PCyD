/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos;

import java.applet.Applet;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class AppletFilosofos extends Applet {

    private Filosofo[] filosofos = new Filosofo[5];

    @Override
    public void init() {
        Semaphore[] palillos;
        palillos = new Semaphore[5];

        Canvas_Filosofos canvas = new Canvas_Filosofos(520, 220);
        this.setSize(canvas.getWidth(), canvas.getHeight());
        this.add(canvas);

        for (int i = 0; i < 5; i++) {
            palillos[i] = new Semaphore(1);

            filosofos[i] = new Filosofo(canvas, i, palillos);
        }
    }

    @Override
    public void start() {

        for (Filosofo filosofo : filosofos) {
            filosofo.start();
        }
    }

    @Override
    public void stop() {
        for (Filosofo filosofo : filosofos) {
            filosofo.interrupt();
        }

    }

}
