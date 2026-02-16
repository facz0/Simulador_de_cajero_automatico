package servicio;

import datos.AlmacenDatos;
import modelos.Usuario;

public class AuthService {

    public Usuario autenticar(String dni, String clave) {

        if (dni == null || clave == null) return null;

        dni = dni.trim();
        clave = clave.trim();

        if (dni.isEmpty() || clave.isEmpty()) return null;

        Usuario u = AlmacenDatos.clientePorDni(dni);
        if (u == null) return null;

        if (!u.getPassword().equals(clave)) return null;

        return u;
    }
}
