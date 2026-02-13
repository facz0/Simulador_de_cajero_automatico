package servicio;

import java.util.ArrayList;
import datos.AlmacenDatos;

import modelos.Usuario;

public class UsuarioService {
	
	public void crearUsuario(String DNI, String nombre, String clave) throws Exception{
		Usuario u = AlmacenDatos.clientePorDni(DNI);
		if(u != null) {
			throw new Exception("Error: El DNI "+DNI+" ya está registrado");
		}
		Usuario nuevo = new Usuario(DNI, nombre, clave);
		AlmacenDatos.listaUsuarios.add(nuevo);
	}
	
	public void modificarUsuario(String dni, String nombre, String clave) throws Exception{
		Usuario user = AlmacenDatos.clientePorDni(dni);
		
		if(user == null) {
			throw new Exception("Error: El cliente no existe");
		}
		
		user.setNombre(nombre);
		
		if(clave != null && !clave.isEmpty()) {
			user.setPassword(clave);
		}
	}
	
	public void EliminarUsuario(String dni) throws Exception {
		
		Usuario user = AlmacenDatos.clientePorDni(dni);
		CuentaService cuenta = new CuentaService();
		cuenta.EliminarCuentaPorDni(dni);
		
		if(user == null) {
			throw new Exception("El usuario con DNI " + " no existe.");	
		}
		AlmacenDatos.listaUsuarios.remove(user);
		
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		return AlmacenDatos.listaUsuarios;
	}
}
