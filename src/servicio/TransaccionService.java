package servicio;

import java.util.ArrayList;

import datos.AlmacenDatos;
import modelos.Cuenta;
import modelos.Moneda;
import modelos.Transaccion;
import modelos.Transaccion.Tipo;
import operaciones.Retiro_dinero;
import java.time.LocalDateTime;

public class TransaccionService {

	//MÉTODO PARA REGISTRAR LAS TRANSACCIONES DE MANERA GENERAL Y POR USUARIO
	public void registrarTransaccion(Cuenta cuenta, Transaccion transaccion) {
		if (cuenta == null || transaccion == null) return;
		AlmacenDatos.listaTransacciones.add(transaccion);
		if(cuenta.getMovimientos() == null) {
			cuenta.setMovimientos(new ArrayList<>());
		}
		cuenta.getMovimientos().add(transaccion);
	}
	
	//MÉTODO PARA LISTAR DE MANERA GENERAL LAS TRANSACCIONES, USAR PARA REPORTES
	public ArrayList<Transaccion> listarTransacciones(){
		return AlmacenDatos.listaTransacciones;
	}
	
	//MÉTODO PARA LISTAR LAS TRANSACCIONES POR USUARIO, USAR PARA CONSULTAS
	public ArrayList<Transaccion> listarPorCuenta(String numeroCuenta){
		ArrayList<Transaccion> movimientos = new ArrayList<>();
		for(int i = 0; i < AlmacenDatos.listaTransacciones.size(); i++) {
			Transaccion transaccion = AlmacenDatos.listaTransacciones.get(i);
			if(transaccion.getNumeroCuenta().equals(numeroCuenta)) {
				movimientos.add(transaccion);
			}
		}
		return movimientos;
	}
	
	public String RetiroDinero(double monto, Cuenta cuenta, String nombremonedaSolicitada) {
		String monedaCuenta = cuenta.getMoneda().getNombre();
		if(monedaCuenta.equals(nombremonedaSolicitada)) {
			if(cuenta.getSaldo() < monto) {
				return "Saldo insuficiente";
			}
			cuenta.setSaldo(cuenta.getSaldo() - monto);
			
			Transaccion tx = new Transaccion(cuenta.getNumeroCuenta(), Tipo.Retiro, monto);
			registrarTransaccion(cuenta, tx);
			return String.format(java.util.Locale.US, 
		            "EXITO\n\n--- DETALLE DEL RETIRO ---\n" +
		                    "Monto retirado: %.2f %s\n" +
		                    "Saldo disponible: %.2f %s", 
		                    monto, monedaCuenta, cuenta.getSaldo(), monedaCuenta);
		} else {
			Moneda moneda = null;
			for(int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
				if(AlmacenDatos.listaMonedas.get(i).getNombre().equals(nombremonedaSolicitada)) {
					moneda = AlmacenDatos.listaMonedas.get(i);
					break;
				}
			}
			
			if(moneda == null) {
				return "Moneda no reconocida por el sistema";
			}
			
			double cambioCuenta = cuenta.getMoneda().getTipoCambio();
			double cambioMonedaSeleccionada = moneda.getTipoCambio();
			double montoRetiro = (monto * cambioMonedaSeleccionada) / cambioCuenta;
			montoRetiro = Math.round(montoRetiro * 100.0) / 100.0;
			
			if(cuenta.getSaldo() < montoRetiro) {
				return "Saldo insuficiente";
			}
			
			cuenta.setSaldo(cuenta.getSaldo() - montoRetiro);
			Transaccion tx = new Transaccion(cuenta.getNumeroCuenta(), Tipo.Retiro, monto);
			registrarTransaccion(cuenta, tx);
			return String.format(java.util.Locale.US, 
		            "EXITO\n\n--- DETALLE DEL RETIRO CON CONVERSIÓN ---\n" +
		                    "Monto solicitado: %.2f %s\n" +
		                    "Monto descontado de tu cuenta: %.2f %s\n" +
		                    "Saldo disponible: %.2f %s", 
		                    monto, nombremonedaSolicitada, montoRetiro, monedaCuenta, cuenta.getSaldo(), monedaCuenta);
		}
	}
	
	public ArrayList<Transaccion> listarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin){

	    ArrayList<Transaccion> resultado = new ArrayList<>();

	    for(int i = 0; i < AlmacenDatos.listaTransacciones.size(); i++){

	        Transaccion t = AlmacenDatos.listaTransacciones.get(i);

	        if((t.getFecha().isEqual(inicio) || t.getFecha().isAfter(inicio)) &&
	           (t.getFecha().isEqual(fin) || t.getFecha().isBefore(fin))) {

	            resultado.add(t);
	        }
	    }

	    return resultado;
	}
	
}