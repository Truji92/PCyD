/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author alejandro
 */
public class CanvasArea extends Canvas {

    private double area = 0;
    private boolean areaCalculada = false;
    private int numpartes;
    private int[] rectangulos;

    private Color[] colores = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.GRAY, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY};

    private int[] posicionesX;
    private ArrayList<Integer> pox = new ArrayList();
    private int[] valoresY;
    int posicionCero;
    int inicioEje;
    double min;
    double max;
    int rangoY;
    double rangoYdouble;

    public CanvasArea(int ancho, int alto, int _numpartes) {
        numpartes = _numpartes;
        this.setSize(ancho, alto);

        this.setBackground(Color.WHITE);

        posicionesX = new int[this.getWidth() - 100 - 100];
        valoresY = new int[posicionesX.length];
        double[] valoresYdouble = new double[valoresY.length];
        double aux = 0;
        min = Double.MAX_VALUE;
        max = -Double.MAX_VALUE;

        for (int i = 0; i < posicionesX.length; i++) {
            posicionesX[i] = i + 130;
            pox.add(i + 130);
            valoresYdouble[i] = Funcion.fun(aux);
            aux += 1 / (double) posicionesX.length;

            if (valoresYdouble[i] > max) {
                max = valoresYdouble[i];
            }
            if (valoresYdouble[i] < min) {
                min = valoresYdouble[i];
            }
        }

        rangoYdouble = max - min;
        rangoY = this.getHeight() - 200;
        inicioEje = 100;
        int finEje = this.getHeight() - 100;
        for (int i = 0; i < valoresYdouble.length; i++) {
            valoresY[i] = this.getHeight() - (int) (inicioEje + (valoresYdouble[i] - min) * (rangoY / rangoYdouble));
        }
        posicionCero = this.getHeight() - (int) (inicioEje + (0 - min) * (rangoY / rangoYdouble));

        rectangulos = new int[numpartes];
        for (int i = 0; i < rectangulos.length; i++) {
            rectangulos[i] = -1;
        }
    }

    @Override
    public void paint(Graphics g) {

        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();

        Font f1 = new Font("Helvetica", Font.BOLD, 30);
        og.setFont(f1);
        og.setColor(Color.BLACK);

        //funcion
        og.drawPolyline(posicionesX, valoresY, posicionesX.length);
        //Eje x
        og.drawLine(100, posicionCero, this.getWidth() - 50, posicionCero);
        //Eje y
        og.drawLine(130, 100, 130, this.getHeight() - 100);

        //RECTANGULOS
        double tamañoParte = 1 / (double) numpartes;

        if (areaCalculada) {
            
            og.drawString("area: " + area, 30, 30);
        }

        for (int i = 0; i < numpartes; i++) {
            if (rectangulos[i] != -1) {

                double inicio = i * 1 / (double) numpartes;
                int inicioInt = 130 + i * (posicionesX[posicionesX.length - 1] - 130) / numpartes;
                double fin = inicio + tamañoParte;
                double puntoMedio = inicio + tamañoParte / 2;
                double valor = Funcion.fun(puntoMedio);
                if (valor >= 0) {
                    double valornormalizado = Math.abs((valor - min) / (max-min));
                    int valorInt = (int) (valornormalizado * rangoY + 100) - posicionCero;
                    og.setColor(Color.BLACK);
                    og.drawRect(inicioInt, posicionCero - valorInt, posicionesX.length / numpartes, valorInt);
                    og.setColor(colores[rectangulos[i % colores.length]]);
                    og.fillRect(inicioInt, posicionCero - valorInt, posicionesX.length / numpartes, valorInt);
                } else {
                    double valornormalizado = Math.abs((-valor - min) / (max-min));
                    int valorInt = (int) (valornormalizado * rangoY + 100) - posicionCero;
                    og.setColor(Color.BLACK);
                    og.drawRect(inicioInt, posicionCero, posicionesX.length / numpartes, valorInt);
                    og.setColor(colores[rectangulos[i % colores.length]]);
                    og.fillRect(inicioInt, posicionCero, posicionesX.length / numpartes, valorInt);
                }
            }
        }

        g.drawImage(offscreen, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public void pintaArea(double _area) {
        area = _area;
        areaCalculada = true;
        repaint();
    }

    public void pintaParte(int id, int parte) {
        rectangulos[parte] = id;
        repaint();
    }
}
