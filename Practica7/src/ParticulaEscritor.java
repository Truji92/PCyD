import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class ParticulaEscritor extends Thread {

    private int id;
    private estadop estado = new estadop();
    protected final Random rng = new Random();
    private int sentidox, sentidoy;
    private LECanvas canvas;
    private int velocidad;
    private ReadWriteLock lock;

    public ParticulaEscritor(LECanvas canvas, int i, ReadWriteLock _lock) {
        estado.posx = rng.nextInt(300);
        estado.posy = rng.nextInt(400);
        sentidox = rng.nextInt(2);
        sentidoy = rng.nextInt(2);
        this.canvas = canvas;
        id = i;
        estado.quiere = false;
        rng.setSeed(System.currentTimeMillis() + id);
        velocidad = rng.nextInt(30) + 10;
        //velocidad = 20;
        lock = _lock;
    }

    @Override
    public void run() {

        while (true) {
            moveleft();
            try {
                lock.writeLock().lock();
                movemiddle(1);
            } finally {
                lock.writeLock().unlock();
            }
            moveright();
            try {
                lock.writeLock().lock();
                movemiddle(0);
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public void moveleft() {

        boolean llega = false;
        while (!llega) {
            if (sentidox == 1) {
                estado.posx++;
            } else {
                estado.posx--;
            }
            if (sentidoy == 1) {
                estado.posy++;
            } else {
                estado.posy--;
            }
            if (estado.posy < 0) {
                estado.posy = 0;
                sentidoy = 1;
            }
            if (estado.posx < 0) {
                estado.posx = 0;
                sentidox = 1;
            }
            if (estado.posx > 300 - 20 && sentidox == 1) {
                estado.posx = 300 - 20;
                llega = true;
            }
            if (estado.posy > 400 - 20) {
                estado.posy = 400 - 20;
                sentidoy = 0;
            }

            canvas.setEscritor(id, estado);

            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(ParticulaLector.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

        }
    }

    public void movemiddle(int hacia) {

        boolean pasa = false;
        while (!pasa) {
            if (sentidox == 1) {
                estado.posx++;
            } else {
                estado.posx--;
            }
            if (sentidoy == 1) {
                estado.posy++;
            } else {
                estado.posy--;
            }
            if (estado.posy < 0) {
                estado.posy = 0;
                sentidoy = 1;
            }
            if (hacia == 0) {
                if (estado.posx < 300) {
                    estado.posx = 300;
                    pasa = true;
                }
            } else if (estado.posx > 500 - 20) {
                estado.posx = 500 - 20;
                pasa = true;
            }

            if (estado.posy > 400 - 20) {
                estado.posy = 400 - 20;
                sentidoy = 0;
            }

            canvas.setEscritor(id, estado);
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(ParticulaLector.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

        }
    }

    public void moveright() {

        boolean pasa = false;
        while (!pasa) {
            if (sentidox == 1) {
                estado.posx++;
            } else {
                estado.posx--;
            }
            if (sentidoy == 1) {
                estado.posy++;
            } else {
                estado.posy--;
            }
            if (estado.posy < 0) {
                estado.posy = 0;
                sentidoy = 1;
            }
            if (estado.posx < 500 && sentidox == 0) {
                estado.posx = 500;
                pasa = true;
            }
            if (estado.posx > 800 - 20) {
                estado.posx = 800 - 20;
                sentidox = 0;
            }
            if (estado.posy > 400 - 20) {
                estado.posy = 400 - 20;
                sentidoy = 0;
            }

            canvas.setEscritor(id, estado);
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(ParticulaLector.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

        }
    }
}
