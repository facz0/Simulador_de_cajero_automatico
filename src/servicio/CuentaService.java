package servicio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.AlmacenDatos;
import modelos.Cuenta;
import modelos.Moneda;
import modelos.Transaccion;
import modelos.Usuario;

public class CuentaService {
	
	public String generarNextNumeroCuenta() {
		return "CTA-" + "11" + (AlmacenDatos.listaCuentas.size() + 4335) + "9867";
	}

	public void crearCuenta(String numeroCuenta, Usuario usuario, Moneda moneda) throws Exception{
		if(AlmacenDatos.cuentaPorNumero(numeroCuenta) != null) {
			throw new Exception("Error: El número de cuenta " + numeroCuenta + " ya existe.");
		}
		
		if(usuario == null) {
			throw new Exception("Error: La cuenta debe tener un usuario asignado.");
		}
		
		Cuenta nuevaCuenta = new Cuenta();
		nuevaCuenta.setNumeroCuenta(numeroCuenta);
		nuevaCuenta.setUsuario(usuario);
		nuevaCuenta.setMoneda(moneda);
		nuevaCuenta.setSaldo(0.00);
		nuevaCuenta.setEstado("ACTIVA");
		nuevaCuenta.setMovimientos(new ArrayList<Transaccion>());
		
		AlmacenDatos.listaCuentas.add(nuevaCuenta);
	}
	
	public ArrayList<Cuenta> listarCuenta(){
		return AlmacenDatos.listaCuentas;
	}
	
}
