/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 * Cola con retardo entre las instrucciones de las operaciones de inserción y
 * extracción
 *
 * @author usuario
 */
public class ColaLenta implements ICola {

    private int head;
    private int tail;
    private final int capacidad;
    private int numelementos;
    private Object[] datos;
    private CanvasCola canvas;

    /**
     * Constructor que crea una cola con la capacidad especificada
     *
     * @param capacidad Capacidad maxima de la cola
     */
    public ColaLenta(int capacidad, CanvasCola canvas) {
        this.capacidad = capacidad;
        datos = new Object[capacidad];
        head = tail = 0;
        numelementos = 0;
        this.canvas = canvas;
    }

    @Override
    public int GetNum() {
        return numelementos;
    }

    @Override
    public synchronized void Acola(Object elemento) throws Exception {
        int intentos = 0;
        Thread.sleep(100);
        while (colallena() && intentos < 3) {
            System.out.println("El hilo (productor) " + Thread.currentThread().getId() + " espera. Intento: "+ intentos);    
            wait();
            intentos++;
        }
        if (intentos == 3) {
            canvas.avisa("Cola llena");
            throw new Exception("Fallo al encolar. La cola está llena");
        } else {
            Thread.sleep(100);
            datos[tail] = elemento;
            Thread.sleep(100);
            tail = (tail + 1) % capacidad;
            Thread.sleep(100);
            numelementos++;
            System.out.println("El hilo " + Thread.currentThread().getId() + " consigue acolar en el intento "+ intentos);
            notifyAll();
        }
        canvas.representa(datos, head, tail, numelementos);
    }

    @Override
    public synchronized Object Desacola() throws Exception {
        int intentos = 0;
        Object aux;
        aux = null;
        Thread.sleep(100);
        while (colavacia() && intentos < 3) {
            System.out.println("El hilo (Consumidor) " + Thread.currentThread().getId() + " espera. Intento: "+ intentos);
            wait();
            intentos++;
        }
        if (intentos == 3) {
            canvas.avisa("Cola vacía");
            throw new Exception("Fallo al desencolar. La cola está vacía");
        } else {
            Thread.sleep(100);
            aux = datos[head];
            Thread.sleep(100);
            head = (head + 1) % capacidad;
            Thread.sleep(100);
            numelementos--;
            System.out.println("El hilo " + Thread.currentThread().getId() + " consigue desacolar en el intento "+ intentos);
            notifyAll();
        }
        canvas.representa(datos, head, tail, numelementos);
        return aux;
    }

    @Override
    public synchronized Object primero() throws Exception {
        Object aux;
        aux = null;

        if (!colavacia()) {
            aux = datos[head];
        } else {
            throw new Exception("Fallo al consultar elemento. La cola está vacía");
        }

        return aux;
    }

    /**
     * Indica si la cola esta vacia o no
     *
     * @return True si la cola esta vacía
     */
    private boolean colavacia() {
        return numelementos == 0;
    }

    /**
     * Indica si la cola esta llena
     *
     * @return True si la cola esta llena
     */
    private boolean colallena() {
        return numelementos == capacidad;
    }
}
