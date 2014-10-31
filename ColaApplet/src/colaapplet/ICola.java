/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaapplet;

/**
 * Interface para implementación de colas
 *
 * @author usuario
 *
 */
public interface ICola {

    /**
     * Devuelve el numero de elementos actualmente almacenados
     *
     * @return Numero de elementos
     */
    public int GetNum();

    /**
     * Introduce un nuevo elemento en la cola
     *
     * @param elemento Elemento a insertar
     * @throws Exception En caso de cola llena
     */
    public void Acola(Object elemento) throws Exception;

    /**
     * Devuelve y elimina el primer elemento
     *
     * @return Elemento extraido
     * @throws Exception En caso de cola vacía
     */
    public Object Desacola() throws Exception;

    /**
     * Devuelve el primer elemento sin extraerlo
     *
     * @return Primer elemento de la cola
     * @throws Exception
     */
    public Object primero() throws Exception;
}
