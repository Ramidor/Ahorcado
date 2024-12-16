/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

import java.util.Scanner;

/**
 *
 * @author raulp
 */
public class Juego {

    private static final int PARTIDAS_PARA_GANAR = 5;
    private Jugador jugador1;
    private Jugador jugador2;

    public Juego(String nombreJugador1, String nombreJugador2) {
        this.jugador1 = new Jugador(nombreJugador1);
        this.jugador2 = new Jugador(nombreJugador2);
    }

    public void iniciarJuego() {
        int ronda = 1;

        System.out.println("\nJuego del Ahorcado al mejor de " + PARTIDAS_PARA_GANAR + " partidas\n");

        while (jugador1.getPuntuacion() < PARTIDAS_PARA_GANAR && jugador2.getPuntuacion() < PARTIDAS_PARA_GANAR) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            Jugador jugadorQueEscribe, jugadorAdivina;
            if (ronda % 2 != 0) {
                jugadorQueEscribe = jugador1;
                jugadorAdivina = jugador2;
            } else {
                jugadorQueEscribe = jugador2;
                jugadorAdivina = jugador1;
            }

            Partida partida = new Partida(jugadorAdivina, jugadorQueEscribe);
            boolean ganaAdivina = partida.jugar();

            if (ganaAdivina) {
                jugadorAdivina.incrementarPuntuacion();
            } else {
                jugadorQueEscribe.incrementarPuntuacion();
            }

            System.out.println("Puntuacion actual: " + jugador1.getNombre() + ": " + jugador1.getPuntuacion() + " | "
                    + jugador2.getNombre() + ": " + jugador2.getPuntuacion());

            ronda++;
        }

        System.out.println("\nJuego terminado");
        if (jugador1.getPuntuacion() > jugador2.getPuntuacion()) {
            System.out.println(jugador1.getNombre() + " gano el juego");
        } else {
            System.out.println(jugador2.getNombre() + " gano el juego");
        }
    }
}
