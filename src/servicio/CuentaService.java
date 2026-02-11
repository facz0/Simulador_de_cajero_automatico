package servicio;

import java.util.ArrayList;

import datos.AlmacenDatos;
import modelos.Cuenta;
import modelos.Moneda;
import modelos.Transaccion;
import modelos.Usuario;

public class CuentaService {

	public void crearCuenta(Usuario usuario, Moneda moneda) {
		
		String numeroCuenta = "CTA-" + "11" + (AlmacenDatos.listaCuentas.size() + 4335) + "9867";
		Cuenta nuevaCuenta = new Cuenta();
		nuevaCuenta.setNumeroCuenta(numeroCuenta);
		nuevaCuenta.setUsuario(usuario);
		nuevaCuenta.setMoneda(moneda);
		nuevaCuenta.setSaldo(0.00);
		nuevaCuenta.setEstado("ACTIVA");
		nuevaCuenta.setMovimientos(new ArrayList<Transaccion>());
	}
	
}
