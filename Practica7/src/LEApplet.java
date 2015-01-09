/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author pedro
 */
public class LEApplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    private int cantidadL = 8;
    private int cantidadE = 3;
    private Thread[] lectores;
    private Thread[] escritores;

    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        Dimension tamaño = new Dimension(800, 400);
        this.setSize(tamaño);
        this.setBackground(Color.white);
        LECanvas vista = new LECanvas(tamaño, cantidadL, cantidadE);
        add(vista);
        
        ReadWriteLock lock = new ReentrantReadWriteLock(false);

        lectores = new Thread[cantidadL];
        escritores = new Thread[cantidadE];
        for (int i = 0; i < cantidadL; i++) {
            lectores[i] = new ParticulaLector(vista, i, lock);
        }
        for (int i = 0; i < cantidadE; i++) {
            escritores[i] = new ParticulaEscritor(vista, i, lock);
        }
    }
    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void start() {
        for (int i = 0; i < cantidadL; i++) {
            lectores[i].start();
        }
        for (int i = 0; i < cantidadE; i++) {
            escritores[i].start();
        }

    }

    @Override
    public void stop() {
        for (int i = 0; i < cantidadL; i++) {
            lectores[i].interrupt();
        }
        for (int i = 0; i < cantidadE; i++) {
            escritores[i].interrupt();
        }
    }
}
