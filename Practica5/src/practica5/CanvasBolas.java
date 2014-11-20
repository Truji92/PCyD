/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.awt.*;

/**
 *
 * @author alejandro
 */
public class CanvasBolas extends Canvas {

    public static int ANCHO = 600;
    public static int ALTO = 300;
    
    public static int ANCHO_ZONA_CENTRAL = 200;
    public static int ANCHO_LATERAL = 200;
    
    private Bola[] bolas;
    

    public CanvasBolas(Bola [] _bolas) {
        setSize(new Dimension(ANCHO, ALTO));        
        this.setBackground(Color.white);
        bolas = _bolas;
    }

    @Override
    public void paint(Graphics g) {
        
        // Se crea un buffer intermedio para que montar la salida completa
        // y luego pintarla de una vez, evitando el parpadeo
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();

        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);

        og.setFont(f1);
        og.setColor(Color.gray);
        
        
        og.fillRect(ANCHO_LATERAL+25, 0, ANCHO_ZONA_CENTRAL-25, ALTO);
        
        for (Bola bola : bolas) {
            bola.draw(og);
        }
        
     
        g.drawImage(offscreen, 0, 0, null);
    }

    /* El update original del canvas, borra el canvas y llama a paint. Si queremos 
     sobreescribir  lo que hay pintado, sobrecargamos update y hacemos que llame 
     paint. Así no borra lo anterior, y no se produce parpadeo
     */
    @Override
    public void update(Graphics g) {
        
        paint(g);
    }
    

}
