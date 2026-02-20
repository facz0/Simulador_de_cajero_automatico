package servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import modelos.Cuenta;
import modelos.Transaccion;

public class Consultas {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//REFRESCAR MOVIMIENTOS DE CUENTA
	
	private static ArrayList<Transaccion> obtenerMovimientosCuenta(Cuenta cuenta) {
		ArrayList<Transaccion> movs = new ArrayList<>();

		if (cuenta == null) return movs;

		TransaccionService ts = new TransaccionService();
		ArrayList<Transaccion> lista = ts.listarPorCuenta(cuenta.getNumeroCuenta());

		if (lista == null) return movs;

		for (int i = 0; i < lista.size(); i++) {
			movs.add(lista.get(i));
		}

		return movs;
	}

	// CONSULTA DE SALDO
	
	public static ArrayList<Object[]> saldoFila(Cuenta cuenta) {

		ArrayList<Object[]> filas = new ArrayList<>();
		if (cuenta == null) return filas;

		Object[] fila = new Object[3];
		fila[0] = cuenta.getNumeroCuenta();
		fila[1] = (cuenta.getMoneda() != null ? cuenta.getMoneda().getNombre() : "-");
		fila[2] = String.format("%.2f", cuenta.getSaldo());

		filas.add(fila);
		return filas;
	}

	// ÚLTIMOS MOVIMIENTOS
	public static ArrayList<Object[]> ultimosMovimientosFilas(Cuenta cuenta, int limite) {

		ArrayList<Object[]> filas = new ArrayList<>();
		if (cuenta == null) return filas;

		if (limite <= 0) limite = 5;

		//vuelve a leer desde el ArrayList global
		ArrayList<Transaccion> movs = obtenerMovimientosCuenta(cuenta);

		if (movs == null || movs.isEmpty()) return filas;

		int cont = 0;

		for (int i = movs.size() - 1; i >= 0 && cont < limite; i--) {
			Transaccion t = movs.get(i);
			if (t == null) continue;

			Object[] fila = new Object[3];
			fila[0] = t.getFechaFormateada();
			fila[1] = t.getTipo();
			fila[2] = String.format("%.2f", t.getMonto());

			filas.add(fila);
			cont++;
		}

		return filas;
	}

	// MOVIMIENTOS POR RANGO
	public static ArrayList<Object[]> movimientosPorRangoFilas(Cuenta cuenta, String desde, String hasta) {

		ArrayList<Object[]> filas = new ArrayList<>();
		if (cuenta == null) return filas;

		LocalDate f1 = parseFecha(desde);
		LocalDate f2 = parseFecha(hasta);

		if (f1 == null || f2 == null) return filas;
		if (f2.isBefore(f1)) return filas;

		// vuelve a leer desde el ArrayList global
		ArrayList<Transaccion> movs = obtenerMovimientosCuenta(cuenta);

		if (movs == null || movs.isEmpty()) return filas;

		for (int i = 0; i < movs.size(); i++) {
			Transaccion t = movs.get(i);
			if (t == null) continue;

			LocalDate ft = t.getFecha().toLocalDate();

			if ((ft.isEqual(f1) || ft.isAfter(f1)) && (ft.isEqual(f2) || ft.isBefore(f2))) {

				Object[] fila = new Object[3];
				fila[0] = t.getFechaFormateada();
				fila[1] = t.getTipo();
				fila[2] = String.format("%.2f", t.getMonto());

				filas.add(fila);
			}
		}

		return filas;
	}

	// Parse fecha
	
	private static LocalDate parseFecha(String s) {

		if (s == null) return null;

		String x = s.trim();
		if (x.equalsIgnoreCase("DD/MM/AAAA")) return null;

		try {
			return LocalDate.parse(x, FORMATO);
		} catch (DateTimeParseException ex) {
			return null;
		}
	}
}
