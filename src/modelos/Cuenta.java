package modelos;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	private String NumeroCuenta;
	private Usuario usuario;
	private Moneda moneda;
	private double saldo;
	private String estado;
	private ArrayList<Transaccion> movimientos;
	
	public Cuenta() {}
	
	public Cuenta(String NumeroCuenta, Usuario usuario, Moneda moneda, double saldo, String estado) {
		this.NumeroCuenta = NumeroCuenta;
		this.usuario = usuario;
		this.moneda = moneda;
		this.saldo = saldo;
		this.estado = estado;
		this.movimientos = new ArrayList<>();
	}

	public String getNumeroCuenta() {
		return NumeroCuenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Transaccion> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<Transaccion> movimientos) {
		this.movimientos = movimientos;
	}
	
	@Override
	public String toString() {
	    String simbolo = (moneda != null) ? moneda.getIdMoneda() : "";
	    return NumeroCuenta + "  |  " + simbolo + "  Saldo: " + String.format("%.2f", saldo);
	}

}


