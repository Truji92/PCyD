/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalenta;

/**
 *
 * @author usuario
 */
public class ColaLenta implements ICola {

    private int head;
    private int tail;
    private final int capacidad;
    private int numelementos;
    private Object[] datos;

    public ColaLenta(int capacidad) {
        this.capacidad = capacidad;
        datos = new Object[capacidad];
        head = tail = 0;
        numelementos = 0;
    }

    @Override
    public int GetNum() {
        return numelementos;
    }

    @Override
    public void Acola(Object elemento) throws Exception {
        Thread.sleep(100);
            if (!colallena()) {
                Thread.sleep(100);
                datos[tail] = elemento;
                Thread.sleep(100);
                tail = (tail + 1) % capacidad;
                Thread.sleep(100);
                numelementos++;
            } else {
                throw new Exception("Fallo al encolar. La cola está llena");
            }
       
    }

    @Override
    public Object Desacola() throws Exception {
        Object aux;
        aux = null;
        Thread.sleep(100);
            if (!colavacia()) {
                Thread.sleep(100);
                aux = datos[head];
                Thread.sleep(100);
                head = (head + 1) % capacidad;
                Thread.sleep(100);
                numelementos--;
            } else {
                throw new Exception("Fallo al desencolar. La cola está vacía");
            }
        
            
        
        return aux;
    }

    @Override
    public Object primero() throws Exception{
        Object aux;
        aux = null;
        
            if (!colavacia()) {
                aux = datos[head];
            } else {
                throw new Exception("Fallo al consultar elemento. La cola está vacía");
            }
       
        return aux;
    }

    private boolean colavacia() {
        return numelementos == 0;
    }

    private boolean colallena() {
        return numelementos == capacidad;
    }
}
