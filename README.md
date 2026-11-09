# 🎮 Gestión de Colección de Videojuegos

Aplicación de consola desarrollada en **Java** y **MySQL** para la gestión de una colección personal de videojuegos. El proyecto se ha desarrollado bajo la metodología **Scrum**, aplicando buenas prácticas de ingeniería de software como el principio DRY (No repetición de código), documentación JavaDoc y control de versiones mediante **GitFlow** en **GitHub**.

---

## 🚀 Funcionalidades del Sistema
* **Añadir videojuego:** Permite registrar un nuevo título introduciendo título (único), género, plataforma, año y una valoración numérica del 1 al 10.
* **Eliminar por ID:** Borra un registro específico utilizando su clave primaria autoincremental.
* **Búsquedas personalizadas:** Filtrado flexible por título, plataforma o género utilizando consultas preparadas (`PreparedStatement`).
* **Listado general:** Muestra todos los juegos almacenados con formato tabular ordenado.
* **Filtrado por valoración:** Consulta rápida de los videojuegos mejor valorados de la colección ($\ge 8$).

---

## 🛠️ Requisitos Técnicos y Entorno
* **Java Development Kit (JDK):** Versión 17 o superior.
* **Gestor de dependencias:** Apache Maven.
* **Base de Datos:** MySQL Server (v8.0 o superior).
* **Driver JDBC:** `mysql-connector-j` integrado en Maven.

---

## 📂 Estructura del Proyecto
```text
src/
└── main/
    └── java/
        └── com/
            └── coleccion/
                ├── Principal.java          # Interfaz de texto y bucle principal del menú
                ├── ConexionDB.java         # Gestor centralizado de conexiones JDBC
                └── model/
                    ├── Videojuego.java     # Clase de dominio (Modelo)
                    └── VideojuegoDAO.java  # Capa de acceso a datos y consultas SQL
