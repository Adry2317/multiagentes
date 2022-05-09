/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssmmaa.curso2122.ontojuegosprac5.Agentes;

import com.uja.ssmmaa.curso2122.ontojuegosprac5.Utils.Constantes;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFSubscriber;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import es.uja.ssmmaa.ontologia.Vocabulario;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author joseantonio
 */
public class AgenteMonitor extends Agent implements Constantes{
    
    private ArrayList<AID>[] agentes;
    
    @Override
    protected void setup(){
       
       //Se inicializan los atributos iniciales
       agentes = new ArrayList[Vocabulario.TIPOS_SERVICIO.length];
       
       for(int i = 0; i < Vocabulario.TIPOS_SERVICIO.length; i++){
           agentes[i] = new ArrayList<>();
       }
        
        
       //Plantilla para buscar agentes  
       DFAgentDescription template = new DFAgentDescription();
       ServiceDescription templateSd = new ServiceDescription();
       templateSd.setType(Vocabulario.TipoServicio.JUGADOR.toString());
       ServiceDescription templateSd2 = new ServiceDescription();
       templateSd2.setType(Vocabulario.TipoServicio.ORGANIZADOR.toString());
       template.addServices(templateSd);
       template.addServices(templateSd2);
        
       System.out.println("Se inicia la ejecucion del agente monitor " + this.getLocalName());
       
       
       //Se llaman a las tareas
       addBehaviour(new TareaSubscripcionDF(this, template));
       
        
    }
    
    @Override
    protected void takeDown(){
        
        System.out.println("Finaliza la ejecucion del agente monitor " + this.getLocalName());
        
    }
    
    
    /******************
     * Tareas
     *****************/
    
    private class TareaSubscripcionDF extends DFSubscriber{

        
        public TareaSubscripcionDF(Agent a, DFAgentDescription template) {
            super(a,template);
            
        }
        
        

        @Override
        public void onRegister(DFAgentDescription dfad) {
            Iterator it = dfad.getAllServices();
            while(it.hasNext()){
                ServiceDescription af =(ServiceDescription) it.next();
                for(int i = 0; i < Vocabulario.TIPOS_SERVICIO.length; i++){
                    if(af.getName().equals(Vocabulario.TIPOS_SERVICIO[i].name())){
                        agentes[Vocabulario.TIPOS_SERVICIO[i].ordinal()].add(dfad.getName());
                    }
                }
                
            }
            
            System.out.println("El agente: " + myAgent.getName() +
                    "ha encontrado a:\n\t" + dfad.getName().getName());
        }

        @Override
        public void onDeregister(DFAgentDescription dfad) {
            AID agente = dfad.getName();
            
            for(int i = 0; i < Vocabulario.TIPOS_SERVICIO.length; i++){
                if(agentes[i].remove(agente)){
                    System.out.println("El agente: " + agente.getName() + 
                            " ha sido eliminado de la lista de " 
                            + myAgent.getName());

                }
            }
        }
        
    }
    
}
