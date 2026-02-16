package servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import modelos.Cuenta;
import modelos.Transaccion;

public class Consultas {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// ============================
	// SALDO
	// ============================
	public static String consultarSaldo(Cuenta cuenta) {
		if (cuenta == null) return "No se ha seleccionado ninguna cuenta.";

		StringBuilder sb = new StringBuilder();
		sb.append("===== CONSULTA DE SALDO =====\n");
		sb.append("Cuenta : ").append(cuenta.getNumeroCuenta()).append("\n");
		sb.append("Moneda : ").append(cuenta.getMoneda() != null ? cuenta.getMoneda().getNombre() : "-").append("\n");
		sb.append("Saldo  : ").append(String.format("%.2f", cuenta.getSaldo())).append("\n");
		sb.append("============================\n");
		return sb.toString();
	}

	// ============================
	// ÚLTIMOS MOVIMIENTOS (N)
	// ============================
	public static String ultimosMovimientos(Cuenta cuenta, int limite) {
		if (cuenta == null) return "No se ha seleccionado ninguna cuenta.";
		if (limite <= 0) limite = 5;

		ArrayList<Transaccion> movs = cuenta.getMovimientos();
		if (movs == null || movs.isEmpty()) return "No hay movimientos registrados para esta cuenta.";

		StringBuilder sb = new StringBuilder();
		sb.append("===== ÚLTIMOS MOVIMIENTOS =====\n");
		sb.append("Cuenta: ").append(cuenta.getNumeroCuenta()).append("\n\n");

		int cont = 0;
		for (int i = movs.size() - 1; i >= 0 && cont < limite; i--) {
			Transaccion t = movs.get(i);
			if (t == null) continue;
			sb.append(lineaTransaccion(t)).append("\n");
			cont++;
		}
		return sb.toString();
	}

	// ============================
	// MOVIMIENTOS POR RANGO (DD/MM/AAAA)
	// ============================
	public static String movimientosPorRango(Cuenta cuenta, String desde, String hasta) {
		if (cuenta == null) return "No se ha seleccionado ninguna cuenta.";

		LocalDate f1 = parseFecha(desde);
		LocalDate f2 = parseFecha(hasta);

		if (f1 == null || f2 == null) {
			return "Formato de fecha inválido. Use DD/MM/AAAA.\nEjemplo: 05/02/2026";
		}
		if (f2.isBefore(f1)) {
			return "Rango inválido: 'HASTA' no puede ser menor que 'DESDE'.";
		}

		ArrayList<Transaccion> movs = cuenta.getMovimientos();
		if (movs == null || movs.isEmpty()) return "No hay movimientos registrados para esta cuenta.";

		StringBuilder sb = new StringBuilder();
		sb.append("===== MOVIMIENTOS POR RANGO =====\n");
		sb.append("Cuenta: ").append(cuenta.getNumeroCuenta()).append("\n");
		sb.append("Desde : ").append(f1.format(FORMATO)).append("\n");
		sb.append("Hasta : ").append(f2.format(FORMATO)).append("\n\n");

		boolean hay = false;
		for (Transaccion t : movs) {
			if (t == null) continue;

			LocalDate ft = t.getFecha().toLocalDate();

			if ((ft.isEqual(f1) || ft.isAfter(f1)) && (ft.isEqual(f2) || ft.isBefore(f2))) {
				sb.append(lineaTransaccion(t)).append("\n");
				hay = true;
			}
		}

		if (!hay) sb.append("No existen movimientos en el rango indicado.\n");
		return sb.toString();
	}

	// ===== Helpers =====
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

	private static String lineaTransaccion(Transaccion t) {
		return String.format("%s | %s | %.2f",
				t.getFechaFormateada(),
				t.getTipo(),
				t.getMonto()
		);
	}
}
