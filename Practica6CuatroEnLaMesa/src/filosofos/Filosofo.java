    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Filosofo extends Thread{
    
    private Canvas_Filosofos canvas;
    
    private int id;
    
    private SemaforoBinario[] palillos;
    
    private SemaforoGeneral asiento;
    
    public Filosofo(Canvas_Filosofos _canvas, int _id, SemaforoBinario[] _palillos, SemaforoGeneral _asiento) {
        canvas = _canvas;
        id = _id;
        palillos = _palillos;
        asiento = _asiento;
    }

    @Override
    public void run() {
        Random rnd = new Random(this.getId());

        try {
            while (true) {
                canvas.ponestado(id, Canvas_Filosofos.PENSANDO);

                sleep(rnd.nextInt(5)*1000 + 1000);

                canvas.ponestado(id, Canvas_Filosofos.HAMBRIENTO);
                asiento.esperar();

                palillos[id].esperar();
                canvas.ponestado(id, Canvas_Filosofos.CONDERECHO);

                palillos[(id + 1) % 5].esperar();
                canvas.ponestado(id, Canvas_Filosofos.COMIENDO);

                sleep(rnd.nextInt(5)*1000 + 1000);

                palillos[id].avisar();
                palillos[(id + 1) % 5].avisar();
                asiento.avisar();

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
