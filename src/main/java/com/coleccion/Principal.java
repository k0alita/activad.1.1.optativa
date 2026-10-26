package com.coleccion;


import java.util.Scanner;

public class Principal {
    static void main() {
        Scanner sc = new Scanner(System.in);
        boolean usandoBaseDatos = true;

        menu();
        String respuesta = sc.nextLine();

        while (Integer.parseInt(respuesta) < 1 || Integer.parseInt(respuesta) > 3){
            System.out.println("La respuesta debe de ser 1, 2 o 3");
            respuesta = sc.nextLine();
        }

    }

    public static void menu(){
        System.out.println("Elije que quieres hacer:");
        System.out.println("1. Añadir un nuevo juego");
        System.out.println("2. Eliminar un juego por su ID");
        System.out.println("3. Salir");
    }
}
