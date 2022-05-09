/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssmmaa.curso2122.ontojuegosprac5.Utils;

import es.uja.ssmmaa.ontologia.Vocabulario;

/**
 *
 * @author Adrián Arboledas <aaf00022@red.ujaen.es>
 */
public interface Constantes {

    public static final String PATH = "/";
    public static final int FILAS_CONECTA4 = 6;
    public static final int COLUMNAS_CONECTA4 = 7;
    public static final int MAX_JUEGOS_SIMULTANEOS = 3;

    public enum EstadoCasillaConecta4 {
        LIBRE("libre.png"), JUGADOR_1("player1.png"), JUGADOR_2("player2.png");

        private final String fichero;

        private EstadoCasillaConecta4(String fichero) {
            this.fichero = fichero;
        }

        /**
         * Obtenemos el fichero asociado a la imágen del estado su
         * representación en el tablero
         *
         * @return fichero de la imágen.
         */
        public String getFichero() {
            return fichero;
        }
    }

    public static final EstadoCasillaConecta4[] ESTADOConecta4 = EstadoCasillaConecta4.values();

    public static final int CASILLAS = 16;

    /**
     * Representa los estados de las casillas del juego de Tres en Raya para su
     * representación gráfica en el tablero de juego
     */
    public enum EstadoCasilla {
        LIBRE("libre.png"), BLARC("11.png"), BLBRC("15.png"), BLAHC("9.png"), BLBHC("13.png"), BLARR("3.png"), BLBRR("7.png"), BLAHR("1.png"), BLBHR("5.png"), NARC("12.png"), NBRC("16.png"), NAHC("10.png"),
        NBHC("14.png"), NARR("4.png"), NBRR("8.png"), NAHR("2.png"), NBHR("6.png");

        private final String fichero;

        private EstadoCasilla(String fichero) {
            this.fichero = fichero;
        }

        /**
         * Obtenemos el fichero asociado a la imágen del estado su
         * representación en el tablero
         *
         * @return fichero de la imágen.
         */
        public String getFichero() {
            return fichero;
        }
    }
    public static final EstadoCasilla[] ESTADO = EstadoCasilla.values();

    public enum Jugador {
        JUGADOR_1, JUGADOR_2;
    }

    public static final Jugador[] JUGADORES = Jugador.values();
}
