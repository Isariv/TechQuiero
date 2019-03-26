/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquiero;

import javax.swing.JFrame;
import static techquiero.Ventana.crearArchivo;

/**
 *
 * @author Isabel
 */
public class TechQuiero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana mc = new Ventana ("Librería");
        mc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mc.setBounds(500, 300, 1000, 500);
        mc.setVisible(true);
        
           
    }
    
}
