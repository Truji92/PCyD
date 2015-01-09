package Practica8;

import java.awt.Canvas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alejandro
 */
public class CanvasPuente extends Canvas {
    
    //Tipos
    public static int BARCO = 0;
    public static int COCHE = 1;
    //Estados
    public static int EN_CANAL = 0;
    public static int EN_CARRETERA_IZQ = 1;
    public static int EN_CARRETERA_DER = 2;
    public static int CRUZANDO = 3;
    
    
    public void avisa (int tipo, int id, int estado) {
        
    }
    
}
