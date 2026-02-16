package servicio;

import java.util.ArrayList;

import datos.AlmacenDatos;
import modelos.Moneda;

public class MonedaService {
	
	public ArrayList<Moneda> listarMoneda(){
		return AlmacenDatos.listaMonedas;
	}
	
	public void CrearMoneda(String idmoneda, String nombre, double tipoCambio) throws Exception {
		Moneda m = AlmacenDatos.monedaPorNombre(nombre);
		if(m != null) {
			throw new Exception("la moneda " + nombre + " ya existe");
		}
		Moneda nuevamoneda = new Moneda(idmoneda, nombre, tipoCambio);
		AlmacenDatos.listaMonedas.add(nuevamoneda);
	}
	
	public void ModificarMoneda(String simbolo, String nombre, double tipo) throws Exception{
		Moneda moneda = AlmacenDatos.monedaPorNombre(nombre);
		if (moneda == null) {
	        throw new Exception("La moneda no existe.");
	    }
		if(tipo <= 0) {
			throw new Exception("El tipo de cambio no puede ser menor que 0");
		}
		moneda.setNombre(nombre);
		moneda.setIdMoneda(simbolo);
		moneda.setTipoCambio(tipo);
	}
	
}
