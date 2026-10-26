package com.coleccion.model;

public class Videojuego {
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private int anio;
    private int valoracion;


    public Videojuego(int id, String titulo, String genero, String plataforma, int anio, int valoracion) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        this.valoracion = valoracion;
    }

}
