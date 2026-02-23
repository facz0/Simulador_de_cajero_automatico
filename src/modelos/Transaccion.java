package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
	public enum Tipo {Retiro, Deposito, Cambio_moneda, Transferencia}
	
	private static int contador;
	
	private String codigoOperacion;
	private LocalDateTime fecha;
	private Tipo tipo;
	private double monto;
	private String numeroCuenta;
	
	public Transaccion(String numeroCuenta, Tipo tipo, double monto) {
		contador++;
		this.codigoOperacion = String.format("TRX-%04d", contador);
		this.fecha = LocalDateTime.now();
		this.numeroCuenta = numeroCuenta;
		this.tipo = tipo;
		this.monto = monto;
	}

	public static int getContador() {
		return contador;
	}

	public String getCodigoOperacion() {
		return codigoOperacion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public double getMonto() {
		return monto;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public String getFechaFormateada() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fecha.format(formato);
    }
	
	//Sirve para convertir la fecha de la transacción en texto con formato día/mes/año y no me aparesca  junto la hora como el codigo de arriba xd :c
	public String getSoloFechaFormateada() {
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    return fecha.format(formato);
	}
	
	
	public String getHoraFormateada() {
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
	    return fecha.format(formato);
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}

