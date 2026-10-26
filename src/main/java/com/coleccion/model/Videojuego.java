package com.coleccion.model;

public class Videojuego {
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private int anio;
    private int valoracion;

    //Constructor con TODOS los parametros para cuando se lee de la Base de Datos.
    public Videojuego(int id, String titulo, String genero, String plataforma, int anio, int valoracion) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        this.valoracion = valoracion;
    }

    //Constructor sin id para cuando el usuario crea un juego nuevo antes de persistirlo en MySql, ya que el ID es autoincremental.
    public Videojuego(String titulo, String genero, String plataforma, int anio, int valoracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        this.valoracion = valoracion;
    }




}
