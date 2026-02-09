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
	
	public Cuenta(String NumeroCuenta, Usuario usuario, Moneda moneda, double saldo ) {
		this.NumeroCuenta = NumeroCuenta;
		this.usuario = usuario;
		this.moneda = moneda;
		this.saldo = saldo;
		this.movimientos = new ArrayList<>();
	}

	public String getNumeroCuenta() {
		return NumeroCuenta;
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
	
}


