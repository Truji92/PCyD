/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalenta;

/**
 *
 * @author alejandro
 */
public class UsaCola {

    public static void main(String[] Args) {
        ColaLenta cola = new ColaLenta(20);

        Productor productor1 = new Productor(cola);
        Productor productor2 = new Productor(cola);

        Thread consumidor1 = new Thread(new Consumidor(cola));
        Thread consumidor2 = new Thread(new Consumidor(cola));

        productor1.start();
        productor2.start();
        
        try {
            productor1.join();
            productor2.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        consumidor1.start();
        consumidor2.start();

        try {
            consumidor1.join();
            consumidor2.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
