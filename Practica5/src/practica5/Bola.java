/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import com.sun.xml.internal.ws.client.ContentNegotiation;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author alejandro
 */
public class Bola {
    private int x, y;
    private int dx, dy;
    private int radio = 25;
    private int color;
    
    public static int AZUL = 1;
    public static int ROJO = 2;
    
    
    public Bola(int _color) {
        
        Random rnd = new Random(System.identityHashCode(this));
        while (x > CanvasBolas.ANCHO_LATERAL && x < CanvasBolas.ANCHO_LATERAL+CanvasBolas.ANCHO_ZONA_CENTRAL)
            x = rnd.nextInt(CanvasBolas.ANCHO);
        while (y < 10 || y > CanvasBolas.ALTO -10)
            y = rnd.nextInt(CanvasBolas.ALTO);
        
        while (dx == 0)
            dx = rnd.nextInt(5) +3;
        while (dy == 0)
            dy = rnd.nextInt(5) +3;
        
        color = _color;
    }
  
    void update() {
        x = x + dx;
        y = y + dy;
        noSalirDeLaPantalla();
    }
    
    void draw(Graphics og) {
        if (color == AZUL)
            og.setColor(Color.blue);
        else if (color == ROJO)
            og.setColor(Color.red);
        og.fillOval(x, y, radio, radio);
    }
    
    void noSalirDeLaPantalla(){
        if (x < 0 || x > CanvasBolas.ANCHO - radio)
            dx *= -1;
        if (y < 0  || y > CanvasBolas.ALTO - radio)
            dy *= -1;
    }
    
    public boolean EnZonaCompartida(){
        return x > CanvasBolas.ANCHO_LATERAL && x < CanvasBolas.ANCHO_LATERAL+CanvasBolas.ANCHO_ZONA_CENTRAL;
    }
    
    public void setX(int x) {
        this.x = x;
    }
}
