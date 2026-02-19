package servicio;

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
	
}
