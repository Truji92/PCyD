/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaapplet;

import java.awt.*;

/**
 *
 * @author alejandro
 */
public class CanvasCola extends Canvas{
    
    public CanvasCola(int width, int height) {
        setSize(new Dimension(width, height));
        this.setBackground(Color.white);
    }
    
    @Override
    public void paint(Graphics g) {

        // Se crea un buffer intermedio para que montar la salida completa
        // y luego pintarla de una vez, evitando el parpadeo
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();

        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);

        og.setFont(f1);
        og.setColor(Color.red);
        og.fillOval(20, 30, 20, 20);
        og.drawString("Valor de contador 1 --> ", 50, 50);
        og.setColor(Color.blue);
        og.fillOval(20, 80, 20, 20);
        og.drawString("Valor de contador 2 --> ", 50, 100);
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
