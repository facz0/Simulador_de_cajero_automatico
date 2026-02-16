package servicio;

import modelos.Usuario;

public class Sesion {

    private static Usuario usuarioActual;

    public static void iniciar(Usuario u) {
        usuarioActual = u;
    }

    public static Usuario obtener() {
        return usuarioActual;
    }

    public static void cerrar() {
        usuarioActual = null;
    }
}
