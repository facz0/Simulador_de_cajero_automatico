package CLASES_REPORTE_ADMIN;

import datos.AlmacenDatos;
import modelos.Usuario;

public class Metodo_reporte_admin {

    /**
     * Busca un usuario por su NOMBRE
     * Devuelve el Usuario si existe
     * Devuelve null si no existe
     */
    public static Usuario clientePorNombre(String nombre) {

        for (int i = 0; i < AlmacenDatos.listaUsuarios.size(); i++) {

            Usuario user = AlmacenDatos.listaUsuarios.get(i);

            // Comparación por nombre
            if (user.getNombre().equalsIgnoreCase(nombre)) {
                return user;   // usuario encontrado
            }
        }

        return null; // no se encontró ningún usuario
    }
}
