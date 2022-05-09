/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssmmaa.curso2122.ontojuegosprac5.Agentes;

import com.uja.ssmmaa.curso2122.ontojuegosprac5.Gui.TableroConecta4;
import com.uja.ssmmaa.curso2122.ontojuegosprac5.Utils.Constantes;
import jade.core.Agent;

/**
 *
 * @author Adrián Arboledas <aaf00022@red.ujaen.es>
 */
public class AgenteVisualizadorConecta4 extends Agent implements Constantes {

    private TableroConecta4 gridConecta4;
    private String[] jugadores;

    @Override
    protected void setup() {
        //Inicialización de las variables del agente
        jugadores = new String[JUGADORES.length];
        for (int i = 0; i < JUGADORES.length; i++) {
            jugadores[i] ="jugador "+i;
        }

        gridConecta4 = new TableroConecta4("PartidaPrueba", jugadores);
        gridConecta4.setVisible(true);

        //Configuración del GUI
        //Registro del agente en las Páginas Amarrillas
        //Registro de la Ontología
        System.out.println("Se inicia la ejecución del agente: " + this.getName());
    }

    @Override
    protected void takeDown() {
        //Eliminar registro del agente en las Páginas Amarillas

        //Liberación de recursos, incluido el GUI
        gridConecta4.dispose();

        //Despedida
        System.out.println("Finaliza la ejecución del agente: " + this.getName());
    }

}
