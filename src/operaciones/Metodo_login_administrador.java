package operaciones;

public class Metodo_login_administrador {
	// Constructor privado (opcional, evita instancias)
    private Metodo_login_administrador() {}

    // MÉTODO PÚBLICO (único acceso)
    public static boolean validarLogin(String tipoAcceso, String usuario, String password) {

        if ("MANTENIMIENTO".equals(tipoAcceso)) {
            return validarMantenimiento(usuario, password);
        }

        if ("REPORTES".equals(tipoAcceso)) {
            return validarReportes(usuario, password);
        }

        return false;
    }

    // MÉTODOS PRIVADOS (encapsulados)
    private static boolean validarMantenimiento(String usuario, String password) {
        return usuario.equals("admin") && password.equals("admin123");
    }

    private static boolean validarReportes(String usuario, String password) {
        return usuario.equals("admin") && password.equals("reporte123");
    }
}