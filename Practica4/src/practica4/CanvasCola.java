/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.awt.*;

/**
 *
 * @author alejandro
 */
public class CanvasCola extends Canvas {

    private int head = 0;
    private int tail = 0;
    private int capacidad;
    private int numelementos;
    private Object[] datos;
    private String mensaje;

    public CanvasCola(int capacidad) {
        setSize(new Dimension(500, 300));        
        this.setBackground(Color.white);
        this.capacidad = capacidad;
        datos = new Object[capacidad];
    }

    @Override
    public void paint(Graphics g) {

        // Se crea un buffer intermedio para que montar la salida completa
        // y luego pintarla de una vez, evitando el parpadeo
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();

        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);

        og.setFont(f1);
        og.setColor(Color.black);
        
        for (int i = 0; i < capacidad; i++) {
            og.drawRect(this.getWidth()/capacidad *i + (this.getWidth()/capacidad)/4, this.getHeight()/2 - 20, 40, 40); 
            if (numelementos > 0) {
                if (tail > head)
                    if (i >= head && i < tail)
                        og.drawString(datos[i].toString(), 10 + this.getWidth()/capacidad *i + (this.getWidth()/capacidad)/4, this.getHeight()/2 + 10);
                if (tail < head)
                    if (i>=head || i<tail)
                        og.drawString(datos[i].toString(), 10 + this.getWidth()/capacidad *i + (this.getWidth()/capacidad)/4, this.getHeight()/2 + 10);
                if (tail == head)
                        og.drawString(datos[i].toString(), 10 + this.getWidth()/capacidad *i + (this.getWidth()/capacidad)/4, this.getHeight()/2 + 10);
            }
        }
        
        og.setColor(Color.red);
        og.drawOval(this.getWidth()/capacidad *tail + (this.getWidth()/capacidad)/4, this.getHeight()/2 -30, 7, 7);
        og.setColor(Color.blue);
        og.drawOval(this.getWidth()/capacidad *head + (this.getWidth()/capacidad)/4, this.getHeight()/2 +23, 7, 7);
        
        og.setColor(Color.black);
        
        if (mensaje != null && mensaje.equalsIgnoreCase("cola llena")) {
            og.setColor(Color.red);
            og.drawString("Cola llena", 10,30);
            og.setColor(Color.black);
        } else og.drawString("Cola llena", 10,30);  
        
        if (mensaje != null && mensaje.equalsIgnoreCase("cola vacía")) { 
           og.setColor(Color.red);
            og.drawString("Cola vacía", 200, 30);
            og.setColor(Color.black);
        } else og.drawString("Cola vacía", 200, 30);
        
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

    public void avisa(String mensaje) {
        this.mensaje = mensaje;
        repaint();
    }

    public void representa(Object[] buf, int head, int tail, int numele) {
        this.datos = buf;
        this.head = head;
        this.tail = tail;
        this.numelementos = numele;
        this.mensaje = null;
        repaint();
    }

}
