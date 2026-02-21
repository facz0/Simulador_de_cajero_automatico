package servicio;

import java.time.LocalDateTime;
import java.util.ArrayList;

import datos.AlmacenDatos;
import modelos.Cuenta;
import modelos.Transaccion;

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
	
	
	//separadoooooooooooooooooooooooooooooo => giancarlo
	
	//MÉTODO PARA LISTAR DE MANERA GENERAL LAS TRANSACCIONES, USAR PARA REPORTES
	public ArrayList<Transaccion> listarTransacciones(){
		return AlmacenDatos.listaTransacciones;
	}
	
	
	  // MÉTODO PARA LISTAR TRANSACCIONES POR RANGO DE FECHA
    // Retorna solo las transacciones cuya fecha esté entre inicio y fin

	public ArrayList<Transaccion> listarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin){

	    ArrayList<Transaccion> resultado = new ArrayList<>();

	    for(int i = 0; i < AlmacenDatos.listaTransacciones.size(); i++){

	        Transaccion t = AlmacenDatos.listaTransacciones.get(i);

	        // verificar que la fecha esté dentro del rango
	        if((t.getFecha().isEqual(inicio) || t.getFecha().isAfter(inicio)) &&
	           (t.getFecha().isEqual(fin) || t.getFecha().isBefore(fin))) {

	            resultado.add(t);
	        }
	    }

	    return resultado;
	}
	


 
 
 //separadooooooooooooooooooooooooooooooooooooooo  acabo GIANCARLO 
 
 
	
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
	
}
