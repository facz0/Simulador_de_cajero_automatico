package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
	public enum Tipo {Retiro, Deposito, Cambio_moneda}
	
	private static int contador;
	
	private String codigoOperacion;
	private LocalDateTime fecha;
	private Tipo tipo;
	private double monto;
	//private String descripcion;
	private String numeroCuenta;
	
	public Transaccion(String numeroCuenta, Tipo tipo, double monto) {
		contador++;
		this.codigoOperacion = String.format("TRX-%04d", contador);
		this.fecha = LocalDateTime.now();
		this.numeroCuenta = numeroCuenta;
		this.tipo = tipo;
		this.monto = monto;
		//this.descripcion = descripcion;
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
}

