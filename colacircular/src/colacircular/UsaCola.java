/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colacircular;

import java.util.Random;

/**
 *
 * @author usuario
 */
public class UsaCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola cola = new Cola(4);
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++){
            try {
                if (rnd.nextInt(100) % 2 != 0) {
                    System.out.println("####ENCOLAMOS####");
                    cola.Acola(i);
                } else {
                    System.out.println("####DESENCOLAMOS####");
                    cola.Desacola();
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            System.out.println("elementos: " + cola.GetNum());
        }
        
    }
        /*    Random rnd = new Random(System.currentTimeMillis());
        int tamaño = rnd.nextInt(20);
        System.out.println("tamaño: " + tamaño);
        Cola cola = new Cola(tamaño);
        
        try {
        cola.Desacola();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        
        try {
        cola.primero();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        
        for (int i = 0; i < tamaño + 1; i++) {
        try {
        cola.Acola(i);
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        }
        for (int i = 0; i < tamaño; i++) {
        try {
        System.out.println(cola.Desacola());
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        }
        
        for (int i = 0; i < tamaño; i++) {
        try {
        cola.Acola(i);
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        try {
        System.out.println(cola.Desacola());
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        }
        }*/
}
