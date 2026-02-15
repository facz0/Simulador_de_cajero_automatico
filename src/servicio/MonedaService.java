package servicio;

import java.util.ArrayList;

import datos.AlmacenDatos;
import modelos.Moneda;

public class MonedaService {
	
	public ArrayList<Moneda> listarMoneda(){
		return AlmacenDatos.listaMonedas;
	}
	
}
