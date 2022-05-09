/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssmmaa.curso2122.ontojuegosprac5.Agentes;

import com.uja.ssmmaa.curso2122.ontojuegosprac5.Gui.TableroQuatro;
import jade.core.Agent;

/**
 *
 * @author joseantonio
 */
public class AgenteVisualizadorQuatro extends Agent{
    
    private TableroQuatro gui;
    
    @Override
    protected void setup(){
        String[] s = new String[2];
        gui = new TableroQuatro(s, "Partida prueba");
        gui.setVisible(true);
        
        System.out.println("Se inicia la ejecucion del agente visualizador de Quatro");
    }
    
    @Override
    protected void takeDown(){
        System.out.println("Finaliza la ejecucion del agente visualizador de Quatro");
    }
    
}
