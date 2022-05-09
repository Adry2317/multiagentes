/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssmmaa.curso2122.ontojuegosprac5.Agentes;

import com.uja.ssmmaa.curso2122.ontojuegosprac5.Utils.Constantes;
import es.uja.ssmmaa.ontologia.Vocabulario;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrián Arboledas <aaf00022@red.ujaen.es>
 */
public class AgenteJugador extends Agent implements Constantes{

    private int partidasActivas;
    @Override
    protected void setup() {
        System.out.println("Se inicia la ejecución del agente: " + this.getName());
        
        this.partidasActivas = 0;
        
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        
        ServiceDescription sdConecta4 = new ServiceDescription();
        sdConecta4.setType(Vocabulario.TipoServicio.JUGADOR.name());
        sdConecta4.setName(Vocabulario.TipoJuego.CONECTA_4.name());
        ServiceDescription sdQuatro = new ServiceDescription();
        
        sdQuatro.setType(Vocabulario.TipoServicio.JUGADOR.name());
        sdQuatro.setName(Vocabulario.TipoJuego.QUATRO.name());
        dfd.addServices(sdConecta4);
        
        dfd.addServices(sdQuatro);

        try {
            DFService.register(this, dfd);
        } catch (FIPAException ex) {
            Logger.getLogger(AgenteJugador.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("El agente " + this.getLocalName() + " se ha registrado en las páginas amarillas");

    }

    @Override
    protected void takeDown() {
          try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        //Liberación de recursos, incluido el GUI
        //Despedida
        System.out.println("Finaliza la ejecución del agente: " + this.getName());

    }
    
    
    
}
