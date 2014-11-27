    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Filosofo extends Thread{
    
    private Canvas_Filosofos canvas;
    
    private int id;
    
    private Semaphore[] palillos;
    
    
    public Filosofo(Canvas_Filosofos _canvas, int _id, Semaphore[] _palillos) {
        canvas = _canvas;
        id = _id;
        palillos = _palillos;
    }

    @Override
    public void run() {
        Random rnd = new Random(this.getId());

        try {
            while (true) {
                canvas.ponestado(id, Canvas_Filosofos.PENSANDO);

                sleep(rnd.nextInt(5)*1000 + 1000);

                canvas.ponestado(id, Canvas_Filosofos.HAMBRIENTO);

                if (id % 2 == 0) {
                    palillos[id].acquire();
                    canvas.ponestado(id, Canvas_Filosofos.CONDERECHO);

                    palillos[(id + 1) % 5].acquire();
                    canvas.ponestado(id, Canvas_Filosofos.COMIENDO);
                }else {
                    palillos[(id + 1) % 5].acquire();
                    canvas.ponestado(id, Canvas_Filosofos.CONIZQUIERDO);

                    palillos[id].acquire();
                    canvas.ponestado(id, Canvas_Filosofos.COMIENDO);
                }
                sleep(rnd.nextInt(5) * 1000 + 1000);

                palillos[id].release();
                palillos[(id + 1) % 5].release();

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
