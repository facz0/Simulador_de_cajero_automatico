package servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import modelos.Cuenta;
import modelos.Transaccion;

public class Consultas {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// CONSULTA DE SALDO
	public static ArrayList<Object[]> saldoFila(Cuenta cuenta) {
		ArrayList<Object[]> filas = new ArrayList<>();
		if (cuenta == null) return filas;

		filas.add(new Object[] {
				cuenta.getNumeroCuenta(),
				(cuenta.getMoneda() != null ? cuenta.getMoneda().getNombre() : "-"),
				String.format(Locale.US, "%.2f", cuenta.getSaldo()) 
		});
		return filas;
	}

	// CONSULTA DE ÚLTIMOS MOVIMIENTOS 
	public static ArrayList<Object[]> ultimosMovimientosFilas(Cuenta cuenta, int limite) {
		ArrayList<Object[]> filas = new ArrayList<>();
		if (cuenta == null) return filas;	
		if (limite <= 0) limite = 5;

		TransaccionService ts = new TransaccionService();
		ArrayList<Transaccion> movs = ts.listarPorCuenta(cuenta.getNumeroCuenta());
		if (movs == null || movs.isEmpty()) return filas;
		
		int cont = 0;
		for (int i = movs.size() - 1; i >= 0 && cont < limite; i--) {
			Transaccion t = movs.get(i);
			if (t == null) continue;
			filas.add(new Object[] {
					t.getFechaFormateada(),
					t.getTipo(),
					String.format(Locale.US, "%.2f", t.getMonto())
			});
			cont++;
		}
		return filas;
	}

	// CONSULTA DE MOVIMIENTOS POR RANGO 
	public static ArrayList<Object[]> movimientosPorRangoFilas(Cuenta cuenta, String desde, String hasta) {
		ArrayList<Object[]> filas = new ArrayList<>();
		if (cuenta == null) return filas;
		LocalDate f1 = parseFecha(desde);
		LocalDate f2 = parseFecha(hasta);
		if (f1 == null || f2 == null) return filas;
		if (f2.isBefore(f1)) return filas;
		
		TransaccionService ts = new TransaccionService();
		ArrayList<Transaccion> movs = ts.listarPorCuenta(cuenta.getNumeroCuenta());
		if (movs == null || movs.isEmpty()) return filas;

		for (int i = 0; i < movs.size(); i++) {
			Transaccion t = movs.get(i);
			if (t == null) continue;

			LocalDate ft = t.getFecha().toLocalDate();

			if ((ft.isEqual(f1) || ft.isAfter(f1)) && (ft.isEqual(f2) || ft.isBefore(f2))) {
				filas.add(new Object[] {
						t.getFechaFormateada(),
						t.getTipo(),
						String.format(Locale.US, "%.2f", t.getMonto())
				});
			}
		}

		return filas;
	}

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
