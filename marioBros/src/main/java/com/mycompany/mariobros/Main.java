package com.mycompany.mariobros;

import java.util.Scanner;

public class Main {

    static Personaje mario;
    static Personaje luigi;
    static Personaje yoshi;
    static Personaje bowser;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje personajeElegido = null;
        char tecla;
        int turnos = 0;
       
        mario = new Personaje("Mario", 6, 1.5, 1, 1);
        luigi = new Personaje("Luigi", 8, 1, 2, 1);
        yoshi = new Personaje("Yoshi", 4, 2, 3, 1);
        bowser = new Personaje("Bowser", 15, 0.5, 1, 2);

        

        do {
            System.out.println("Elige un personaje para atacar a Bowser:");
            System.out.println("1. Mario");
            System.out.println("2. Luigi");
            System.out.println("3. Yoshi");
            System.out.println("Ingresa el número del personaje que deseas controlar:");

            int eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    personajeElegido = mario;
                    System.out.println("Has elegido a Mario.");

                    break;
                case 2:
                    personajeElegido = luigi;
                    System.out.println("Has elegido a Luigi.");
                    break;
                case 3:
                    personajeElegido = yoshi;
                    System.out.println("Has elegido a Yoshi.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige un número del 1 al 3.");
            }
        } while (personajeElegido == null);

        do {
            System.out.println("\nPresiona la tecla 'a' para atacar a Bowser o 'z' para salir:");
            tecla = sc.next().charAt(0);

            if (tecla == 'a') {
                personajeElegido.atacar(bowser);
                turnos++;

                if (turnos % 5 == 0) {
                    System.out.println("\n¡Es el turno de Bowser! Bowser ataca a " + personajeElegido.getNombre() + "!");
                    bowser.atacar(personajeElegido);
                }

                if (bowser.getVida() == 0) {
                    System.out.println("\n¡Bowser ha sido derrotado!");
                    break;
                }

                if (personajeElegido.getVida() == 0) {
                    System.out.println("\n" + personajeElegido.getNombre() + " ha sido derrotado. ¡Has perdido!");
                    break;
                }
            } else if (tecla != 'z') {

                System.out.println("Tecla no válida. Por favor, presiona 'a' para atacar o 'z' para salir.");
            }

        } while (tecla != 'z');

        System.out.println("¡Gracias por jugar!");

    }
}
