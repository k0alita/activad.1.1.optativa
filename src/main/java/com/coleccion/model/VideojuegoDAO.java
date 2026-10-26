package com.coleccion.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideojuegoDAO {

    private Videojuego mapearVideojuego(ResultSet rs) throws SQLException {
        return new Videojuego(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("genero"),
                rs.getString("plataforma"),
                rs.getInt("anio"),
                rs.getInt("valoracion")
        );
    }
}
