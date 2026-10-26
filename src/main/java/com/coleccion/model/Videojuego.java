package com.coleccion.model;

public class Videojuego {
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private int anio;
    private int valoracion;

    /**
     *
     * @param id Identificador único
     * @param titulo Titulo del juego
     * @param genero Género del juego
     * @param plataforma Plataforma en la que esta disponible el juego
     * @param anio Año de lanzamiento del juego
     * @param valoracion Valoracion del 1 al 10
     */
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

    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-25s | %-15s | %-15s | %-5d | %-2d/10 |",
                id, titulo, genero, plataforma, anio, valoracion);
    }
}
