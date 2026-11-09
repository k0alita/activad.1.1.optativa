package com.coleccion.model;

import com.coleccion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoDAO {

    private static Videojuego mapearVideojuego(ResultSet rs) throws SQLException {
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
     * Añade un nuevo juego a la base de datos
     * @param v Objeto Videojuego a insertar
     * @return true si se insertó correctamente, false en caso contrario
     */
    public static boolean insertar(Videojuego v) {
        String sql = "INSERT INTO videojuegos (titulo, genero, plataforma, anio, valoracion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getTitulo());
            ps.setString(2, v.getGenero());
            ps.setString(3, v.getPlataforma());
            ps.setInt(4, v.getAnio());
            ps.setInt(5, v.getValoracion());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejamos la excepción si el título ya existe
            if (e.getErrorCode() == 1062) {
                System.out.println("Error: El título '" + v.getTitulo() + "' ya existe en la colección.");
            } else {
                System.out.println("Error al insertar el videojuego: " + e.getMessage());
            }
            return false;
        }
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


    /**
     * Muestra todos los juegos de la colección.
     *
     * @return Lista con todos los videojuegos ordenados por ID.
     */
    public static List<Videojuego> listarTodos() {
        List<Videojuego> lista = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos ORDER BY id ASC";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearVideojuego(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los videojuegos: " + e.getMessage());
        }
        return lista;
    }
}
