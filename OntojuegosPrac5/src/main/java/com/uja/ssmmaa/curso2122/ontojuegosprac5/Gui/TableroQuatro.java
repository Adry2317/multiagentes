/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssmmaa.curso2122.ontojuegosprac5.Gui;

import com.uja.ssmmaa.curso2122.ontojuegosprac5.Utils.Constantes;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


/**
 *
 * @author joseantonio
 */
public class TableroQuatro extends javax.swing.JFrame implements Constantes{

    private final String idPartida;
    private final String[] listaJugadores;
    private final ImageIcon[] img;
    private final JLabel[] jugador;
    private final JLabel[] ficha;
    private final JLabel[] casilla;
    private final JPanel cabecera;
    private final JPanel tablero;

    
    
    /**
     * Creates new form TableroQuatro
     */
    public TableroQuatro(String[] jugadores, String idPartida) {
        initComponents();
        
        Icon icono;
        
        this.idPartida = "Partida iD: " + idPartida;
        this.setTitle(this.idPartida);
        this.listaJugadores = jugadores;
        
        // Cambiamos el Layout de la ventana principal
        this.getContentPane().setLayout(new BorderLayout());
        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(BorderFactory.createEmptyBorder(3, 5, 5, 5));
        this.add(principal);
        
        // Crear las imágenes del juego para la representación en el tablero
        img = new ImageIcon[ESTADOConecta4.length];
        for( int i = 0; i < ESTADOConecta4.length; i++ ){           
            img[i] = new ImageIcon(getClass().getClassLoader().getResource(PATH + ESTADOConecta4[i].getFichero()));
            
        }
        // Inicializamos los componentes del tablero
        jugador = new JLabel[JUGADORES.length];
        ficha = new JLabel[JUGADORES.length];
        casilla = new JLabel[CASILLAS];
        cabecera = new JPanel();
        tablero = new JPanel();
        
        
        // Añadimos el tablero
        tablero.setLayout(new GridLayout(4,4,4,4));
        tablero.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        icono = new ImageIcon(img[EstadoCasilla.LIBRE.ordinal()].getImage().getScaledInstance(100, 100, 
                                                                    Image.SCALE_DEFAULT));
        for(int i = 0; i < CASILLAS; i++ ) {
            casilla[i] = new JLabel();  
            casilla[i].setIcon(icono);
            casilla[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            casilla[i].setHorizontalAlignment(JLabel.CENTER);
            tablero.add(casilla[i]);
        }
        principal.add(tablero, BorderLayout.CENTER);
        
        this.pack();
        this.repaint();        

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}