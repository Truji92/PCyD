/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colacircular;

/**
 *
 * @author usuario
 */
public class Cola implements ICola {

    private int head;
    private int tail;
    private final int capacidad;
    private int numelementos;
    private Object[] datos;

    public Cola(int capacidad) {
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
     
            if (!colallena()) {
                datos[tail] = elemento;
                tail = (tail + 1) % capacidad;
                numelementos++;
            } else {
                throw new Exception("Fallo al encolar. La cola está llena");
            }
       
    }

    @Override
    public Object Desacola() throws Exception {
        Object aux;
        aux = null;
       
            if (!colavacia()) {
                aux = datos[head];
                head = (head + 1) % capacidad;
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
