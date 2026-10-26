package com.coleccion.model;

import com.coleccion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    /**
     * Elimina un juego por su ID
     * @param id ID del videojuego a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */

    public static boolean eliminarPorId(int id) {
        String sql = "DELETE FROM videojuegos WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el videojuego: " + e.getMessage());
            return false;
        }
    }
}
