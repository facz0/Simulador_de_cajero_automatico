package servicio;

import modelos.Usuario;

public class Sesion {

    private static Usuario usuarioLogueado;
    
    public static void fijar(Usuario u) {
        usuarioLogueado = u;
        
    }
    public static Usuario obtener() {
        return usuarioLogueado;
    }
 
    public static void cerrar() {
        usuarioLogueado = null;
    }
}
