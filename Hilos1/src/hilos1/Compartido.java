/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos1;

/**
 *
 * @author alejandro
 */
public class Compartido {
    
    private int contador = 0;
    
    public void incrementa(){
        contador++;
    }
    
    public void visualiza() {
        System.out.println("El contador vale: "+ contador);
    }
    
}
