package datos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelos.Cuenta;
import modelos.Transaccion;

public class HistorialMovimientos {

    // Lista global de todas las transacciones del sistema
    private static final ArrayList<Transaccion> movimientosGlobal = new ArrayList<>();

    private HistorialMovimientos() { }

    // Registrar movimiento SOLO en historial global
    public static void registrarGlobal(Transaccion t) {
        if (t != null) {
            movimientosGlobal.add(t);
        }
    }

    // Registrar movimiento en cuenta Y en historial global
    public static void registrarMovimiento(Cuenta cuenta, Transaccion t) {
        if (cuenta == null || t == null) return;

        // Guardar en la cuenta
        if (cuenta.getMovimientos() != null) {
            cuenta.getMovimientos().add(t);
        }

        // Guardar en historial global
        movimientosGlobal.add(t);
    }

    // Obtener todos los movimientos (solo lectura)
    public static List<Transaccion> listarTodos() {
        return Collections.unmodifiableList(movimientosGlobal);
    }

    // Obtener movimientos por número de cuenta
    public static ArrayList<Transaccion> listarPorCuenta(String numeroCuenta) {
        ArrayList<Transaccion> resultado = new ArrayList<>();

        for (Transaccion t : movimientosGlobal) {
            if (t == null) continue;

            // Ajustado a tu modelo real (versión 3)
            if (numeroCuenta.equals(t.getNumeroCuenta())) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    // Limpiar historial (para pruebas)
    public static void limpiar() {
        movimientosGlobal.clear();
    }
}
