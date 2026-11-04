package com.coleccion;


import com.coleccion.model.Videojuego;
import com.coleccion.model.VideojuegoDAO;

import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean usandoBaseDatos = true;

        while (usandoBaseDatos){

            menu();
            String respuesta = sc.nextLine();

            while (Integer.parseInt(respuesta) < 1 || Integer.parseInt(respuesta) > 3){
                System.out.println("La respuesta debe de ser 1, 2 o 3");
                respuesta = sc.nextLine();
            }


            switch (respuesta){
                case "1":
                    System.out.println("Ingrese el titulo del videojuego:");
                    System.out.println("Titulo");
                    String titulo = sc.nextLine();

                    System.out.println("Genero");
                    String genero = sc.nextLine();

                    System.out.println("Plataforma");
                    String plataforma = sc.nextLine();

                    System.out.println("Año");
                    int anio = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Valoracion (1-10)");
                    int  valoracion = sc.nextInt();
                    sc.nextLine();

                    Videojuego nuevo = new Videojuego(titulo,genero,plataforma,anio,valoracion);

                    if (VideojuegoDAO.insertar(nuevo)){
                        System.out.println("Videojuego insertado correctamente.");
                    }
                    break;
                case "2":
                    System.out.println("Introduce el ID del videojuego que quieres eliminar:");
                    int id = sc.nextInt();
                    VideojuegoDAO.eliminarPorId(id);
                    sc.nextLine();
                    break;
                case "3":
                    System.out.println("Saliendo del sistema...");
                    usandoBaseDatos = false;
                    break;
            }

        }
        System.out.println("Sistema cerrado");
    }

    public static void menu(){
        System.out.println("Elije que quieres hacer:");
        System.out.println("1. Añadir un nuevo juego");
        System.out.println("2. Eliminar un juego por su ID");
        System.out.println("3. Salir");
    }
}
