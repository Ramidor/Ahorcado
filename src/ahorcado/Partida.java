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
public class Partida {
    private int MAX_INTENTOS = 6;
    private Jugador jugadorAdivina, jugadorPalabra;
    private String palabraAdivinar;

    public Partida(Jugador jugadorAdivina, Jugador jugadorPalabra) {
        this.jugadorAdivina = jugadorAdivina;
        this.jugadorPalabra = jugadorPalabra;
    }

    public String getPalabraAdivinar() {
        return palabraAdivinar;
    }

    public void setPalabraAdivinar(String palabraAdivinar) {
        this.palabraAdivinar = palabraAdivinar;
    }
    
    public boolean jugar(){
        boolean acierto = false;
        int intentos = 0;
        String letrasErradas = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(jugadorAdivina.getNombre() + ", no mire a la pantalla mientras el otro jugador escribe la palabra");
        System.out.println(jugadorPalabra.getNombre() + ", escribe la palabra para adivinar: ");
        palabraAdivinar = sc.nextLine().toLowerCase();
        limpiarPantalla();
        
        char[] palabra = new char[palabraAdivinar.length()];
        for (int i = 0; i < palabra.length; i++) {
            palabra[i] = '_';
        }
        while (intentos < MAX_INTENTOS && !acierto) {
            System.out.println("\n" + jugadorAdivina.getNombre() + ", adivina la palabra: " + String.valueOf(palabra));
            System.out.println("Letras erradas: " + letrasErradas);
            System.out.println("Intentos restantes: " + (MAX_INTENTOS - intentos));
            System.out.print("Ingresa una letra: ");
            char letra = sc.nextLine().toLowerCase().charAt(0);

            if (palabraAdivinar.contains(String.valueOf(letra))) {
                for (int i = 0; i < palabraAdivinar.length(); i++) {
                    if (palabraAdivinar.charAt(i) == letra) {
                        palabra[i] = letra;
                    }
                }
            } else {
                if (!letrasErradas.contains(String.valueOf(letra))) {
                    letrasErradas += letra + " ";
                    intentos++;
                } else {
                    System.out.println("Ya intentaste con esa letra. Prueba otra.");
                }
            }

            if (String.valueOf(palabra).equals(palabraAdivinar)) {
                acierto = true;
            }
        }

        if (acierto) {
            System.out.println("\n" + jugadorAdivina.getNombre() + " ha ganado. La palabra es: " + palabraAdivinar);
            return true; 
        } else {
            System.out.println("\n" + jugadorAdivina.getNombre() + " ha perdido. La palabra era: " + palabraAdivinar);
            return false; 
        }
    }
    
    private static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
