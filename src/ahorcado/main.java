/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ahorcado;

import java.util.Scanner;

/**
 *
 * @author raulp
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del Jugador 1: ");
        String nombreJugador1 = sc.nextLine();
        System.out.print("Ingrese el nombre del Jugador 2: ");
        String nombreJugador2 = sc.nextLine();

        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        juego.iniciarJuego();
    }
    
}
